package com.mihailsergeevichs.imageboard.service;

import com.mihailsergeevichs.imageboard.entity.Board;
import com.mihailsergeevichs.imageboard.entity.Post;
import com.mihailsergeevichs.imageboard.entity.Topic;
import java.util.Collection;
import java.util.List;

/**
 * Created by Overlord on 31.01.2016.
 */
public interface TopicService {

    List<Topic> findAllTopicsByBoardName(String boardname);

    Topic addNewTopic(String boardname, Topic topic);

    Topic updateTopic(Topic topic);

    Topic findTopicByTopicId(String boardname, Long topicid);

    Post addPostToTopic(Board board, Long topicid, Post post);

}
