package com.project.codegenerator.dto.project;

import com.project.codegenerator.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(Long id, String name , Instant createAt, Instant updatedAt, UserProfileResponse owner) {
}
