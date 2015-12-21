package com.mihailsergeevichs.imageboard.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Overlord on 20.12.2015.
 */
@Entity
@Table(name = "POST")
public class Post extends BaseEntity<Long> {




    @Column(name = "CREATED", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime created;


    @Override
    public Long getId() {
        return null;
    }
}
