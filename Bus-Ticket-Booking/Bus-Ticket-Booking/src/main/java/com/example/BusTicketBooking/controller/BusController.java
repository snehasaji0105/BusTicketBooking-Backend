package com.example.BusTicketBooking.controller;

import com.example.BusTicketBooking.dto.AuthResponse;
import com.example.BusTicketBooking.model.Bus;
import com.example.BusTicketBooking.service.BusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class BusController {
    final Logger logger = LoggerFactory.getLogger(BusController.class);
//    @Autowired
//    private BusService busService;
    @Bean
    public BusService busService(){
        return new BusService();
    }

    @PostMapping("add-bus")
    public ResponseEntity<AuthResponse> addBus(@RequestBody Bus bus) {

        return busService().addBus(bus);
    }
    @GetMapping("get-bus")
    public ResponseEntity<List<Bus>> getBus() {
        return busService().getBus();
    }
    @PutMapping("update-bus/{id}")
    public ResponseEntity<AuthResponse> updateBus(@PathVariable Long id,@RequestBody Bus updatedBus) {
        return busService().updateBus(id,updatedBus);
    }
    @DeleteMapping("delete-bus/{id}")
    public ResponseEntity<AuthResponse> deleteBus(@PathVariable Long id) {
        return busService().deleteBus(id);
    }
}
