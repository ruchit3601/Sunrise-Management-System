package com.sunrise.airlines.service;

import com.sunrise.airlines.model.Flight;
import com.sunrise.airlines.model.Reservation;
import com.sunrise.airlines.repository.FlightRepository;
import com.sunrise.airlines.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class AirlineService {

    private final FlightRepository flightRepository;
    private final ReservationRepository reservationRepository;

    public AirlineService(FlightRepository flightRepository, ReservationRepository reservationRepository) {
        this.flightRepository = flightRepository;
        this.reservationRepository = reservationRepository;
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Reservation createReservation(Reservation reservation) {
        if (reservation.getPnr() == null || reservation.getPnr().isBlank()) {
            reservation.setPnr("PNR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        if (reservation.getTicket() == null || reservation.getTicket().isBlank()) {
            reservation.setTicket("TICKET-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase());
        }
        if (reservation.getBookDate() == null) {
            reservation.setBookDate(LocalDate.now());
        }
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
