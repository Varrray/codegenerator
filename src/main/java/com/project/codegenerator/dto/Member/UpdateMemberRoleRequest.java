package com.project.codegenerator.dto.Member;

import com.project.codegenerator.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
