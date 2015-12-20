package com.mihailsergeevichs.imageboard.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Overlord on 20.12.2015.
 */
@MappedSuperclass
public abstract class BaseEntity<ID> {

    @Column(name = "created", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime created;

    @Column(name = "modified", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modified;

    @Version
    private long version;

    public abstract ID getId();

    @PrePersist
    public void prePersist() {
        DateTime current = DateTime.now();
        this.created = current;
        this.modified = current;
    }

    @PreUpdate
    public void preUpdate() {
        this.modified = DateTime.now();
    }


}
