package com.project.codegenerator.dto.project;

import java.time.Instant;
import java.time.LocalDateTime;

public record ProjectSummaryResponse(Long id, String name , Instant createAt,Instant updatedAt) {
}
