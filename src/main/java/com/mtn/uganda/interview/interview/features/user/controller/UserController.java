package com.mtn.uganda.interview.interview.features.user.controller;

import com.mtn.uganda.interview.interview.features.user.domain.dto.response.UserResponse;
import com.mtn.uganda.interview.interview.features.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("{id}")
    public UserResponse getUserById(@PathVariable String id) {
        return userService.findUserById(Long.parseLong(id));
    }

    @PostMapping("load")
    public void loadUsers() {
        userService.postUsers();
    }

}
