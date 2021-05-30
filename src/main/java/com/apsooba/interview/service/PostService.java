package com.apsooba.interview.service;


import com.apsooba.interview.domain.Post;
import com.apsooba.interview.exception.InterviewException;
import com.apsooba.interview.model.PostComment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PostService {
    public Post save(Post post);

//    public Iterable<Post> saveAll(List<Post> posts);

    public Post update(Post post);

    public Optional<Post> get(long id) ;

//    public PostComment getPostComment(long id) throws InterviewException;

    public void delete(Post post);

    public void delete(long postId);

}
