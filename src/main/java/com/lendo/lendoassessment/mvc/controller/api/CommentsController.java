package com.lendo.lendoassessment.mvc.controller.api;


import com.lendo.lendoassessment.mvc.dao.Comment;
import com.lendo.lendoassessment.mvc.service.impl.CommentsServiceImpl;
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
@RequestMapping("/api/comment/")
public class CommentsController {

    @Autowired
    private CommentsServiceImpl commentsService;


    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComments(){

        log.info("[Get Request] - Get all comments request called.");

        List<Comment> allComments = commentsService.retrieveAllComments();

        return ResponseEntity.ok(allComments);
    }

    @GetMapping("/bypost/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable long postId){

        log.info("[Get Request] - Get comments by post Id request called.");

        List<Comment> comments = commentsService.retrieveCommentsByPostId(postId);

        return ResponseEntity.ok(comments);
    }
}
