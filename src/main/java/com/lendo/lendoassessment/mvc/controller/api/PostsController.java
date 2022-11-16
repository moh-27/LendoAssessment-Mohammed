package com.lendo.lendoassessment.mvc.controller.api;


import com.lendo.lendoassessment.mvc.dao.Post;
import com.lendo.lendoassessment.mvc.service.impl.PostsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/post/")
public class PostsController {

    @Autowired
    private PostsServiceImpl postsService;


    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts(){

        log.info("[Get Request] - Get all posts request called.");

        List<Post> allPosts = postsService.retrieveAllPosts();

        return ResponseEntity.ok(allPosts);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Post>> getCommentsByPostId(@PathVariable long userId){

        log.info("[Get Request] - Get posts by user id request called.");

        List<Post> posts = postsService.retrievePostsByUserId(userId);

        return ResponseEntity.ok(posts);
    }
}
