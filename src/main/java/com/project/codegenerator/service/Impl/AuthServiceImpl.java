package com.project.codegenerator.service.Impl;

import com.project.codegenerator.dto.auth.AuthResponse;
import com.project.codegenerator.dto.auth.LoginRequest;
import com.project.codegenerator.dto.auth.SignUpRequest;
import com.project.codegenerator.entity.User;
import com.project.codegenerator.error.BadRequestException;
import com.project.codegenerator.mapper.UserMapper;
import com.project.codegenerator.repository.UserRepository;
import com.project.codegenerator.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    @Override
    public AuthResponse signup(SignUpRequest request){
        userRepository.findByUsername(request.username()).ifPresent(user ->
        {
            throw new BadRequestException("user already exists with username");
        }
        );
        User user=userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user=userRepository.save(user);
        return new AuthResponse("dummy",userMapper.toUserProfileResponse(user));
    }
    @Override
    public AuthResponse login(LoginRequest request){
        return null;
    }
}
