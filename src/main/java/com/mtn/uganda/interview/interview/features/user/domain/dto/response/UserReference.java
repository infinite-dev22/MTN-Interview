package com.mtn.uganda.interview.interview.features.user.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserReference(
        Long id,
        String name,
        String username,
        String email,
        String phone) implements Serializable {
}