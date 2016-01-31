package com.mihailsergeevichs.imageboard.repo;

import com.mihailsergeevichs.imageboard.entities.Post;
import com.mihailsergeevichs.imageboard.entities.Topic;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Overlord on 31.01.2016.
 */
public interface PostRepository extends Repository<Post, Long> {

    void delete(Post deleted);

    List<Post> findAll();

    Post findOne(Long id);

    Post save(Post persisted);

    List<Post> findPostsByTopic(Topic topic);
}
