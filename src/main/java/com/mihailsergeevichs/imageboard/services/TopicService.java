package com.mihailsergeevichs.imageboard.services;

import com.mihailsergeevichs.imageboard.entities.Post;
import com.mihailsergeevichs.imageboard.entities.Topic;
import com.mihailsergeevichs.imageboard.services.util.PostList;
import com.mihailsergeevichs.imageboard.services.util.TopicList;

/**
 * Created by Overlord on 31.01.2016.
 */
public interface TopicService {

    public Post createPost(Long topicId, Post post);

    public TopicList findAllTopics();

    public PostList findAllPosts(Long topicId);

    public Topic findTopic(Long id);
}
