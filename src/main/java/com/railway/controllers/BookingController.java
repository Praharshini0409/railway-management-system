package com.railway.controllers;

import com.railway.models.Booking;
import com.railway.models.Passenger;
import com.railway.models.Train;
import com.railway.repositories.BookingRepository;
import com.railway.repositories.PassengerRepository;
import com.railway.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private TrainRepository trainRepository;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return bookingRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        // Validate passenger and train exist
        if (!passengerRepository.existsById(booking.getPassenger().getId())) {
            return ResponseEntity.badRequest().body("Passenger not found");
        }
        if (!trainRepository.existsById(booking.getTrain().getId())) {
            return ResponseEntity.badRequest().body("Train not found");
        }

        // Set booking date to current time
        booking.setBookingDate(LocalDateTime.now());
        booking.setBookingStatus("CONFIRMED");
        
        // Calculate total fare
        Train train = trainRepository.findById(booking.getTrain().getId()).get();
        booking.setTotalFare(train.getFare());

        Booking savedBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(savedBooking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
        return bookingRepository.findById(id)
                .map(booking -> {
                    booking.setJourneyDate(bookingDetails.getJourneyDate());
                    booking.setSeatNumber(bookingDetails.getSeatNumber());
                    booking.setBookingStatus(bookingDetails.getBookingStatus());
                    Booking updatedBooking = bookingRepository.save(booking);
                    return ResponseEntity.ok(updatedBooking);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        return bookingRepository.findById(id)
                .map(booking -> {
                    bookingRepository.delete(booking);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/passenger/{passengerId}")
    public List<Booking> getBookingsByPassenger(@PathVariable Long passengerId) {
        return bookingRepository.findByPassengerId(passengerId);
    }

    @GetMapping("/train/{trainId}")
    public List<Booking> getBookingsByTrain(@PathVariable Long trainId) {
        return bookingRepository.findByTrainId(trainId);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id) {
        return bookingRepository.findById(id)
                .map(booking -> {
                    booking.setBookingStatus("CANCELLED");
                    Booking updatedBooking = bookingRepository.save(booking);
                    return ResponseEntity.ok(updatedBooking);
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 