package com.example.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hotelmanagement.service.HotelService;
import com.example.hotelmanagement.model.Hotel;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    @Autowired
    private HotelService service;

    @GetMapping
    public List<Hotel> getAllBookings() {
        return service.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getBookingById(@PathVariable Long id) {
        return service.getBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Hotel createBooking(@RequestBody Hotel hotel) {
        return service.createOrUpdateBooking(hotel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateBooking(@PathVariable Long id, @RequestBody Hotel hotel) {
        return service.getBookingById(id)
                .map(existingBooking -> {
                    hotel.setId(existingBooking.getId());
                    return ResponseEntity.ok(service.createOrUpdateBooking(hotel));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if (service.getBookingById(id).isPresent()) {
            service.deleteBooking(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
