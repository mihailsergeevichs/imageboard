package com.mihailsergeevichs.imageboard.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Overlord on 20.12.2015.
 */
@Entity
@Table(name = "THREAD")
public class Thread extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "THEME", length = 55, nullable = true)
    private String theme;

    @Embedded
    private Post opPost;

    @ManyToOne
    private Board board;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "thread")
    private Set<Post> posts;

    public Thread(String theme, Post opPost) {
        this.theme = theme;
        this.opPost = opPost;
        posts = new HashSet<>(500);
    }

    public Thread() {
    }

    @Override
    public String toString() {
        return "Thread{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", opPost=" + opPost.getId() +
                ", board=" + board.getBoardId() +
                ", posts=" + posts.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Thread)) return false;

        Thread thread = (Thread) o;

        if (!getId().equals(thread.getId())) return false;
        if (!getTheme().equals(thread.getTheme())) return false;
        if (!getOpPost().equals(thread.getOpPost())) return false;
        if (!getBoard().equals(thread.getBoard())) return false;
        return getPosts().equals(thread.getPosts());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getTheme().hashCode();
        result = 31 * result + getOpPost().hashCode();
        result = 31 * result + getBoard().hashCode();
        result = 31 * result + getPosts().hashCode();
        return result;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Post getOpPost() {
        return opPost;
    }

    public void setOpPost(Post opPost) {
        this.opPost = opPost;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
