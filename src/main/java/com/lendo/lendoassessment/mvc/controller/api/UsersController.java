package com.lendo.lendoassessment.mvc.controller.api;


import com.lendo.lendoassessment.mvc.dao.User;
import com.lendo.lendoassessment.mvc.service.impl.UsersServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user/")
public class UsersController {

    @Autowired
    private UsersServiceImpl usersService;


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){

        log.info("[Get Request] - Get all users request called.");

        List<User> allUsers = usersService.retrieveAllUsers();

        return ResponseEntity.ok(allUsers);
    }




}
