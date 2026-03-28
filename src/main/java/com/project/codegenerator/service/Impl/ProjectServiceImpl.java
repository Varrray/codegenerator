package com.project.codegenerator.service.Impl;

import com.project.codegenerator.dto.project.ProjectRequest;
import com.project.codegenerator.dto.project.ProjectResponse;
import com.project.codegenerator.dto.project.ProjectSummaryResponse;
import com.project.codegenerator.entity.Project;
import com.project.codegenerator.entity.ProjectMember;
import com.project.codegenerator.entity.ProjectMemberId;
import com.project.codegenerator.entity.User;
import com.project.codegenerator.enums.ProjectRole;
import com.project.codegenerator.error.ResourceNotFoundException;
import com.project.codegenerator.mapper.ProjectMapper;
import com.project.codegenerator.repository.ProjectMemberRepository;
import com.project.codegenerator.repository.ProjectRepository;
import com.project.codegenerator.repository.UserRepository;
import com.project.codegenerator.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
    ProjectMemberRepository projectMemberRepository;
    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner=userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User",userId.toString())
        );
        Project project=Project.builder().name(request.name()).isPublic(false).build();
        project=projectRepository.save(project);
        ProjectMemberId projectMemberId=new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember=ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        var projects=projectRepository.findAllAccessibleByUser(userId);
return projectMapper.toListProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project=getAccessProjectById(id,userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, Long userId, ProjectRequest request) {
        Project project=getAccessProjectById(id,userId);
        project.setName(request.name());
        project=projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project=getAccessProjectById(id,userId);
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);

    }

    public Project getAccessProjectById(Long projectId,Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();
    }
}
