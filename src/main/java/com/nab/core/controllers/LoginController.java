package com.nab.core.controllers;

import com.nab.core.auth.basic.BasicAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/basicauth")
public class LoginController {


    private final BasicAuthService authService;

    public LoginController(BasicAuthService authService) {
        this.authService = authService;
    }


    @GetMapping
    public ResponseEntity<Object> login() {
        if (authService.getAuthenticatedUser().isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
