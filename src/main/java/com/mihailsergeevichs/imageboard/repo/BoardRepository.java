package com.mihailsergeevichs.imageboard.repo;

import com.mihailsergeevichs.imageboard.entities.Board;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Overlord on 31.01.2016.
 */
public interface BoardRepository extends Repository<Board, Long> {

    void delete(Board deleted);

    List<Board> findAll();

    Board findOne(Long id);

    Board save(Board persisted);

    Board findBoardByName(String name);

}
