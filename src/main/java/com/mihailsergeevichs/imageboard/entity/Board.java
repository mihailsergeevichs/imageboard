package com.mihailsergeevichs.imageboard.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Overlord on 20.12.2015.
 */
@Entity
@Table(name = "BOARDS")
public class Board extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "BOARDNAME", nullable = false)
    private String boardName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "board")
    private Set<Thread> threads;

    public Board(){}

    @Override
    public Long getId() {
        return null;
    }
}
