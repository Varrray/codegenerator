package com.project.codegenerator.service;

import com.project.codegenerator.dto.project.ProjectRequest;
import com.project.codegenerator.dto.project.ProjectResponse;
import com.project.codegenerator.dto.project.ProjectSummaryResponse;


import java.util.List;

public interface ProjectService {

    ProjectResponse createProject(ProjectRequest projectRequest, Long userId);

    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectById(Long id,Long userId);

    ProjectResponse updateProject(Long id, Long userId, ProjectResponse projectResponse);

    void softDelete(Long id, Long userId);
}
