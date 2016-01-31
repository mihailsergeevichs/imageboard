package com.mihailsergeevichs.imageboard.service;

import com.mihailsergeevichs.imageboard.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mihailsergeevichs.imageboard.entity.Thread;

import java.util.List;

/**
 * Created by Overlord on 30.01.2016.
 */
@Component
public class ImageboardUtils {

    private static final Logger logger = LoggerFactory.getLogger(ImageboardUtils.class);

    /*
    * Trimming list of threads on the board to partial size
    * @param board - board which trimming
    * @param size - number of threads on the board
     */
    public static void trimBoardToSize(Board board, int size){
        logger.debug("Invocation trimming to certain size method. Board is {} size is {}", board, size);
        List<Thread> threads = board.getThreads();
        threads.subList(0, size - 1);
    }

    /*
    * "Bumping" thread method. Set thread range number at 0 position in board list. Uses when post adding to the thread
    * @param board - board which contain current thread
    * @param thread - current thread which range number modifying
     */
    public static void bumpThread(Board board, Thread thread){
        logger.debug("Invocation thread bumping method. Thread {} at the board {} is bumping", thread, board);
        board.getThreads().set(0, thread);
    }
}
