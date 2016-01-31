package com.mihailsergeevichs.imageboard.service;

import com.mihailsergeevichs.imageboard.entity.*;
import com.mihailsergeevichs.imageboard.repo.ThreadRepository;
import com.mihailsergeevichs.imageboard.entity.Thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by Overlord on 30.01.2016.
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    private final static Logger logger = LoggerFactory.getLogger(ThreadService.class);

    @Autowired
    ThreadRepository threadRepository;

    @Override
    public void addPost(Post post, Long threadId) {
        logger.debug("Invocation post adding method. Post is {} thread id is {}", post, threadId);
        Thread thread = threadRepository.findOne(threadId);
        thread.getPosts().add(post);
        if((thread.getPosts().size() < 500) || post.isSage()){
            ImageboardUtils.bumpThread(thread.getBoard(), post.getThread());
        }
        threadRepository.save(thread);
    }

    @Override
    public List<Post> getAllPostsFromThread(Long threadId) {
        return threadRepository.findOne(threadId).getPosts();
    }
}
