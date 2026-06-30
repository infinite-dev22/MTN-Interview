package com.mtn.uganda.interview.interview.features.posts.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jspecify.annotations.Nullable;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePostRequest(
        @Nullable Long userId,
        @Nullable String title,
        @Nullable String body,
        @Nullable Boolean isPublic) implements Serializable {
}