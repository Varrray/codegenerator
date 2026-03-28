package com.project.codegenerator.mapper;


import com.project.codegenerator.dto.auth.SignUpRequest;
import com.project.codegenerator.dto.auth.UserProfileResponse;
import com.project.codegenerator.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel= "spring")
public interface UserMapper {

    User toEntity(SignUpRequest signUpRequest);
    UserProfileResponse toUserProfileResponse(User user);
}
