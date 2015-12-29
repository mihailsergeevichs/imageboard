package com.mihailsergeevichs.imageboard.service;
import com.mihailsergeevichs.imageboard.entity.Post;
import  com.mihailsergeevichs.imageboard.entity.Thread;

import java.util.List;

/**
 * Created by Overlord on 29.12.2015.
 */
public interface ThreadService {

    void addPost(Post post, Long threadId);

    List<Post> getAllPostsFromThread(Long threadId);

    void addPost(Long threadId);

    boolean checkPostCount(Thread thread);

}
