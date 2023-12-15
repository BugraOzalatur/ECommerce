package com.bulutmd.authService.controller;

import com.bulutmd.authService.DTO.AuthDTO;
import com.bulutmd.authService.DTO.LoginDTO;
import com.bulutmd.authService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    public ResponseEntity register(AuthDTO authDTO){
        return authService.register(authDTO);
    }
    public ResponseEntity login(LoginDTO loginDTO){
        return authService.login(loginDTO);
    }
}
