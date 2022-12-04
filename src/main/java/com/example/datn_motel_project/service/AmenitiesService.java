package com.example.datn_motel_project.service;

import com.example.datn_motel_project.entity.Amenities;

import java.util.List;

public interface AmenitiesService {
    Amenities findById(Long id);

    List<Amenities> findAmenities(String type, Long accountId);
}
