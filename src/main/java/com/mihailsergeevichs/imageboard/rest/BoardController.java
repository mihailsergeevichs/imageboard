package com.mihailsergeevichs.imageboard.rest;

import com.mihailsergeevichs.imageboard.entity.Topic;
import com.mihailsergeevichs.imageboard.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Overlord on 03.02.2016.
 */
@RestController
public class BoardController {

    private TopicService topicService;

    @Autowired
    public BoardController(TopicService topicService){
        this.topicService = topicService;
    }

    @RequestMapping(value = "imageboard/{boardname}", method = RequestMethod.GET)
    Collection<Topic> findAllTopicsOnTheBoard(@PathVariable("boardname") String boardname){
        return topicService.findAllTopicsByBoardName(boardname);
    }

    @RequestMapping(value = "imageboard/{boardname}", method = RequestMethod.POST)
    Topic addNewTopicToTheBoard(@PathVariable("boardname") String boardname, @RequestBody Topic topic){
        topicService.addNewTopic(boardname, topic);
        return topic;
    }
}
