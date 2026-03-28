package com.project.codegenerator.dto.Member;

import com.project.codegenerator.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role
) {
}
