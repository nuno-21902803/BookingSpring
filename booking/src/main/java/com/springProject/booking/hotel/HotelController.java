package com.springProject.booking.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1/hotel")
@RestController()
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getHotels() {
        return hotelService.getHotels();
    }

    @PostMapping
    public void addHotel(@RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
    }


    @DeleteMapping(path = "{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") Long hotelId) {
        hotelService.deleteHotel(hotelId);
    }

    @PutMapping(path = "{hotelId}")
    public void uppdateHotel(
            @PathVariable("hotelId") Long hotelId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double pricePerNight,
            @RequestParam(required = false) String location
    ) {
        hotelService.updateHotel(hotelId, name, pricePerNight, location);
    }
}
