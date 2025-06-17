package com.example.mobileAppServer.controller.auth;

import com.example.mobileAppServer.controller.auth.dto.AuthenticationRequest;
import com.example.mobileAppServer.controller.auth.dto.AuthenticationResponse;
import com.example.mobileAppServer.controller.auth.dto.RegisterRequest;
import com.example.mobileAppServer.entity.UserEntity;
import com.example.mobileAppServer.entity.UserRole;
import com.example.mobileAppServer.repository.UserRepository;
import com.example.mobileAppServer.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest){
        var user = UserEntity.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))//шифруется пароль
                .role(UserRole.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);//генерируется новый токен

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().accessToken(jwtToken).build();

    }

}
