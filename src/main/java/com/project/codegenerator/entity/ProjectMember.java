package com.project.codegenerator.entity;

import com.project.codegenerator.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapping;

import java.time.Instant;



@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "project_members")
public class ProjectMember {
    @EmbeddedId
    ProjectMemberId id;
    @ManyToOne
    @MapsId("projectId")
    Project project;
    @ManyToOne
    @MapsId("userId")
    User user;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProjectRole projectRole;
    Instant invitedAt;
    Instant acceptedAt;
}
