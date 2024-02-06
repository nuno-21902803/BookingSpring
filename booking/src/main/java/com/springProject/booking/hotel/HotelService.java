package com.springProject.booking.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    public void addHotel(Hotel hotel) {
        Optional<Hotel> hotelOptional = hotelRepository.findHotelByLocation(hotel.getLocation());

        if (hotelOptional.isPresent())
            throw new IllegalStateException("Hotel with this location already created!!!");

        hotelRepository.save(hotel);
    }

    public void deleteHotel(Long hotelId) {
        if (!hotelRepository.existsById(hotelId)) {
            throw new IllegalStateException("Hotel with id " + hotelId + " does not exists");
        }

        hotelRepository.deleteById(hotelId);
    }

    @Transactional
    public void updateHotel(Long hotelId, String name, Double pricePerNight, String location) {
        Hotel hotel = hotelRepository.findById(
                hotelId).orElseThrow(() -> new IllegalStateException("Hotel with id " + hotelId + " does not exists"));

        if(location == null)
            throw new IllegalStateException("The location must be defined");

        hotel.setName(name);
        hotel.setLocation(location);
        hotel.setPricePerNight(pricePerNight);

    }
}
