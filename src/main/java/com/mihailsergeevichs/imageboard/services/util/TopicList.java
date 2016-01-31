package com.mihailsergeevichs.imageboard.services.util;

import com.mihailsergeevichs.imageboard.entities.Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Overlord on 31.01.2016.
 */
public class TopicList {

    private List<Topic> topics = new ArrayList<Topic>();

    public TopicList(List<Topic> list) {
        this.topics = list;
    }

    public List<Topic> getAccounts() {
        return topics;
    }

    public void setAccounts(List<Topic> topics) {
        this.topics = topics;
    }
}
