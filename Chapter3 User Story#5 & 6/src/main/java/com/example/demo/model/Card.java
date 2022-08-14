package com.example.demo.model;

import java.time.LocalDate;

public class Card {

    private final String number;
    private final String owner;
    private final LocalDate expiry;
    private final int CIV;

    private String pin;

    public Card(String number, String owner, LocalDate expiry, int CIV) {
        this.number = number;
        this.owner = owner;
        this.expiry = expiry;
        this.CIV = CIV;
    }

    public String getPin(){
        return this.pin;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public int getCIV() {
        return CIV;
    }

    public String getOwner() {
        return owner;
    }
}
