package com.project.codegenerator.service.Impl;

import com.project.codegenerator.dto.Member.InviteMemberRequest;
import com.project.codegenerator.dto.Member.MemberResponse;
import com.project.codegenerator.dto.Member.UpdateMemberRoleRequest;
import com.project.codegenerator.entity.Project;
import com.project.codegenerator.entity.ProjectMember;
import com.project.codegenerator.entity.ProjectMemberId;
import com.project.codegenerator.entity.User;
import com.project.codegenerator.mapper.ProjectMemberMapper;
import com.project.codegenerator.repository.ProjectMemberRepository;
import com.project.codegenerator.repository.ProjectRepository;
import com.project.codegenerator.repository.UserRepository;
import com.project.codegenerator.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;


@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {
    ProjectMemberRepository projectMemberRepository;
    UserRepository userRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project=getAccessProjectById(projectId,userId);
        User invitee=userRepository.findByUsername(request.username()).orElseThrow();
        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot invite yourself");
        }
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId, invitee.getId());
        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Cannot invite once again");
        }
        ProjectMember member=ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();
        projectMemberRepository.save(member);
        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project=getAccessProjectById(projectId,userId);
        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project=getAccessProjectById(projectId,userId);
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId,memberId);
        ProjectMember projectMember=projectMemberRepository.findById(projectMemberId).orElseThrow();
        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);




        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project=getAccessProjectById(projectId,userId);
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId,memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Member not found in project");
        }
        projectMemberRepository.deleteById(projectMemberId);
    }

    public Project getAccessProjectById(Long projectId,Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();
    }
}
