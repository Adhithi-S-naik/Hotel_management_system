package com.example.hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotelmanagement.model.Hotel;
import com.example.hotelmanagement.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository repository;

    public List<Hotel> getAllBookings() {
        return repository.findAll();
    }

    public Optional<Hotel> getBookingById(Long id) {
        return repository.findById(id);
    }

    public Hotel createOrUpdateBooking(Hotel hotel) {
        return repository.save(hotel);
    }

    public void deleteBooking(Long id) {
        repository.deleteById(id);
    }
}
