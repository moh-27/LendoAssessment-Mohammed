package com.lendo.lendoassessment.mvc.service.impl;


import com.lendo.lendoassessment.mvc.dao.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
public class CommentsServiceImpl {

    private RestTemplate restTemplate = new RestTemplate();

    public List<Comment> retrieveAllComments() {

        String getAllCommentsEndPoint = "https://gorest.co.in/public/v2/comments";

        try {
            ResponseEntity<Comment[]> getAllCommentsResponse = restTemplate.getForEntity(getAllCommentsEndPoint, Comment[].class);
            log.info("All comments retrieved from the designed API, return: {}", getAllCommentsResponse);

            return Arrays.asList(Objects.requireNonNull(getAllCommentsResponse.getBody()));
        } catch (Exception e) {
            log.error("Failed to retrieve all comments from its designed API, cause: {}", e.getMessage());
            throw e;
        }
    }

    public List<Comment> retrieveCommentsByPostId(long postId) {

        String getCommentsByPostEndPoint = "https://gorest.co.in/public/v2/posts/"+postId+"/comments";

        try {
            ResponseEntity<Comment[]> getAllCommentsResponse = restTemplate.getForEntity(getCommentsByPostEndPoint, Comment[].class);
            log.info("Comments by posts retrieved from the designed API, return: {}", getAllCommentsResponse);

            return Arrays.asList(Objects.requireNonNull(getAllCommentsResponse.getBody()));
        } catch (Exception e) {
            log.error("Failed to retrieve comments by posts from its designed API, cause: {}", e.getMessage());
            throw e;
        }
    }
}
