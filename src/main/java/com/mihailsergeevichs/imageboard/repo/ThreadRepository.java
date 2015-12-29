package com.mihailsergeevichs.imageboard.repo;

import org.springframework.data.repository.Repository;
import com.mihailsergeevichs.imageboard.entity.Thread;

import java.util.List;
import java.util.Optional;

/**
 * Created by Overlord on 29.12.2015.
 */
public interface ThreadRepository extends Repository<Thread, Long> {

    void delete(Thread deleted);

    List<Thread> findAll();

    Optional<Thread> findOne(Long id);

    Thread save(Thread persisted);

}
