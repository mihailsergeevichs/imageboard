package com.mihailsergeevichs.imageboard.services.util;

import com.mihailsergeevichs.imageboard.entities.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Overlord on 31.01.2016.
 */
public class PostList {

    private List<Post> posts = new ArrayList<Post>();

    public PostList(List<Post> list) {
        this.posts = list;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
