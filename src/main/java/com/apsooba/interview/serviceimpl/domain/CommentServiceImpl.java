package com.apsooba.interview.serviceimpl.domain;


import com.apsooba.interview.domain.Comment;
import com.apsooba.interview.exception.InterviewException;
import com.apsooba.interview.exception.InterviewExceptionType;
import com.apsooba.interview.repository.CommentRepository;
import com.apsooba.interview.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.apsooba.interview.exception.InterviewExceptionType.DEFAULT_EXCEPTION;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    @CachePut(value = "comment", key = "#comment.id")
    public Comment save(Comment comment) {
        Comment createResponse = commentRepository.save(comment);
        return createResponse;
    }

    @Transactional
    @Cacheable(value = "comment", key = "#id")
    public Comment get(long id) {
        Comment commment = null;
        Optional<Comment> commentResponse = commentRepository.findById(id);
        if (commentResponse.isPresent()) {
            commment = commentResponse.get();
        } else {
            throw new RuntimeException("Record not found");
        }
        return commment;
    }

//    @CachePut(value = "comment", key = "#id")
    public List<Comment> getByPostId(long postId) throws InterviewException {
        List<Comment> comments = commentRepository.findAllByPostId(postId).orElseThrow(new InterviewException(DEFAULT_EXCEPTION));
        return comments;
    }

    @Transactional
    @CachePut(value = "comment", key = "#comment.id")
    public Comment update(Comment comment) {
        Comment updateResponse = commentRepository.save(comment);
        return updateResponse;
    }

    @Transactional
    @CacheEvict(value = "comment", key = "#comment.id")
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Transactional
    @CacheEvict(value = "comment", key = "#id")
    public void deleteByPostId(long id) {
        commentRepository.deleteAllByPostId(id);
    }
}
