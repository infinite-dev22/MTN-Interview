package com.mtn.uganda.interview.interview.features.posts.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import org.jspecify.annotations.NonNull;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatePostRequest(
        @NonNull Long userId,
        @NotBlank String title,
        @NotBlank String body,
        boolean isPublic) implements Serializable {
}