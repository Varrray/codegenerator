package com.project.codegenerator.dto.subscription;

public record PlanResponse(Long Id,
        String name,
        Integer maxProjects,
        Integer maxTokenPerDay,
        Boolean unlimitedAi,
        String price) {
}
