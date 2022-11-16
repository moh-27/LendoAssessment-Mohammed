package com.lendo.lendoassessment.mvc.dao;

import lombok.Data;

@Data
public class Post {

    private Long id;

    private String title;

    private String body;

    private Long user_id;

}
