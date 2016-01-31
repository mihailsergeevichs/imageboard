package com.mihailsergeevichs.imageboard.repo;

import com.mihailsergeevichs.imageboard.entities.Board;
import com.mihailsergeevichs.imageboard.entities.Topic;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Overlord on 31.01.2016.
 */
public interface TopicRepository extends Repository<Topic, Long> {

    void delete(Topic deleted);

    List<Topic> findAll();

    Topic findOne(Long id);

    Topic save(Topic persisted);

    List<Topic> findTopicByBoard(Board board);
}
