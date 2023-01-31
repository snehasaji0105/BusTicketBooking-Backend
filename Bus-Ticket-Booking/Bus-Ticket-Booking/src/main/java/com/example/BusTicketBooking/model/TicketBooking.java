package com.example.BusTicketBooking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"bus_id"})})
@Getter
@Setter
@ToString
@RequiredArgsConstructor

@AllArgsConstructor


public class TicketBooking {
    @Id
    private String ticket_id;
    private String bus_id;
    private String destination;
    private String source;
    private String no_of_passengers;

}
