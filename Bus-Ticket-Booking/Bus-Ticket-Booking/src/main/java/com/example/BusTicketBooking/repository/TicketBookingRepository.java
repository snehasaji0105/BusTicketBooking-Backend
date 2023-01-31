package com.example.BusTicketBooking.repository;


import com.example.BusTicketBooking.model.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketBookingRepository extends JpaRepository<TicketBooking,String> {
    List<TicketBooking> findById(int bus_id);

}