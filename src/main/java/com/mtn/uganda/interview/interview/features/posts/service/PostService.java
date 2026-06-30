package com.mtn.uganda.interview.interview.features.posts.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtn.uganda.interview.interview.features.posts.domain.dto.mapper.PostMapper;
import com.mtn.uganda.interview.interview.features.posts.domain.dto.request.CreatePostRequest;
import com.mtn.uganda.interview.interview.features.posts.domain.dto.request.UpdatePostRequest;
import com.mtn.uganda.interview.interview.features.posts.domain.dto.response.PostResponse;
import com.mtn.uganda.interview.interview.features.posts.domain.entity.Post;
import com.mtn.uganda.interview.interview.features.posts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final PostMapper mapper;

    public List<PostResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public PostResponse findPostById(Long id) {
        var post = repository.findById(id).orElseThrow();
        return mapper.toResponse(post);
    }

    public PostResponse savePost(CreatePostRequest request) {
        var post = mapper.toEntity(request);

        return mapper.toResponse(repository.save(post));
    }

    public void savePosts(List<Post> posts) {
        repository.saveAll(posts);
    }

    public PostResponse updatePost(@NonNull Long id, UpdatePostRequest request) {
        var oldPost = repository.findById(id).orElseThrow();

        var post = mapper.partialUpdate(request, oldPost);

        return mapper.toResponse(repository.save(post));
    }

    public void deletePostById(Long id) {
        repository.deleteById(id);
    }

    public List<PostResponse> findAllPostsByUserId(Long userId) {
        return repository.findAllByUserId(userId).stream()
                .map(mapper::toResponse)
                .toList();
    }

    public void loadPosts() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Post>> typeReference = new TypeReference<List<Post>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/mock-data/posts.json");
        try {
            List<Post> posts = mapper.readValue(inputStream, typeReference);
            savePosts(posts);
            System.out.println("Posts Saved!");
        } catch (IOException e) {
            System.out.println("Unable to save posts: " + e.getMessage());
        }
    }
}
