package com.apsooba.interview.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class PostComment implements Serializable {
    private long id;
    private long userId;
    private String title;
    private String body;
    private List<CommentPost> comments;

}