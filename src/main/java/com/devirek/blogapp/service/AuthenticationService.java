package com.devirek.blogapp.service;


import com.devirek.blogapp.dto.RegisterRequestDTO;
import com.devirek.blogapp.model.UserModel;
import com.devirek.blogapp.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {


    private UserRepositoryInterface userRepository;

    private AuthenticationManager authenticationManager;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(PasswordEncoder passwordEncoder, UserRepositoryInterface userRepository,
                                 AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
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
    public void login() {

    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
