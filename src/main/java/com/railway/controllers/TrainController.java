package com.railway.controllers;

import com.railway.models.Train;
import com.railway.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainRepository trainRepository;

    @GetMapping
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable Long id) {
        return trainRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Train createTrain(@RequestBody Train train) {
        return trainRepository.save(train);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Train> updateTrain(@PathVariable Long id, @RequestBody Train trainDetails) {
        return trainRepository.findById(id)
                .map(train -> {
                    train.setTrainNumber(trainDetails.getTrainNumber());
                    train.setTrainName(trainDetails.getTrainName());
                    train.setSource(trainDetails.getSource());
                    train.setDestination(trainDetails.getDestination());
                    train.setFare(trainDetails.getFare());
                    Train updatedTrain = trainRepository.save(train);
                    return ResponseEntity.ok(updatedTrain);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrain(@PathVariable Long id) {
        return trainRepository.findById(id)
                .map(train -> {
                    trainRepository.delete(train);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 