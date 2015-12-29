package com.mihailsergeevichs.imageboard.service;

import com.mihailsergeevichs.imageboard.entity.Thread;
import java.util.List;
import java.util.Optional;

/**
 * Created by Overlord on 29.12.2015.
 */
public interface BoardService {

    Optional<Thread> findOne(Long id);

    List<Thread> getAllThreads(String boardName);

    void addThread(Thread thread, String boardName);

    void trimBoardToBoardSize(String boardName, int boardSize);

    void swapThreadPosition(List<Thread> existed);
}
