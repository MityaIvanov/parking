package com.example.parking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String plate; // Госномер

    protected Car() {}

    public Car(String name, String phone, String plate) {
        this.name = name;
        this.phone = phone;
        this.plate = plate;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Car[id=%d, name='%s', phone='%s', plate='%s']", id, name, phone, plate);
    }
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPlate() {
        return plate;
    }
}
