package com.mtn.uganda.interview.interview.features.user.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserResponse(
        Long id,
        String name,
        String username,
        String email,
        String phone,
        String website) implements Serializable {
}