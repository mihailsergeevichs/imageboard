package com.mihailsergeevichs.imageboard.rest;

import com.mihailsergeevichs.imageboard.entity.Board;
import com.mihailsergeevichs.imageboard.entity.Post;
import com.mihailsergeevichs.imageboard.entity.Topic;
import com.mihailsergeevichs.imageboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by Overlord on 03.02.2016.
 */
@RestController
public class IndexController {

    private BoardService boardService;

    @Autowired
    public IndexController(BoardService boardService){
        this.boardService = boardService;
    }

    @RequestMapping(value = "imageboard/", method = RequestMethod.GET)
    List<Board> getAllBoards(){
//        Board board = new Board();
//        board.setBoardname("b");
//        board.setDescription("Random");
//        Topic topic = new Topic();
//        topic.setBoard(board);
//        Post post = new Post();
//        post.setAuthor("anonymous");
//        post.setSage(true);
//        post.setDate("12345");
//        post.setImage("image");
//        post.setText("first post text post!");
//        post.setTopic(topic);
//        topic.getPosts().add(post);
//        boardService.addNewBoard(board);
        return boardService.findAllBoards();
    }

    @RequestMapping(value = "imageboard/", method = RequestMethod.POST)
    Board addNewBoard(@RequestBody Board board){
        boardService.addNewBoard(board);
        return board;
    }
}
