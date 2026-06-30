package com.mtn.uganda.interview.interview.features.user.domain.entity;

import com.mtn.uganda.interview.interview.features.posts.domain.entity.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @Column(length = 100)
    private String name;
    @Column(length = 50)
    private String username;
    @Column(length = 50)
    private String email;
    @Column(length = 20)
    private String phone;
    @Column(length = 100)
    private String website;

    @CreatedBy
    private Long createdBy;
    @CreatedDate
    private Instant createdAt;

    @LastModifiedBy
    private Long updatedBy;
    @LastModifiedDate
    private Instant updatedAt;
}
