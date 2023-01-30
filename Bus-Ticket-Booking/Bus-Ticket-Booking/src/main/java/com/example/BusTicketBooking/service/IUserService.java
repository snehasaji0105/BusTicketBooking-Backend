package com.example.BusTicketBooking.service;


import com.example.BusTicketBooking.model.User;

import java.util.Optional;

public interface IUserService {

  Integer saveUser(User user);

    Optional<User> findByUsername(String username);
}
