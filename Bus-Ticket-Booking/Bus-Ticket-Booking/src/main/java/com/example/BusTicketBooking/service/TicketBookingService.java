package com.example.BusTicketBooking.service;



;

import com.example.BusTicketBooking.dto.AuthResponse;
import com.example.BusTicketBooking.exception.ResourceNotFoundException;
import com.example.BusTicketBooking.model.TicketBooking;
import com.example.BusTicketBooking.repository.TicketBookingRepository;
import com.example.BusTicketBooking.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketBookingService {
    final Logger logger = LoggerFactory.getLogger(TicketBookingService.class);
    @Autowired
    private TicketBookingRepository ticketBookingRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<TicketBooking>> getAllTickets() {
        logger.info("all tickets");
        return ResponseEntity.ok(ticketBookingRepository.findAll());
    }

    public ResponseEntity<List<TicketBooking>> getTicket(String id) {
        logger.info("all tickets");
        return ResponseEntity.ok(ticketBookingRepository.findAll());
    }

    public ResponseEntity<AuthResponse> addTicket(TicketBooking ticketBooking) {
        try {
            logger.info("added ticket");
            ticketBookingRepository.save(ticketBooking);
            return ResponseEntity.ok(new AuthResponse(" added successfully", true));
        } catch (Exception e) {
            throw new ResourceNotFoundException("ticket", e.getMessage(), "creating new ticket error");
        }


    }

//    public ResponseEntity<AuthResponse> updateTicket(String id, TicketBooking updatedTicket) {
//        TicketBooking oldTicket = TicketBookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course", courseName, "not exist"));
//        oldTicket.setDestination(updatedTicket.getDestination());
//        oldTicket.setSource(updatedTicket.getSource());
//        oldTicket.setNo_of_passengers(updatedTicket.getNo_of_passengers());
//
//        courseRepository.save(oldCourse);
//        logger.info("updated Ticket");
//        return ResponseEntity.ok(new AuthResponse(String.format("%s is updated", id), true));
//    }

    public ResponseEntity<AuthResponse> deleteTicket(String id) {
        TicketBooking ticketBooking = ticketBookingRepository.findById(Integer.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("BusTicketBooking", id, "not exist"));
        logger.info("deleted course");
        ticketBookingRepository.delete(ticketBooking);
        return ResponseEntity.ok(new AuthResponse(String.format("%s is deleted", id), true));
    }


}



