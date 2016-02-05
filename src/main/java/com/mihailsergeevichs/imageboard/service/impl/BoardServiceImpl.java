package com.mihailsergeevichs.imageboard.service.impl;

import com.mihailsergeevichs.imageboard.entity.Board;
import com.mihailsergeevichs.imageboard.repo.BoardRepository;
import com.mihailsergeevichs.imageboard.service.BoardService;
import com.mihailsergeevichs.imageboard.service.exception.BoardAlreadyExistedException;
import com.mihailsergeevichs.imageboard.service.exception.BoardDoesNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Overlord on 04.02.2016.
 */
@Service
public class BoardServiceImpl implements BoardService {

    private final static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Board> findAllBoards() {
        logger.info("Invocation findAll method");
        return boardRepository.findAll();
    }

    @Override
    public Board findBoardByBoardname(String boardName) {
        logger.debug("Invocation findBoardByBoardName method");
        Board board = boardRepository.findByBoardname(boardName);
        if(board == null){
            logger.info("Board with boardName {} does not exist", boardName);
            throw new BoardDoesNotExistException();
        }
        logger.info("Founded board with boardName ", boardName);
        return board;
    }

    @Override
    public Board addNewBoard(Board board) {
        logger.info("Invocation addNewBoard method");
//        Board existed = boardRepository.findByBoardname(board.getBoardname());
//        if(board != null){
//            logger.info("Board with boardName {} already exist", board.getBoardname());
//            throw new BoardAlreadyExistedException();
//        }
        boardRepository.save(board);
        return board;
    }
}
