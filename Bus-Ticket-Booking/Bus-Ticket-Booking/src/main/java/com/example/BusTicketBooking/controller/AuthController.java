package com.example.BusTicketBooking.controller;


import com.example.BusTicketBooking.dto.AuthRequest;
import com.example.BusTicketBooking.dto.AuthResponse;
import com.example.BusTicketBooking.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200/")

@RestController
@RequestMapping("/auth")
public class AuthController {
    final Logger logger = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    private AuthService authService;

    @PostMapping("register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody AuthRequest request) {

        return authService.registerUser(request);
    }
    @PostMapping("login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody AuthRequest request){
        return authService.loginUser(request);
    }
}
