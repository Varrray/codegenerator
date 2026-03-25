package com.project.codegenerator.dto.auth;

public record UserProfileResponse (
    Long id,
    String email,
    String name,
    String avatarYrl
    )
{

}