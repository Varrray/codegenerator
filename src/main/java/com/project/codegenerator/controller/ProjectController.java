package com.project.codegenerator.controller;

import com.project.codegenerator.dto.project.ProjectRequest;
import com.project.codegenerator.dto.project.ProjectResponse;
import com.project.codegenerator.dto.project.ProjectSummaryResponse;
import com.project.codegenerator.service.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectController {
    final ProjectService projectservice;
    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest project){
        Long userId=1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectservice.createProject(project,userId));

    }

    @GetMapping("")
    public ResponseEntity<List<ProjectSummaryResponse>> getMyProjects(){
        Long userId=1L;
        return ResponseEntity.ok(projectservice.getUserProjects(userId));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id){
        Long userId=1L;
        return ResponseEntity.ok(projectservice.getUserProjectById(id,userId));

    }
    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id ,@RequestBody ProjectResponse project){
        Long userId=1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectservice.updateProject(id,userId,project));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        Long userId=1L;
        projectservice.softDelete(id,userId);
        return ResponseEntity.noContent().build();
    }

}
