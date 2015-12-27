package com.mihailsergeevichs.imageboard.DTO;

import org.hibernate.validator.constraints.Length;

/**
 * Created by Overlord on 23.12.2015.
 */
public class PostDTO {

    @Length(max = 55)
    private String author;

    private boolean sage;

    @Length(min = 1, max = 2500, message = "Post should be not empty and less than 2500 characters.")
    private String text;

    @Length(max = 55 )
    private String theme;

    public PostDTO(String author, boolean sage, String text, String theme) {
        this.author = author;
        this.sage = sage;
        this.text = text;
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "author='" + author + '\'' +
                ", sage=" + sage +
                ", text='" + text + '\'' +
                ", theme='" + theme + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isSage() {
        return sage;
    }

    public void setSage(boolean sage) {
        this.sage = sage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
