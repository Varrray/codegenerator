package com.project.codegenerator.service.Impl;

import com.project.codegenerator.dto.auth.UserProfileResponse;
import com.project.codegenerator.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
