package com.example.parking;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByEndDate(LocalDateTime endDate);
    Event findBySpaceAndEndDate(Space space, LocalDateTime endDate);
}
