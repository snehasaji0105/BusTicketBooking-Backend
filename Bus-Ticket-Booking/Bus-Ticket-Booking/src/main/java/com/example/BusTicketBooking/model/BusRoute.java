package com.example.BusTicketBooking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "busRoute",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"journey_date"})})
@Getter
@Setter
@ToString
@RequiredArgsConstructor

@AllArgsConstructor


public class BusRoute {
    @Id
   private Integer route_id;
    private Integer bus_id;
    private String journey_date;
    private Integer booked_seats;

}
