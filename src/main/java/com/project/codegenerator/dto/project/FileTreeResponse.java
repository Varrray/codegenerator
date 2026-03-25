package com.project.codegenerator.dto.project;

import java.time.Instant;

public record FileTreeResponse(String path, Instant modifiedAt, Long size,String type) {
}
