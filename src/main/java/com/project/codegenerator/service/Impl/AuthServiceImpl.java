package com.project.codegenerator.service.Impl;

import com.project.codegenerator.dto.auth.AuthResponse;
import com.project.codegenerator.dto.auth.LoginRequest;
import com.project.codegenerator.dto.auth.SignUpRequest;
import com.project.codegenerator.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignUpRequest request){
        return null;
    }
    @Override
    public AuthResponse login(LoginRequest request){
        return null;
    }
}
