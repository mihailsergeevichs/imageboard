package com.mihailsergeevichs.imageboard.services.impl;

import com.mihailsergeevichs.imageboard.entities.Board;
import com.mihailsergeevichs.imageboard.entities.Post;
import com.mihailsergeevichs.imageboard.entities.Topic;
import com.mihailsergeevichs.imageboard.repo.PostRepository;
import com.mihailsergeevichs.imageboard.repo.TopicRepository;
import com.mihailsergeevichs.imageboard.services.TopicService;
import com.mihailsergeevichs.imageboard.services.exception.TopicDoesNotExistException;
import com.mihailsergeevichs.imageboard.services.util.PostList;
import com.mihailsergeevichs.imageboard.services.util.TopicList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Overlord on 31.01.2016.
 */
@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    private TopicRepository topicRepository;

    private PostRepository postRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository, PostRepository postRepository) {
        this.topicRepository = topicRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Long blogId, Post post) {
        Topic topic = topicRepository.findOne(blogId);
        if(topic == null){
            throw new TopicDoesNotExistException();
        }
        post.setTopic(topic);
        postRepository.save(post);
        return post;
    }

    @Override
    public TopicList findAllTopics() {
        return new TopicList(topicRepository.findAll());
    }

    @Override
    public PostList findAllPosts(Long topicId) {
        Topic topic = topicRepository.findOne(topicId);
        if(topic == null){
            throw new TopicDoesNotExistException();
        }
        return new PostList(postRepository.findPostsByTopic(topic));
    }

    @Override
    public Topic findTopic(Long id) {
        Topic topic = topicRepository.findOne(id);
        if(topic == null){
            throw new TopicDoesNotExistException();
        }
        return topic;
    }
}
