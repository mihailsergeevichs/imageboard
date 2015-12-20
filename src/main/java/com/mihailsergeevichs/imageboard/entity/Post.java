package com.mihailsergeevichs.imageboard.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Overlord on 20.12.2015.
 */
@Entity
@Table(name = "POST")
public class Post extends BaseEntity<Long> {


    @Override
    public Long getId() {
        return null;
    }
}
