package com.mtn.uganda.interview.interview.features.posts.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "posts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String title;
    private String body;

    @Builder.Default
    private boolean isPublic = false;


    private Instant createdAt;
    private Instant updatedAt;
}
