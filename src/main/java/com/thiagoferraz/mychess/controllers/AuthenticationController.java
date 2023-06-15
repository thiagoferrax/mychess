package com.thiagoferraz.mychess.controllers;

import com.thiagoferraz.mychess.model.tos.AuthenticationResponse;
import com.thiagoferraz.mychess.model.tos.RegisterRequest;
import com.thiagoferraz.mychess.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")

public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
