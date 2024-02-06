package com.springProject.booking.hotel;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query(value = "SELECT h FROM Hotel h WHERE h.location = ?1")
    Optional<Hotel> findHotelByLocation(String location);

}
