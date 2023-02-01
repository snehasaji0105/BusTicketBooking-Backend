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
    private Integer bus_id;
    private Integer route_id;
    private Integer booked_by_user_id;
    private String booking_date;
    private Integer num_seats;
}
