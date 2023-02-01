package com.example.BusTicketBooking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bus",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"bus_id"})})
@Getter
@Setter
@ToString
@RequiredArgsConstructor

@AllArgsConstructor

public class Bus {
    @Id
    private Integer bus_id;
    private Integer bus_number;
    private String bus_name;
    private Integer total_seats;
    private String route_source;
    private String route_destination;

}
