package com.apsooba.interview.web.rest;

import com.apsooba.interview.domain.Post;
import com.apsooba.interview.exception.InterviewException;
import com.apsooba.interview.exception.InterviewExceptionType;
import com.apsooba.interview.model.PostComment;
import com.apsooba.interview.service.PostService;
import com.apsooba.interview.serviceimpl.infrastructure.DataReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.apsooba.interview.exception.InterviewExceptionType.DEFAULT_EXCEPTION;
import static com.apsooba.interview.exception.InterviewExceptionType.POST_NOT_FOUND_EXCEPTION;


@RestController
@RequestMapping("/api")
public class PostResource extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(PostResource.class);

    @Autowired
    private PostService postService;

    @Autowired
    private DataReaderService dataReaderService;

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable long postId) {
        try {
            Post post = postService.get(postId).orElseThrow(new InterviewException(POST_NOT_FOUND_EXCEPTION));
            return success(post);
        } catch (Exception e) {
            logger.error("method : getPost , id :{} ", postId);
            return failure(e);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
            postService.save(post);
            return success(post);
    }

    @GetMapping("/delete/{postId}")
    public ResponseEntity deletePost(@PathVariable long postId) {
        try {
//            Post post = postService.get(postId).orElseThrow(new InterviewException(POST_NOT_FOUND_EXCEPTION));
            postService.delete(postId);
            return success(null);
        } catch (Exception e) {
            logger.error("method : deletePost , id :{} ", postId);
            return failure(e);
        }
    }

    @GetMapping("/readPost")
    public ResponseEntity readPost() {
        try {
            dataReaderService.readPost();
            return success(null);
        } catch (Exception e) {
            logger.error("method : getPost ");
            return failure(e);
        }
    }

}
