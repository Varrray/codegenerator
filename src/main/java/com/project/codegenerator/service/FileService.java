package com.project.codegenerator.service;

import com.project.codegenerator.dto.project.FileContentResponse;
import com.project.codegenerator.dto.project.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(long projectId, String path, Long userId);
}
