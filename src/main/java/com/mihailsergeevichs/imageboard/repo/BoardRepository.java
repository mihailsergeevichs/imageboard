package com.mihailsergeevichs.imageboard.repo;

import com.mihailsergeevichs.imageboard.entity.Board;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Overlord on 29.12.2015.
 */
public interface BoardRepository extends Repository<Board, Long> {

    void delete(Board deleted);

    List<Board> findAll();

    Optional<Board> findOne(Long id);

    Board save(Board persisted);

    Board findBoardByBoardName(String boardName);

}
