package com.mihailsergeevichs.imageboard.services.impl;

import com.mihailsergeevichs.imageboard.entities.Board;
import com.mihailsergeevichs.imageboard.entities.Topic;
import com.mihailsergeevichs.imageboard.repo.BoardRepository;
import com.mihailsergeevichs.imageboard.repo.TopicRepository;
import com.mihailsergeevichs.imageboard.services.BoardService;
import com.mihailsergeevichs.imageboard.services.exception.BoardAlreadyExistedException;
import com.mihailsergeevichs.imageboard.services.exception.BoardDoesNotExistException;
import com.mihailsergeevichs.imageboard.services.exception.TopicAlreadyExistedException;
import com.mihailsergeevichs.imageboard.services.util.BoardList;
import com.mihailsergeevichs.imageboard.services.util.TopicList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Overlord on 31.01.2016.
 */
@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    private TopicRepository topicRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository, TopicRepository topicRepository) {
        this.boardRepository = boardRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public Board findBoard(Long id) {
        Board board = boardRepository.findOne(id);
        if(board == null){
            throw new BoardDoesNotExistException();
        }
        return board;
    }

    @Override
    public Board createBoard(Board data) {
        Board board = boardRepository.findBoardByName(data.getName());
        if(board != null){
            throw new BoardAlreadyExistedException();
        }
        boardRepository.save(data);
        return board;
    }

    @Override
    public Topic createTopic(String boardName, Topic data) {
        Topic topic = topicRepository.findOne(data.getId());
        if(topic != null){
            throw new TopicAlreadyExistedException();
        }
        Board board = boardRepository.findBoardByName(boardName);
        if(board == null){
            throw new BoardDoesNotExistException();
        }
        data.setBoard(board);
        topicRepository.save(data);
        return data;
    }

    @Override
    public TopicList findTopicsByBoard(String boardName) {
        Board board = boardRepository.findBoardByName(boardName);
        if(board == null){
            throw new BoardDoesNotExistException();
        }
        return new TopicList(topicRepository.findTopicByBoard(board));
    }

    @Override
    public BoardList findAllBoards() {
        return new BoardList(boardRepository.findAll());
    }

    @Override
    public Board findByBoardName(String name) {
        return boardRepository.findBoardByName(name);
    }
}
