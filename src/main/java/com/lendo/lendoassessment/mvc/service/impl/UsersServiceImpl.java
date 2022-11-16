package com.lendo.lendoassessment.mvc.service.impl;


import com.lendo.lendoassessment.mvc.dao.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UsersServiceImpl {

    private RestTemplate restTemplate = new RestTemplate();

    public List<User> retrieveAllUsers(){

        String getAllUsersEndPoint = "https://gorest.co.in/public/v2/users";

        try {
            ResponseEntity<User[]> getAllUsersResponse = restTemplate.getForEntity(getAllUsersEndPoint, User[].class);
            log.info("All users retrieved from the designed API, return: {}", getAllUsersResponse);

            return Arrays.asList(Objects.requireNonNull(getAllUsersResponse.getBody()));
        }catch (Exception e) {
            log.error("Failed to retrieve all users from its designed API, cause: {}", e.getMessage());
            throw e;
        }
    }



}
