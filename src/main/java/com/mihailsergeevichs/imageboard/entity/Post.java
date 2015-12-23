package com.mihailsergeevichs.imageboard.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by Overlord on 20.12.2015.
 */
@Entity
@Table(name = "POST")
public class Post extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CREATED", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime created;

    @Column(name = "SAGE")
    private boolean sage;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "THEME", length = 55, nullable = true)
    private String theme;

    @Lob
    @Column(name = "TEXT")
    private String text;

    @ManyToOne
    private Thread thread;

    @Override
    public Long getId() {
        return id;
    }

    public Post(DateTime created, boolean sage, String author, String theme, String text, Thread thread) {
        this.created = created;
        this.sage = sage;
        this.author = author;
        this.theme = theme;
        this.text = text;
        this.thread = thread;
        if(author == null){
            author = "Anonymous";
        }
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", created=" + created +
                ", created=" + theme +
                ", sage=" + sage +
                ", author='" + author + '\'' +
                ", text='" + text.length() + '\'' +
                ", thread=" + thread.getId() +
                '}';
    }

    public Post() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        if (isSage() != post.isSage()) return false;
        if (!getId().equals(post.getId())) return false;
        if (!getCreated().equals(post.getCreated())) return false;
        if (!getAuthor().equals(post.getAuthor())) return false;
        if (!getTheme().equals(post.getTheme())) return false;
        if (!getText().equals(post.getText())) return false;
        return getThread().equals(post.getThread());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCreated().hashCode();
        result = 31 * result + (isSage() ? 1 : 0);
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getTheme().hashCode();
        result = 31 * result + getText().hashCode();
        result = 31 * result + getThread().hashCode();
        return result;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public boolean isSage() {
        return sage;
    }

    public void setSage(boolean sage) {
        this.sage = sage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
