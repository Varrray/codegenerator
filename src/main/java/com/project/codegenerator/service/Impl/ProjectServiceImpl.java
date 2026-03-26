package com.project.codegenerator.service.Impl;

import com.project.codegenerator.dto.project.ProjectResponse;
import com.project.codegenerator.dto.project.ProjectSummaryResponse;
import com.project.codegenerator.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public ProjectResponse createProject(ProjectResponse projectRequest, Long userId) {
        return null;
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long id, Long userId, ProjectResponse projectResponse) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
