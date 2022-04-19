package com.example.parking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface SpaceRepository extends JpaRepository<Space, Long> {

    @Query(value="SELECT s FROM Space s WHERE s not in (SELECT e.space FROM Event e WHERE e.endDate is NULL)")
    List<Space> findFreeSpaces();
}
