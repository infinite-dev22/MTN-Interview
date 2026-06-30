package com.mtn.uganda.interview.interview.features.user.domain.dto.mapper;

import com.mtn.uganda.interview.interview.features.user.domain.dto.response.UserResponse;
import com.mtn.uganda.interview.interview.features.user.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserResponse response);

    UserResponse toResponse(User post);
}
