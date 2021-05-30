package com.apsooba.interview.service;

import com.apsooba.interview.domain.Comment;
import com.apsooba.interview.exception.InterviewException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentService {
    public Comment save(Comment comment);

//    public Iterable<CommentPost> saveAll(List<CommentPost> comments);

    public Comment update(Comment comment);

    public Comment get(long id);

    public List<Comment> getByPostId(long postId) throws InterviewException;

    public void delete(Comment comment);

    public void deleteByPostId(long postId);

}
