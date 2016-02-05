package com.mihailsergeevichs.imageboard.service;

import com.mihailsergeevichs.imageboard.entity.Board;

import java.util.Collection;
import java.util.List;

/**
 * Created by Overlord on 31.01.2016.
 */
public interface BoardService {
    
    List<Board> findAllBoards();

    Board findBoardByBoardname(String boardName);

    Board addNewBoard(Board board);

}
