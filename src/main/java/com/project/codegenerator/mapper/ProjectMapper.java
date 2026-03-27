package com.project.codegenerator.mapper;

import com.project.codegenerator.dto.project.ProjectResponse;
import com.project.codegenerator.dto.project.ProjectSummaryResponse;
import com.project.codegenerator.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project);
    ProjectSummaryResponse toProjectSummaryResponse(Project project);
    List<ProjectSummaryResponse> toListProjectSummaryResponse(List<Project> project);
}
