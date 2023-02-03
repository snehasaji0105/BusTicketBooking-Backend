package com.example.BusTicketBooking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@AllArgsConstructor

public class TicketBooking {
    @Id
    private Integer busId;
    private Integer routeId;
    private Integer bookedByUserId;
    private String bookingDate;
    private Integer numSeats;
}
