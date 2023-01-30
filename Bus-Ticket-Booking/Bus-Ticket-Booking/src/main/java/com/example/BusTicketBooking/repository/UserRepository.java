package com.example.BusTicketBooking.repository;


import com.example.BusTicketBooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);


    Boolean existsByEmail(String email);
}
