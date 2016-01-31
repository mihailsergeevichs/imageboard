package com.mihailsergeevichs.imageboard.services.impl;

import com.mihailsergeevichs.imageboard.entities.Post;
import com.mihailsergeevichs.imageboard.repo.PostRepository;
import com.mihailsergeevichs.imageboard.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Overlord on 01.02.2016.
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findPost(Long id) {
        return postRepository.findOne(id);
    }
}
