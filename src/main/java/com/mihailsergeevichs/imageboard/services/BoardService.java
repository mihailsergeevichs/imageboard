package com.mihailsergeevichs.imageboard.services;

import com.mihailsergeevichs.imageboard.entities.Board;
import com.mihailsergeevichs.imageboard.entities.Topic;
import com.mihailsergeevichs.imageboard.services.util.BoardList;
import com.mihailsergeevichs.imageboard.services.util.TopicList;

/**
 * Created by Overlord on 31.01.2016.
 */
public interface BoardService {
    
    public Board findBoard(Long id);
    
    public Board createBoard(Board data);
    
    public Topic createTopic(String boardName, Topic data);
    
    public TopicList findTopicsByBoard(String boardName);
    
    public BoardList findAllBoards();
    
    public Board findByBoardName(String name);
}
