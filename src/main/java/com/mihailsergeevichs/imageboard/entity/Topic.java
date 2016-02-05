package com.mihailsergeevichs.imageboard.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Overlord on 31.01.2016.
 */
@Entity
public class Topic {

    @Id
    @GeneratedValue
    private Long topicid;

    @ManyToOne
    private Board board;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    private List<Post> posts = new ArrayList<>();

    public Topic() {
    }

    public Long getTopicid() {
        return topicid;
    }

    public void setTopicid(Long topicid) {
        this.topicid = topicid;
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
