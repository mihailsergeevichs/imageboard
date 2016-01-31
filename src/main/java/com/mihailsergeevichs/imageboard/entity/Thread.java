package com.mihailsergeevichs.imageboard.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Overlord on 20.12.2015.
 */
@Entity
@Table(name = "THREAD")
public class Thread extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Board board;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "thread")
    private List<Post> posts;

    public Thread(String theme) {
        posts = new LinkedList<>();
    }

    public Thread() {
    }

    @Override
    public String toString() {
        return "Thread{" +
                "id=" + id +
                ", board=" + board.getBoardName() +
                ", posts=" + posts.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Thread)) return false;

        Thread thread = (Thread) o;

        if (!getId().equals(thread.getId())) return false;
        if (!getBoard().equals(thread.getBoard())) return false;
        return getPosts().equals(thread.getPosts());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getBoard().hashCode();
        result = 31 * result + getPosts().hashCode();
        return result;
    }

    @Override
    public Long getId() {
        return id;
    }
    
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
