package com.project.codegenerator.service;

import com.project.codegenerator.dto.auth.UserProfileResponse;

public interface UserService {

    public UserProfileResponse getProfile(Long userId);
}
