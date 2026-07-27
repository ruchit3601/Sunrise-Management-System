package com.sunrise.airlines.controller;

import com.sunrise.airlines.model.Flight;
import com.sunrise.airlines.model.Passenger;
import com.sunrise.airlines.model.Reservation;
import com.sunrise.airlines.service.AirlineService;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AirlineController.class)
class AirlineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirlineService airlineService;

    @Test
    void createFlightShouldReturnCreatedFlight() throws Exception {
        Flight flight = new Flight("AI101", "Sunrise Air", "Delhi", "Mumbai");
        flight.setId(1L);
        Mockito.when(airlineService.createFlight(any(Flight.class))).thenReturn(flight);

        mockMvc.perform(post("/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"flightCode\":\"AI101\",\"flightName\":\"Sunrise Air\",\"source\":\"Delhi\",\"destination\":\"Mumbai\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.flightCode").value("AI101"));
    }

    @Test
    void getPassengerShouldReturnPassengerDetails() throws Exception {
        Passenger passenger = new Passenger("Jane Doe", "Indian", 9876543210L, "Mumbai", "P123", "Female");
        Mockito.when(airlineService.getPassengerByPassport("P123")).thenReturn(passenger);

        mockMvc.perform(get("/passengers/P123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.passport").value("P123"));
    }

    @Test
    void getBookingsShouldReturnBookings() throws Exception {
        Reservation reservation = new Reservation("PNR-123", "TICKET-321", "P123", "Jane Doe", "Indian",
                "Sunrise Air", "AI101", "Delhi", "Mumbai", LocalDate.now());
        Mockito.when(airlineService.getAllReservations()).thenReturn(List.of(reservation));

        mockMvc.perform(get("/bookings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].pnr").value("PNR-123"));
    }
}
