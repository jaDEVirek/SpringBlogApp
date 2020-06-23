package com.devirek.blogapp.service;


import com.devirek.blogapp.dto.RegisterRequestDTO;
import com.devirek.blogapp.model.User;
import com.devirek.blogapp.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {


    private UserRepositoryInterface userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(PasswordEncoder passwordEncoder, UserRepositoryInterface userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;

    }

    @Transactional
    public void signUp(RegisterRequestDTO registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setUserEmail(registerRequest.getEmail());
        user.setUserPassword(encodePassword(registerRequest.getPassword()));

        userRepository.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
