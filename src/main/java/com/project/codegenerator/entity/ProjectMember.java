package com.project.codegenerator.entity;

import com.project.codegenerator.enums.ProjectRole;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;


public class ProjectMember {
    ProjectMemberId id;
    Project project;
    User user;
    ProjectRole projectRole;
    Instant invitedAt;
    Instant acceptedAt;
}
