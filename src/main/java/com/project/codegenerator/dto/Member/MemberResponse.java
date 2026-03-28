package com.project.codegenerator.dto.Member;

import com.project.codegenerator.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        String avatarYrl,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
