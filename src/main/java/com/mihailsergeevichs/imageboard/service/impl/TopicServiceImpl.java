package com.mihailsergeevichs.imageboard.service.impl;

import com.mihailsergeevichs.imageboard.entity.Board;
import com.mihailsergeevichs.imageboard.entity.Post;
import com.mihailsergeevichs.imageboard.entity.Topic;
import com.mihailsergeevichs.imageboard.repo.BoardRepository;
import com.mihailsergeevichs.imageboard.repo.TopicRepository;
import com.mihailsergeevichs.imageboard.service.TopicService;
import com.mihailsergeevichs.imageboard.service.exception.BoardDoesNotExistException;
import com.mihailsergeevichs.imageboard.service.exception.TopicDoesNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Overlord on 04.02.2016.
 */
@Service
public class TopicServiceImpl implements TopicService {

    private final static Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);

    private final static int BOARD_SIZE = 50;

    private BoardRepository boardRepository;

    private TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(BoardRepository boardRepository, TopicRepository topicRepository){
        this.boardRepository = boardRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> findAllTopicsByBoardName(String boardname) {
        logger.info("Invocation findAllTopicsByBoardName method with boardname", boardname);
        Board board = boardRepository.findByBoardname(boardname);
        if(board == null){
            logger.info("Board with name {} does not exist", boardname);
            throw new BoardDoesNotExistException();
        }
        List<Topic> topics = topicRepository.findByBoard(board);
        logger.debug("Founded collection with {} topics. Proceeding execution", topics.size());
        return topics;
    }

    @Override
    public Topic addNewTopic(String boardname, Topic topic) {
        logger.info("Invocation addNewTopic method with boardname and topic", boardname, topic);
        Board board = boardRepository.findByBoardname(boardname);
        if(board == null){
            logger.info("Board with name {} does not exist", boardname);
            throw new BoardDoesNotExistException();
        }
        topic.setBoard(board);
        board.getTopics().add(0, topic);
        trimBoardToCertainSize(board, BOARD_SIZE);
        boardRepository.save(board);
        logger.debug("Topic {} persisted", topic);
        return topic;
    }

    @Override
    public Topic updateTopic(Topic topic) {
        logger.debug("Invocation updateTopic method with topic {}", topic);
        topicRepository.save(topic);
        return topic;
    }

    @Override
    public Topic findTopicByTopicId(String boardname, Long topicid) {
        Topic topic = topicRepository.findOne(topicid);
        if(topic == null){
            throw new TopicDoesNotExistException();
        }
        return topic;
    }

    @Override
    public Post addPostToTopic(Board board, Long topicid, Post post) {
        Topic topic = topicRepository.findOne(topicid);
        List<Post> posts = topic.getPosts();
        List<Topic> topics = board.getTopics();
        posts.add(post);
        if(post.isSage() || !(post.getAuthor().equals("sage"))){
            bumpThread(board, topic);
        }
        boardRepository.save(board);
        return post;
    }


    private final static void trimBoardToCertainSize(Board board, int boardSize){
        List<Topic> topics = board.getTopics();
        topics = topics.subList(0, boardSize);
        board.setTopics(topics);
    }

    private final static void bumpThread(Board board, Topic topic){
        List<Topic> topics = board.getTopics();
        topics.set(0, topic);
    }
}
