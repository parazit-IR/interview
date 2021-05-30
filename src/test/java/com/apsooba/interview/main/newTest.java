//package com.apsooba.interview.main;
//
//import com.apsooba.interview.domain.Post;
//import com.apsooba.interview.repository.PostRepository;
//import com.apsooba.interview.serviceimpl.domain.PostServiceImpl;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.Assert.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class newTest {
//
//    @MockBean
//    private PostRepository postRepository;
//
//    @Autowired
//    private PostServiceImpl postService;
//
//    @Test
//    public void test()  {
//        Post post = postService.get(1).get();
//        assertEquals(1L , post.getId());
//    }
//}
//
