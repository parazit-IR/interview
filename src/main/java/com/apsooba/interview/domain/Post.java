package com.apsooba.interview.domain;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RedisHash("post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "USER_ID")
    private long userId;
    @Size(max = 200)
    @Column(name = "TITLE")
    private String title;
    @Lob
    @Size(max = 2000)
    @Column(name = "BODY")
    private String body;
    @OneToMany(mappedBy = "post",fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Indexed
    private List<Comment> comments = new ArrayList<>();

    public Post(){}


}