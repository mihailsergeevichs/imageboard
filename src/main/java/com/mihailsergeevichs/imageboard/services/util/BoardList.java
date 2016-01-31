package com.mihailsergeevichs.imageboard.services.util;

import com.mihailsergeevichs.imageboard.entities.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Overlord on 31.01.2016.
 */
public class BoardList {

    private List<Board> boards = new ArrayList<Board>();

    public BoardList(List<Board> list) {
        this.boards = list;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
}
