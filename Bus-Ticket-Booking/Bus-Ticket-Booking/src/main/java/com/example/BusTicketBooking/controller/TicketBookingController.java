package com.example.BusTicketBooking.controller;


import com.example.BusTicketBooking.dto.AuthResponse;
import com.example.BusTicketBooking.model.Bus;
import com.example.BusTicketBooking.model.BusRoute;
import com.example.BusTicketBooking.model.TicketBooking;
import com.example.BusTicketBooking.service.TicketBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TicketBookingController {
    final Logger logger = LoggerFactory.getLogger(TicketBookingController.class);
    @Autowired
    private TicketBookingService ticketBookingService;


    @GetMapping("get-tickets")
    public ResponseEntity<List<TicketBooking>> getAllTickets() {
        return ticketBookingService.getAllTickets();
    }

    @GetMapping("get-ticket/{id}")
    public ResponseEntity<List<TicketBooking>> getTicket(@PathVariable Long id) {
        return ticketBookingService.getTicket(String.valueOf(id));
    }


    @PostMapping("add-ticket")
    public ResponseEntity<AuthResponse> addTicket( @RequestBody TicketBooking ticketBooking) {
        return ticketBookingService.addTicket(ticketBooking);
    }


    @PutMapping("update-ticket/{id}")
    public ResponseEntity<AuthResponse> updateTicket(@PathVariable Long id,@RequestBody TicketBooking updatedTicket) {
        return ticketBookingService.updateTicket(id, updatedTicket);
    }

    @DeleteMapping("delete-ticket/{id}")
    public ResponseEntity<AuthResponse> deleteTicket(@PathVariable Long id) {
        return ticketBookingService.deleteTicket(Long.valueOf(id));
    }
}