package com.example.librarymanagement.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.models.auth.Role;
import com.example.librarymanagement.models.auth.User;
import com.example.librarymanagement.repositories.UserRepository;
import com.example.librarymanagement.security.model.AuthenticateRequestModel;
import com.example.librarymanagement.security.model.AuthenticateResponseModel;
import com.example.librarymanagement.security.model.RegisterRequestModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;



    public AuthenticateResponseModel register(RegisterRequestModel request){
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER.name())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticateResponseModel.builder()
                .token(jwtToken)
                .build();
    }


    public AuthenticateResponseModel authenticate(AuthenticateRequestModel requestModel){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestModel.getEmail(), requestModel.getPassword()
                )
        );

        var user = repository.findByEmail(requestModel.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticateResponseModel.builder()
                .token(jwtToken)
                .build();
    }
    
}
