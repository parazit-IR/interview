package com.apsooba.interview.serviceimpl.domain;


import com.apsooba.interview.domain.Post;
import com.apsooba.interview.repository.PostRepository;
import com.apsooba.interview.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    @CachePut(value = "post", key = "#post.id")
    @Transactional
    public Post save(Post post) {
//        post.getComments().forEach(c -> c.setPost(post));
        Post createResponse = postRepository.save(post);
        return createResponse;
    }


    @Transactional
    @Cacheable(value = "post", key = "#id")
    public Optional<Post> get(long id) {
        return postRepository.findById(id);
    }

//    @Transactional
////    @Cacheable(value = "post", key = "#id")
//    public PostComment getPostComment(long id) throws InterviewException {
//        Post post = get(id).orElseThrow(new InterviewException(DEFAULT_EXCEPTION));
//        List<Comment> comments = commentService.getByPostId(id);
//        List<CommentPost> collect = comments.stream().map(c -> {
//            CommentPost commentPost = new CommentPost();
//            commentPost.setBody(c.getBody());
//            commentPost.setEmail(c.getEmail());
//            commentPost.setName(c.getName());
//            commentPost.setId(c.getId());
//            return commentPost;
//        }).collect(Collectors.toList());
//        PostComment postComment = new PostComment();
//        postComment.setComments(collect);
//        postComment.setTitle(post.getTitle());
//        postComment.setBody(post.getBody());
//        postComment.setId(post.getId());
//        postComment.setUserId(post.getUserId());
//        return postComment;
//    }


    @Transactional
    @CachePut(value = "post", key = "#post.id")
    public Post update(Post post) {
        Post updateResponse = postRepository.save(post);
        return updateResponse;
    }

    @Transactional
    @CacheEvict(value = "post", key = "#post.id")
    public void delete(Post post) {
        postRepository.deleteById(post.getId());
    }

    @Transactional
    @CacheEvict(value = "post", key = "#id")
    public void delete(long id) {
        postRepository.deleteById(id);
    }
}