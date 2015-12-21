package com.mihailsergeevichs.imageboard.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
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

    @ManyToOne
    private Board board;

    private Set<Post> posts;

    @Override
    public Long getId() {
        return null;
    }
}
