package com.apsooba.interview.serviceimpl.infrastructure;

import com.apsooba.interview.config.ApplicationProperties;
import com.apsooba.interview.domain.Comment;
import com.apsooba.interview.domain.Post;
import com.apsooba.interview.exception.InterviewException;
import com.apsooba.interview.exception.InterviewExceptionType;
import com.apsooba.interview.service.PostService;
import com.apsooba.interview.service.dto.PostDto;
import com.apsooba.interview.service.CommentService;
import com.apsooba.interview.service.dto.CommentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
public class DataReaderService {

    private static final Logger log = LoggerFactory.getLogger(DataReaderService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private PostService postService;

    @Async
    public CompletableFuture<PostDto[]> getPostDto() {
        String postUrl = applicationProperties.getUrl().getPost();
        PostDto[] postModels = restTemplate.getForObject(postUrl, PostDto[].class);
        return CompletableFuture.completedFuture(postModels);
    }

    @Async
    public CompletableFuture<CommentDto[]> getCommentDto() {
        String commentUrl = applicationProperties.getUrl().getComments();
        CommentDto[] comments = restTemplate.getForObject(commentUrl, CommentDto[].class);
        return CompletableFuture.completedFuture(comments);
    }

    public void readPost() {

        CompletableFuture<CommentDto[]> fetchCommentsDto = getCommentDto();
        CommentDto[] comments = fetchCommentsDto.join();

        CompletableFuture<PostDto[]> fetchPostsDto = getPostDto();
        PostDto[] posts = fetchPostsDto.join();

        for (PostDto p:posts) {
            Post post = new Post();
            post.setUserId(p.getUserId());
            post.setTitle(p.getTitle());
            post.setBody(p.getBody());
//            post.setId(p.getId());
                List<Comment> commentList = new ArrayList<>();
                for (CommentDto c:comments) {
                    if (c.getPostId() == p.getId()) {
                        Comment comment = new Comment();
//                        comment.setId(c.getId());
                        comment.setEmail(c.getEmail());
                        comment.setBody(c.getBody());
                        comment.setName(c.getName());
//                        comment.setPost(post);
                        commentList.add(comment);
                    }
                }
            post.setComments(commentList);
            postService.save(post);
        }
    }

    @Transactional
    public Post getPosts() throws InterviewException {
        Post post = postService.get(0).orElseThrow(new InterviewException(InterviewExceptionType.DEFAULT_EXCEPTION));
        return post;
    }
}
