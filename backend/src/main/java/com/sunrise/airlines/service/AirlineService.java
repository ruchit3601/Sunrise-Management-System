package com.sunrise.airlines.service;

import com.sunrise.airlines.model.Flight;
import com.sunrise.airlines.model.Passenger;
import com.sunrise.airlines.model.Reservation;
import com.sunrise.airlines.repository.FlightRepository;
import com.sunrise.airlines.repository.PassengerRepository;
import com.sunrise.airlines.repository.ReservationRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final ReservationRepository reservationRepository;

    public AirlineService(FlightRepository flightRepository, PassengerRepository passengerRepository, ReservationRepository reservationRepository) {
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.reservationRepository = reservationRepository;
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> findFlightsByRoute(String source, String destination) {
        return flightRepository.findAll().stream()
                .filter(flight -> source.equalsIgnoreCase(flight.getSource())
                        && destination.equalsIgnoreCase(flight.getDestination()))
                .toList();
    }

    public Passenger getPassengerByPassport(String passport) {
        return passengerRepository.findById(passport).orElse(null);
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
