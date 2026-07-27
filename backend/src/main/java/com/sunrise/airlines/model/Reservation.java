package com.sunrise.airlines.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "pnr")
    private String pnr;

    @Column(name = "ticket")
    private String ticket;

    @Column(name = "passport")
    private String passport;

    @Column(name = "name")
    private String name;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "flightname")
    private String flightName;

    @Column(name = "flightcode")
    private String flightCode;

    @Column(name = "departure")
    private String departure;

    @Column(name = "destination1")
    private String destination;

    @Column(name = "book_date")
    private LocalDate bookDate;

    public Reservation() {
    }

    public Reservation(String pnr, String ticket, String passport, String name, String nationality,
                       String flightName, String flightCode, String departure, String destination, LocalDate bookDate) {
        this.pnr = pnr;
        this.ticket = ticket;
        this.passport = passport;
        this.name = name;
        this.nationality = nationality;
        this.flightName = flightName;
        this.flightCode = flightCode;
        this.departure = departure;
        this.destination = destination;
        this.bookDate = bookDate;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDate bookDate) {
        this.bookDate = bookDate;
    }
}
