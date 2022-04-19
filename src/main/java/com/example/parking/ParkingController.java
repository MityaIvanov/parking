package com.example.parking;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class ParkingController {

    private final EventRepository eventRepository;
    private final CarRepository carRepository;

    private final SpaceRepository spaceRepository;

    ParkingController(EventRepository eventRepository, CarRepository carRepository, SpaceRepository spaceRepository) {
        this.eventRepository = eventRepository;
        this.carRepository = carRepository;
        this.spaceRepository = spaceRepository;
    }


    // PUT http://localhost:8080/occupy/3?date=2022-04-12T14:00
    /*
    {
    "name": "Suzuki",
    "phone": "+7928",
    "plate": "123"
}
     */
    // Занять парковочное место
    @Transactional(rollbackFor=Exception.class)
    @PutMapping("/occupy/{id}")
    public String
    occupySpace(@RequestParam(name="date") String begDate, @RequestBody Car car,@PathVariable("id") Long spaceId)
    {
        Car saved = carRepository.save(car);
        Space space = spaceRepository.getById(spaceId);
        Event event = new Event(saved, space, LocalDateTime.parse(begDate), null, null);
        eventRepository.save(event);
        return "occupied: [" + spaceId + "] at [" + begDate + "] with " + saved.toString();
    }

    // Освободить парковочное место
    // PUT http://localhost:8080/free/3?date=2022-04-12T19:00
    @PutMapping("/free/{id}")
    public String
    freeSpace(@RequestParam(name="date") String endDate, @PathVariable("id") Long spaceId)
    {
        Optional<Space> space = spaceRepository.findById(spaceId);
        if (!space.isEmpty()) {
            Event event = eventRepository.findBySpaceAndEndDate(space.get(), null);
            event.setEndDate(LocalDateTime.parse(endDate));
            eventRepository.save(event);
        }
        return "free space: " + spaceId + " at " + endDate;
    }

    // Загрузка парковки
    // GET http://localhost:8080/loading
    @GetMapping("/loading")
    public ResponseEntity<List<Event>> fetchParkingLoading()
    {
        List<Event> events = eventRepository.findByEndDate(null);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("occupied-spaces", String.valueOf(events.size()) + "/" + spaceRepository.count());
        return new ResponseEntity<List<Event>>(events, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/freespaces")
    public ResponseEntity<List<Space>> fetchFreeSpaces()
    {
        List<Space> spaces = spaceRepository.findFreeSpaces();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("free-spaces", String.valueOf(spaces.size()) + "/" + spaceRepository.count());
        return new ResponseEntity<List<Space>>(spaces, responseHeaders, HttpStatus.OK);
    }
}
