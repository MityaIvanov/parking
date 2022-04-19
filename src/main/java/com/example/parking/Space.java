package com.example.parking;

// Парковочное место

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Space {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public String getNumber() {
        return number;
    }

    private String number; // Номер парковочного места

    protected Space() {}

    protected Space(String number) {this.number = number;}

    public Long getId() {
        return id;
    }
}
