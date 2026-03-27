package com.project.codegenerator.mapper;


import com.project.codegenerator.dto.Member.MemberResponse;
import com.project.codegenerator.entity.ProjectMember;
import com.project.codegenerator.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    @Mapping(target = "userId",source="id")
    @Mapping(target= "projectRole",constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);
    @Mapping(target = "userId" ,source = "user.id")
    @Mapping(target="email",source="user.email")
    @Mapping(target="name",source="user.name")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);

}
