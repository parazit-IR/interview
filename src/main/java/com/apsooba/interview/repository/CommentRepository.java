package com.apsooba.interview.repository;


import com.apsooba.interview.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Optional<List<Comment>> findAllByPostId(Long aLong);
    void deleteAllByPostId(Long aLong);
}