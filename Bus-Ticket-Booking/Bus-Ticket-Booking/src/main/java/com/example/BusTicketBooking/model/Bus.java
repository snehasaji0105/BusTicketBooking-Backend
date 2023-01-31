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
    private String bus_id;
    private String bus_name;
    private String bus_number;
    private String destination;
    private String source;


}
