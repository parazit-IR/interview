package com.apsooba.interview.model;

import lombok.Data;

@Data
public class CommentPost {
    private long id;
    private String name;
    private String email;
    private String body;
}
