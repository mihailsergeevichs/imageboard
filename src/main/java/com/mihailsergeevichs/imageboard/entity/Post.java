package com.mihailsergeevichs.imageboard.entity;

import javax.persistence.*;

/**
 * Created by Overlord on 31.01.2016.
 */
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long postid;

    private String author;

    private boolean sage;

    private String date;

    private String text;

    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;

    public Post() {
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public boolean isSage() {
        return sage;
    }

    public void setSage(boolean sage) {
        this.sage = sage;
    }
}
