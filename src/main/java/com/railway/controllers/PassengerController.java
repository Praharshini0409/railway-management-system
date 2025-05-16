package com.railway.controllers;

import com.railway.models.Passenger;
import com.railway.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        return passengerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passengerDetails) {
        return passengerRepository.findById(id)
                .map(passenger -> {
                    passenger.setName(passengerDetails.getName());
                    passenger.setEmail(passengerDetails.getEmail());
                    passenger.setPhoneNumber(passengerDetails.getPhoneNumber());
                    passenger.setAddress(passengerDetails.getAddress());
                    passenger.setIdProof(passengerDetails.getIdProof());
                    passenger.setIdProofNumber(passengerDetails.getIdProofNumber());
                    Passenger updatedPassenger = passengerRepository.save(passenger);
                    return ResponseEntity.ok(updatedPassenger);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePassenger(@PathVariable Long id) {
        return passengerRepository.findById(id)
                .map(passenger -> {
                    passengerRepository.delete(passenger);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 