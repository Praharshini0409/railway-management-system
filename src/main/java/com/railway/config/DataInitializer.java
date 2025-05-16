package com.railway.config;

import com.railway.models.Train;
import com.railway.models.Passenger;
import com.railway.models.Booking;
import com.railway.repositories.TrainRepository;
import com.railway.repositories.PassengerRepository;
import com.railway.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void run(String... args) {
        // Create sample trains
        Train train1 = new Train();
        train1.setTrainNumber("12345");
        train1.setTrainName("Mumbai Express");
        train1.setSource("Mumbai");
        train1.setDestination("Delhi");
        train1.setFare(1500.00);
        trainRepository.save(train1);

        Train train2 = new Train();
        train2.setTrainNumber("67890");
        train2.setTrainName("Chennai Superfast");
        train2.setSource("Chennai");
        train2.setDestination("Bangalore");
        train2.setFare(800.00);
        trainRepository.save(train2);

        Train train3 = new Train();
        train3.setTrainNumber("54321");
        train3.setTrainName("Kolkata Mail");
        train3.setSource("Kolkata");
        train3.setDestination("Mumbai");
        train3.setFare(2000.00);
        trainRepository.save(train3);

        Train train4 = new Train();
        train4.setTrainNumber("98765");
        train4.setTrainName("Delhi Express");
        train4.setSource("Delhi");
        train4.setDestination("Jaipur");
        train4.setFare(600.00);
        trainRepository.save(train4);

        // Create sample passengers
        Passenger passenger1 = new Passenger();
        passenger1.setName("John Doe");
        passenger1.setEmail("john@example.com");
        passenger1.setPhoneNumber("1234567890");
        passenger1.setAddress("123 Main St, Mumbai");
        passenger1.setIdProof("Aadhar");
        passenger1.setIdProofNumber("123456789012");
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger();
        passenger2.setName("Jane Smith");
        passenger2.setEmail("jane@example.com");
        passenger2.setPhoneNumber("9876543210");
        passenger2.setAddress("456 Park Ave, Delhi");
        passenger2.setIdProof("PAN");
        passenger2.setIdProofNumber("ABCDE1234F");
        passengerRepository.save(passenger2);

        Passenger passenger3 = new Passenger();
        passenger3.setName("Rajesh Kumar");
        passenger3.setEmail("rajesh@example.com");
        passenger3.setPhoneNumber("5555555555");
        passenger3.setAddress("789 Gandhi Rd, Kolkata");
        passenger3.setIdProof("Aadhar");
        passenger3.setIdProofNumber("987654321098");
        passengerRepository.save(passenger3);

        Passenger passenger4 = new Passenger();
        passenger4.setName("Priya Singh");
        passenger4.setEmail("priya@example.com");
        passenger4.setPhoneNumber("4444444444");
        passenger4.setAddress("321 Nehru St, Jaipur");
        passenger4.setIdProof("PAN");
        passenger4.setIdProofNumber("WXYZ1234A");
        passengerRepository.save(passenger4);

        // Create sample bookings
        Booking booking1 = new Booking();
        booking1.setTrain(train1);
        booking1.setPassenger(passenger1);
        booking1.setBookingDate(LocalDateTime.now());
        booking1.setJourneyDate(LocalDateTime.now().plusDays(1));
        booking1.setSeatNumber("A1");
        booking1.setBookingStatus("CONFIRMED");
        booking1.setTotalFare(train1.getFare());
        bookingRepository.save(booking1);

        Booking booking2 = new Booking();
        booking2.setTrain(train2);
        booking2.setPassenger(passenger2);
        booking2.setBookingDate(LocalDateTime.now());
        booking2.setJourneyDate(LocalDateTime.now().plusDays(2));
        booking2.setSeatNumber("B2");
        booking2.setBookingStatus("CONFIRMED");
        booking2.setTotalFare(train2.getFare());
        bookingRepository.save(booking2);

        Booking booking3 = new Booking();
        booking3.setTrain(train3);
        booking3.setPassenger(passenger3);
        booking3.setBookingDate(LocalDateTime.now());
        booking3.setJourneyDate(LocalDateTime.now().plusDays(3));
        booking3.setSeatNumber("C3");
        booking3.setBookingStatus("PENDING");
        booking3.setTotalFare(train3.getFare());
        bookingRepository.save(booking3);

        Booking booking4 = new Booking();
        booking4.setTrain(train4);
        booking4.setPassenger(passenger4);
        booking4.setBookingDate(LocalDateTime.now());
        booking4.setJourneyDate(LocalDateTime.now().plusDays(4));
        booking4.setSeatNumber("D4");
        booking4.setBookingStatus("CANCELLED");
        booking4.setTotalFare(train4.getFare());
        bookingRepository.save(booking4);

        // Additional booking for passenger1
        Booking booking5 = new Booking();
        booking5.setTrain(train3);
        booking5.setPassenger(passenger1);
        booking5.setBookingDate(LocalDateTime.now());
        booking5.setJourneyDate(LocalDateTime.now().plusDays(5));
        booking5.setSeatNumber("E5");
        booking5.setBookingStatus("CONFIRMED");
        booking5.setTotalFare(train3.getFare());
        bookingRepository.save(booking5);
    }
} 