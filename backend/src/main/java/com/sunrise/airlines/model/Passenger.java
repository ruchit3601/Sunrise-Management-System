package com.sunrise.airlines.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @Column(name = "passport")
    private String passport;

    @Column(name = "name")
    private String name;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    public Passenger() {
    }

    public Passenger(String name, String nationality, Long phone, String address, String passport, String gender) {
        this.name = name;
        this.nationality = nationality;
        this.phone = phone;
        this.address = address;
        this.passport = passport;
        this.gender = gender;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
