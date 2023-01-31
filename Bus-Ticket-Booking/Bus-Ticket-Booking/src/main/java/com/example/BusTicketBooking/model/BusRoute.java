package com.example.BusTicketBooking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "busRoute",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"bus_id"})})
@Getter
@Setter
@ToString
@RequiredArgsConstructor

@AllArgsConstructor


public class BusRoute {
    @Id
    private String busRoute_id;
    private String bus_id;
    private String source;
    private String destination;
    private String journey_date;

}
