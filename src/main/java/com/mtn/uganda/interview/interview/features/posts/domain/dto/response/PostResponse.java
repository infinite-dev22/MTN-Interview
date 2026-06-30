package com.mtn.uganda.interview.interview.features.posts.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PostResponse(
        Long id,
        Long userId,
        String title,
        String body,
        boolean isPublic,
        Instant createdAt,
        Instant updatedAt) implements Serializable {
}