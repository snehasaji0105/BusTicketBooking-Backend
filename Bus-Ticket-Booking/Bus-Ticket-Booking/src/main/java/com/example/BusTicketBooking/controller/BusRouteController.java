package com.example.BusTicketBooking.controller;

import com.example.BusTicketBooking.dto.AuthResponse;

import com.example.BusTicketBooking.model.BusRoute;

import com.example.BusTicketBooking.service.BusRouteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/route")
public class BusRouteController {
    final Logger logger = LoggerFactory.getLogger(BusRouteController.class);
    @Autowired
    private BusRouteService busRouteService;


    @PostMapping("add-busRoute")
    public ResponseEntity<AuthResponse> addBusRoute(@RequestBody BusRoute busRoute) {
        return  busRouteService.addBusRoute(busRoute);
    }
    @GetMapping("get-busRoute")
    public ResponseEntity<List<BusRoute>> getBusRoute() {
        return busRouteService.getBusRoute();
    }
    @PutMapping("update-busRoute")
    public ResponseEntity<AuthResponse> updateBusRoute(@PathVariable Integer id,@RequestBody BusRoute updatedBusRoute){
        return busRouteService.updateBusRoute(id,updatedBusRoute);
    }
    @DeleteMapping("delete-busRoute/{id}")
    public ResponseEntity<AuthResponse> deleteBusRoute(@PathVariable Integer id) {
        return busRouteService.deleteBusRoute(id);
    }

}
