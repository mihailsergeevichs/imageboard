package com.mihailsergeevichs.imageboard.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Overlord on 31.01.2016.
 */
@Entity
public class Topic {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Board board;

    public Topic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
