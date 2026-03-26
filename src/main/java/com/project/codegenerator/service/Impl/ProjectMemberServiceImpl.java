package com.project.codegenerator.service.Impl;

import com.project.codegenerator.dto.Member.InviteMemberRequest;
import com.project.codegenerator.dto.Member.MemberResponse;
import com.project.codegenerator.dto.Member.UpdateMemberRoleRequest;
import com.project.codegenerator.service.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
