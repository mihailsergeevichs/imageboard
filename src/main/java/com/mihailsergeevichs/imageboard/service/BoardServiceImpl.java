package com.mihailsergeevichs.imageboard.service;

import com.mihailsergeevichs.imageboard.entity.*;
import com.mihailsergeevichs.imageboard.repo.BoardRepository;
import com.mihailsergeevichs.imageboard.service.exception.BoardDoesNotExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.mihailsergeevichs.imageboard.entity.Thread;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Overlord on 30.01.2016.
 */
@Service
public class BoardServiceImpl implements BoardService {

    private final static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Board findBoardByBoardName(String boardName) {
        logger.debug("Searching board with board name" + boardName);
        Board board =  boardRepository.findBoardByBoardName(boardName);
        if(board == null){
            logger.debug("Board {} is absent. Throwing exception", boardName);
            throw new BoardDoesNotExistsException();
        }
        logger.debug("Founded board {}", board);
        return board;
    }

    @Override
    public List<Board> getAllBoards() {
        logger.debug("Invocation getAllBoards method");
        return boardRepository.findAll();
    }

    @Override
    public void addBoard(Board board) {
        logger.debug("Invocation board adding method. {}. Board is ", board);
        boardRepository.save(board);
    }

    @Override
    public void addThread(Thread thread, String boardName) {
        logger.debug("Invocation adding thread method. Adding thread {} to board {}", thread, boardName);
        Board board = findBoardByBoardName(boardName);
        board.getThreads().add(0, thread);
        ImageboardUtils.trimBoardToSize(board, 50);
        boardRepository.save(board);
    }
}
