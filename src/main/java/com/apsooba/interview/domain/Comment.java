package com.apsooba.interview.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RedisHash("comment")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Indexed
    private long id;
    @Size(max = 100)
    private String name;
    @Size(max = 200)
    @Email
    private String email;
    @Lob
    @Size(max = 2000)
    private String body;
    @ManyToOne
    @JoinColumn(name = "postId")
    @JsonIgnore
    private Post post;

}