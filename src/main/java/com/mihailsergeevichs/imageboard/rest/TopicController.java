package com.mihailsergeevichs.imageboard.rest;

import com.mihailsergeevichs.imageboard.entity.Board;
import com.mihailsergeevichs.imageboard.entity.Post;
import com.mihailsergeevichs.imageboard.service.BoardService;
import com.mihailsergeevichs.imageboard.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Overlord on 03.02.2016.
 */
@RestController
public class TopicController {

    private TopicService topicService;

    private BoardService boardService;

    @Autowired
    public TopicController(TopicService topicService, BoardService boardService){
        this.boardService =boardService;
        this.topicService = topicService;
    }

    @RequestMapping(value = "imageboard/{boardname}/{topicid}", method = RequestMethod.GET)
    public Collection<Post> getAllPostsFromTopic(@PathVariable("boardname") String boardname,
                                           @PathVariable("topicid") Long topicid){
        return topicService.findTopicByTopicId(boardname, topicid).getPosts();
    }

    @RequestMapping(value = "imageboard/{boardname/{topicid}}", method = RequestMethod.POST)
    public Post addPostToTopic(@PathVariable("boardname") String boardname,
                                @PathVariable("topicid") Long topicid, @RequestBody Post post){

        Board board = boardService.findBoardByBoardname(boardname);
        topicService.addPostToTopic(board, topicid, post);
        return post;
    }

}
