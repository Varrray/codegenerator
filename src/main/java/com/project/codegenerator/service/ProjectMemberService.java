package com.project.codegenerator.service;

import com.project.codegenerator.dto.Member.InviteMemberRequest;
import com.project.codegenerator.dto.Member.MemberResponse;
import com.project.codegenerator.dto.Member.UpdateMemberRoleRequest;

public interface ProjectMemberService {
    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);


    MemberResponse getProjectMembers(Long projectId, Long userId);

    MemberResponse updateMemberRole(Long projectId,Long memberId, UpdateMemberRoleRequest request, Long userId);

    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
