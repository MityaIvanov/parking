package com.example.parking;

// Parking space event
// Событие парковки

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name="space_id")
    private Space space;

    private LocalDateTime begDate;
    private LocalDateTime endDate;
    private BigDecimal cost;

    protected Event() { }

    public Event(Car car, Space space, LocalDateTime begDate, LocalDateTime endDate, BigDecimal cost) {
        this.car = car;
        this.space = space;
        this.begDate = begDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public Space getSpace() {
        return space;
    }

    public LocalDateTime getBegDate() {
        return begDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setEndDate(LocalDateTime date) {
        this.endDate = date;
    }
}
