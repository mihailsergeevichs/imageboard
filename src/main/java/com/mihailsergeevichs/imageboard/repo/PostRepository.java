package com.mihailsergeevichs.imageboard.repo;

import com.mihailsergeevichs.imageboard.entity.Post;
import com.mihailsergeevichs.imageboard.entity.Topic;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Overlord on 31.01.2016.
 */
public interface PostRepository extends Repository<Post, Long> {

    void delete(Post deleted);

    List<Post> findAll();

    Post findOne(Long id);

    Post save(Post persisted);

    List<Post> findByTopic(Topic topic);

}
