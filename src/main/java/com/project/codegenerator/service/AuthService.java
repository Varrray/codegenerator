package com.project.codegenerator.service;

import com.project.codegenerator.dto.auth.AuthResponse;
import com.project.codegenerator.dto.auth.LoginRequest;
import com.project.codegenerator.dto.auth.SignUpRequest;

public interface AuthService {
   AuthResponse signup(SignUpRequest request);
   AuthResponse login(LoginRequest request);
}
