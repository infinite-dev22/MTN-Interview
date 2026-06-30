package com.mtn.uganda.interview.interview.features.posts.domain.dto.mapper;

import com.mtn.uganda.interview.interview.features.posts.domain.dto.request.CreatePostRequest;
import com.mtn.uganda.interview.interview.features.posts.domain.dto.request.UpdatePostRequest;
import com.mtn.uganda.interview.interview.features.posts.domain.dto.response.PostResponse;
import com.mtn.uganda.interview.interview.features.posts.domain.entity.Post;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {
    Post toEntity(CreatePostRequest createPostRequest);

    PostResponse toResponse(Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Post partialUpdate(UpdatePostRequest request, @MappingTarget Post post);
}