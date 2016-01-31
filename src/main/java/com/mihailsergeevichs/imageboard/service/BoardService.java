package com.mihailsergeevichs.imageboard.service;

import com.mihailsergeevichs.imageboard.entity.Board;
import com.mihailsergeevichs.imageboard.entity.Thread;
import java.util.List;

/**
 * Created by Overlord on 29.12.2015.
 */
public interface BoardService {

    Board findBoardByBoardName(String boardName);

    List<Board> getAllBoards();

    void addBoard(Board board);

    void addThread(Thread thread, String boardName);
    
}
