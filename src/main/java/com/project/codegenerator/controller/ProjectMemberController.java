package com.project.codegenerator.controller;


import com.project.codegenerator.dto.Member.InviteMemberRequest;
import com.project.codegenerator.dto.Member.MemberResponse;
import com.project.codegenerator.dto.Member.UpdateMemberRoleRequest;
import com.project.codegenerator.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/members")
public class ProjectMemberController {
        private final ProjectMemberService projectMemberService;
        @GetMapping("/{id}")
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId){
            Long userId=1L;
            return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId,userId));
        }
        @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId, @RequestBody InviteMemberRequest request){
            Long userId=1L;
            return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.inviteMember(projectId,request,userId));
        }


        @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(@PathVariable Long memberId, @RequestBody UpdateMemberRoleRequest request,@PathVariable Long projectId){
        Long userId=1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.updateMemberRole(projectId,memberId,request,userId));

        }
    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponse> deleteMember(@PathVariable Long memberId,@PathVariable Long projectId){
        Long userId=1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.deleteProjectMember(projectId,memberId,userId));

    }


}
