package com.example.BusTicketBooking.service;

import com.example.BusTicketBooking.dto.AuthResponse;
import com.example.BusTicketBooking.exception.ResourceNotFoundException;
import com.example.BusTicketBooking.model.Bus;

import com.example.BusTicketBooking.repository.BusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BusService {
    final Logger logger = LoggerFactory.getLogger(BusService.class);

    @Autowired
    private BusRepository busRepository;
    public ResponseEntity<AuthResponse> addBus(Bus bus) {
        String methodName ="addBus";
        try {
            logger.info("Entering Method "+methodName);

            busRepository.save(bus);
            logger.info("Bus added successfully :: "+bus.getBusId());
            return ResponseEntity.ok(new AuthResponse("added successfully",true));
        } catch (Exception e) {
            logger.error("Failed adding Bus "+bus.getBusId());
            e.printStackTrace();
            throw new ResourceNotFoundException("bus",e.getMessage(), "creating new bus error");
        }
    }
    public ResponseEntity<List<Bus>> getBus() {
        logger.info("Get Bus");
        return ResponseEntity.ok(busRepository.findAll());
    }

    public ResponseEntity<AuthResponse> updateBus(Long id, Bus updatedBus) {
        Bus oldBus =busRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bus", "id", "not exist"));
        oldBus.setBusNumber(updatedBus.getBusNumber());
        oldBus.setBusName(updatedBus.getBusName());
        oldBus.setTotalSeats(updatedBus.getTotalSeats());
        oldBus.setRouteDestination(updatedBus.getRouteDestination());
        oldBus.setRouteSource(updatedBus.getRouteSource());

        busRepository.save(oldBus);
        logger.info("updated Bus");
        return ResponseEntity.ok(new AuthResponse(String.format("%s is updated", id), true));
    }
    public ResponseEntity<AuthResponse> deleteBus(Long id) {
        Bus bus = busRepository.findById(Long.valueOf(Integer.valueOf(Math.toIntExact(id)))).orElseThrow(() -> new ResourceNotFoundException("Bus", "id", "not exist"));
        logger.info("deleted bus");
        busRepository.delete(bus);
        return ResponseEntity.ok(new AuthResponse(String.format("%s is deleted", id), true));
    }

}
