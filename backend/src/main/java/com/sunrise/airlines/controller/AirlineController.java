package com.sunrise.airlines.controller;

import com.sunrise.airlines.model.Flight;
import com.sunrise.airlines.model.Reservation;
import com.sunrise.airlines.service.AirlineService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping("/flights")
    public Flight createFlight(@Valid @RequestBody Flight flight) {
        return airlineService.createFlight(flight);
    }

    @GetMapping("/flights")
    public List<Flight> getFlights() {
        return airlineService.getAllFlights();
    }

    @PostMapping("/bookings")
    public Reservation createBooking(@Valid @RequestBody Reservation reservation) {
        return airlineService.createReservation(reservation);
    }

    @GetMapping("/bookings")
    public List<Reservation> getBookings() {
        return airlineService.getAllReservations();
    }
}
