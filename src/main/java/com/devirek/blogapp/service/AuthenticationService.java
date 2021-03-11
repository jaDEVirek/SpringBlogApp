package com.devirek.blogapp.service;


import com.devirek.blogapp.configuration.JWTDataProvider;
import com.devirek.blogapp.dto.LoginRequestDTO;
import com.devirek.blogapp.dto.RegisterRequestDTO;
import com.devirek.blogapp.model.UserModel;
import com.devirek.blogapp.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {


    private final UserRepositoryInterface userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JWTDataProvider tokenProvider;

    @Autowired
    public AuthenticationService(PasswordEncoder passwordEncoder, UserRepositoryInterface userRepository,
                                 AuthenticationManager authenticationManager, JWTDataProvider tokenProvider) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @Transactional
    public void signUp(RegisterRequestDTO registerRequest) {
        UserModel userModel = new UserModel();
        userModel.setUserName(registerRequest.getUserName())
                 .setUserEmail(registerRequest.getEmail())
                 .setUserPassword(encodePassword(registerRequest.getPassword()));

        userRepository.save(userModel);
    }

    @Transactional
    public void login(LoginRequestDTO loginRequest) {
        // to finish authentication process
        SecurityContextHolder.getContext()
                             .setAuthentication(authenticationManager.authenticate(
                                     new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
                                                                             loginRequest.getPassword())));
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
