package com.mihailsergeevichs.imageboard.controller;

import com.mihailsergeevichs.imageboard.entity.Board;
import com.mihailsergeevichs.imageboard.repo.BoardRepository;
import com.mihailsergeevichs.imageboard.repo.ThreadRepository;
import com.mihailsergeevichs.imageboard.service.BoardService;
import com.mihailsergeevichs.imageboard.service.BoardServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Overlord on 22.12.2015.
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ThreadRepository threadRepository;

    @Autowired
    BoardService boardService;

    private final static String VIEW_NAME_INDEX_PAGE = "index";

    /*
    *This method returns index page view
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage(){
        logger.info("Rendering index page");
        boardRepository.findAll();
        logger.info("dergaju boardRepository");
        threadRepository.findAll();
        logger.info("dergaju threadRepository");

        Board board = new Board("au", "automobiles");
        logger.info("Board is" + board);
        boardService.addBoard(board);

        List<Board> boards = boardService.getAllBoards();
        logger.info("board list size is" + boards.size());
        logger.info("board is" + boards.get(0).toString());

        return VIEW_NAME_INDEX_PAGE;
    }
}
