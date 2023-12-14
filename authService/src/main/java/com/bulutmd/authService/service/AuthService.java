package com.bulutmd.authService.service;

import com.bulutmd.authService.DTO.AuthDTO;
import com.bulutmd.authService.DTO.LoginDTO;
import com.bulutmd.authService.model.Role;
import com.bulutmd.authService.model.User;
import com.bulutmd.authService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity register(AuthDTO authDTO) {
        User user = new User();
        if (userRepository.getUserByEmail(authDTO.getEmail()) != null) {
            return ResponseEntity.badRequest().build();
        }
        user.setEmail(authDTO.getEmail());
        user.setPassword(passwordEncoder.encode(authDTO.getPassword()));
        user.setUserName(authDTO.getUserName());
        user.getRole().add(Role.USER);
        return ResponseEntity.ok(userRepository.save(user));
    }

    public ResponseEntity login(LoginDTO loginDTO) {
        User user = new User();
        user = userRepository.getUserByEmail(loginDTO.getEmail());
        if (user != null) {
            return ResponseEntity.badRequest().build();
        }
        if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return ResponseEntity.ok("jwtToken");
        }
        return ResponseEntity.badRequest().build();
    }
}
