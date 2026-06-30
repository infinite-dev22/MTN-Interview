package com.mtn.uganda.interview.interview.features.user.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtn.uganda.interview.interview.features.user.domain.dto.mapper.UserMapper;
import com.mtn.uganda.interview.interview.features.user.domain.dto.response.UserResponse;
import com.mtn.uganda.interview.interview.features.user.domain.entity.User;
import com.mtn.uganda.interview.interview.features.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public List<UserResponse> findAllUsers() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public UserResponse findUserById(Long id) {
        var user = repository.findById(id).orElseThrow();
        return mapper.toResponse(user);
    }

    private void saveUser(List<User> users) {
        repository.saveAll(users);
    }

    public void postUsers() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/mock-data/users.json");
        try {
            List<User> users = mapper.readValue(inputStream, typeReference);
            saveUser(users);
            System.out.println("Users Saved!");
        } catch (IOException e) {
            System.out.println("Unable to save users: " + e.getMessage());
        }
    }
}
