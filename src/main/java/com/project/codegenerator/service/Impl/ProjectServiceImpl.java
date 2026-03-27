package com.project.codegenerator.service.Impl;

import com.project.codegenerator.dto.project.ProjectRequest;
import com.project.codegenerator.dto.project.ProjectResponse;
import com.project.codegenerator.dto.project.ProjectSummaryResponse;
import com.project.codegenerator.entity.Project;
import com.project.codegenerator.entity.User;
import com.project.codegenerator.mapper.ProjectMapper;
import com.project.codegenerator.repository.ProjectRepository;
import com.project.codegenerator.repository.UserRepository;
import com.project.codegenerator.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner=userRepository.findById(userId).orElseThrow();
        Project project=Project.builder().name(request.name()).owner(owner).isPublic(false).build();
        project=projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
//        return projectRepository.findAllAccessibleByUser(userId)
//                .stream()
//                .map(projectMapper::toProjectSummaryResponse)
//                .collect(Collectors.toList());
        var projects=projectRepository.findAllAccessibleByUser(userId);
return projectMapper.toListProjectSummaryResponse(projects);
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
