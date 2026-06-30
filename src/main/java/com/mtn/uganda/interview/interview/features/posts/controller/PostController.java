package com.mtn.uganda.interview.interview.features.posts.controller;

import com.mtn.uganda.interview.interview.features.posts.domain.dto.request.CreatePostRequest;
import com.mtn.uganda.interview.interview.features.posts.domain.dto.request.UpdatePostRequest;
import com.mtn.uganda.interview.interview.features.posts.domain.dto.response.PostResponse;
import com.mtn.uganda.interview.interview.features.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @GetMapping
    public List<PostResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public PostResponse findById(@PathVariable String id) {
        return service.findPostById(Long.parseLong(id));
    }

    @PostMapping
    public PostResponse create(@RequestBody CreatePostRequest post) {
        return service.savePost(post);
    }

    @PutMapping("{id}")
    public PostResponse update(@PathVariable Long id, @RequestBody UpdatePostRequest post) {
        return service.updatePost(id, post);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        service.deletePostById(Long.parseLong(id));
    }

    @GetMapping("user/{id}")
    public List<PostResponse> findByUser(@PathVariable Long id) {
        return service.findAllPostsByUserId(id);
    }

    @GetMapping("generate")
    public void generate() {
        service.loadPosts();
    }

}
