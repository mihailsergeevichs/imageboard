package com.mihailsergeevichs.imageboard.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Overlord on 20.12.2015.
 */
@Entity
@Table(name = "BOARDS")
public class Board extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "BOARDNAME", nullable = false, unique = true)
    private String boardName;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "board")
    private List<Thread> threads;

    public Board(){}

    public Board(String boardName, String description){
        this.boardName = boardName;
        this.description = description;
        threads = new LinkedList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", boardName='" + boardName + '\'' +
                ", description='" + description + '\'' +
                ", with " + threads.size() +  " threads" +  +
                '}';
    }
}
