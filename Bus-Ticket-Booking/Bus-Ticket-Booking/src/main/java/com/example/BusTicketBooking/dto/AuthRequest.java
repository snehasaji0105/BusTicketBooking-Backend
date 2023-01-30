package com.example.BusTicketBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthRequest {
    private String Name;

    private String email;
    private String password;
    public AuthRequest(String email, String password){
        this.email = email;
        this.password=password;
    }
}
