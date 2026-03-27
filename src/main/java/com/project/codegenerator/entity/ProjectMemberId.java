package com.project.codegenerator.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProjectMemberId {
    Long projectId;
    Long userId;
}
