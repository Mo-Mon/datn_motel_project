package com.example.datn_motel_project.service;

import com.example.datn_motel_project.entity.Location;

import java.util.List;

public interface LocationService {
    Long getIdLocationByMotelId(Long id);

    public List<String> getListLocation();

    List<Location> findAllLocation();

    Location findLocationById(Long id);
}
