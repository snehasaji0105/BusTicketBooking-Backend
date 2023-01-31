package com.example.BusTicketBooking.controller;


import com.example.BusTicketBooking.dto.AuthResponse;
import com.example.BusTicketBooking.model.TicketBooking;
import com.example.BusTicketBooking.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TicketBookingController {
    @Autowired
    private TicketBookingService ticketBookingService;



   @GetMapping("get-tickets")
    public ResponseEntity<List<TicketBooking>> getAllTickets() {
        return ticketBookingService.getAllTickets();
    }
    @GetMapping("get-ticket/{id}")
    public ResponseEntity<List<TicketBooking>> getTicket(@PathVariable String id) {
        return ticketBookingService.getTicket(id);
    }


    @PostMapping("add-tickets/{id}")
    public ResponseEntity<AuthResponse> addTicket( @RequestBody TicketBooking ticketBooking) {
        return ticketBookingService.addTicket(ticketBooking);
    }

//    @PutMapping("update-ticket/{id}")
//    public ResponseEntity<AuthResponse> updateTicket(@PathVariable Long id,@RequestBody TicketBooking updatedTicket) {
//        return TicketBookingService.updateTicket(id, updatedTicket);
//    }

    @DeleteMapping("delete-ticket/{id}")
    public ResponseEntity<AuthResponse> deleteTicket(@PathVariable String id) {
        return ticketBookingService.deleteTicket(id);
    }
}