package com.mihailsergeevichs.imageboard.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by Overlord on 20.12.2015.
 */
@Entity
@Table(name = "POST")
public class Post extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "POSTED", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime posted;

    @Column(name = "SAGE")
    private boolean sage;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "THEME", length = 55, nullable = true)
    private String theme;

    @Column(name = "TEXT", nullable = false)
    private String text;

    @Lob
    @Column(name = "IMAGE")
    private byte[] image;

    @ManyToOne
    private Thread thread;

    @Override
    public Long getId() {
        return id;
    }

    public Post(DateTime posted, boolean sage, String author, String theme, String text, byte[] image, Thread thread) {
        this.posted = posted;
        this.sage = sage;
        this.author = author;
        this.theme = theme;
        this.text = text;
        this.image = image;
        this.thread = thread;
        if(author == null){
            author = "Anonymous";
        }
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", posted=" + posted +
                ", sage=" + sage +
                ", author='" + author + '\'' +
                ", theme='" + theme + '\'' +
                ", text='" + text.length() + '\'' +
                ", image=" + image.length +
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
        if (!Arrays.equals(image, post.image)) return false;
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
        result = 31 * result + Arrays.hashCode(image);
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
        return posted;
    }

    public void setCreated(DateTime posted) {
        this.posted = posted;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
