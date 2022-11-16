package com.lendo.lendoassessment.mvc.service.impl;


import com.lendo.lendoassessment.mvc.dao.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class PostsServiceImpl {

    private RestTemplate restTemplate = new RestTemplate();

    public List<Post> retrieveAllPosts() {

        String getAllPostsEndPoint = "https://gorest.co.in/public/v2/posts";

        try {
            ResponseEntity<Post[]> getAllPostsResponse = restTemplate.getForEntity(getAllPostsEndPoint, Post[].class);
            log.info("All posts retrieved from the designed API, return: {}", getAllPostsResponse);

            return Arrays.asList(Objects.requireNonNull(getAllPostsResponse.getBody()));
        } catch (Exception e) {
            log.error("Failed to retrieve all posts from its designed API, cause: {}", e.getMessage());
            throw e;
        }
    }

    public List<Post> retrievePostsByUserId(long userId) {

        String getPostsByUserIdEndPoint = "https://gorest.co.in/public/v2/users/"+userId+"/posts";

        try {
            ResponseEntity<Post[]> getPostsByUserIdResponse = restTemplate.getForEntity(getPostsByUserIdEndPoint, Post[].class);
            log.info("Posts by user Id retrieved from the designed API, return: {}", getPostsByUserIdResponse);

            return Arrays.asList(Objects.requireNonNull(getPostsByUserIdResponse.getBody()));
        } catch (Exception e) {
            log.error("Failed to retrieve posts by user Id from its designed API, cause: {}", e.getMessage());
            throw e;
        }
    }
}
