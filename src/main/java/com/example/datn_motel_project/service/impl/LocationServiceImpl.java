package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.entity.Location;
import com.example.datn_motel_project.repository.LocationRepository;
import com.example.datn_motel_project.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<String> getListLocation(){
        List<String> listLocation = new ArrayList<>();
        for(Location location : locationRepository.findAll()){
            listLocation.add(location.getName());
        }
        return listLocation;
    }

    @Override
    public List<Location> findAllLocation(){
        return locationRepository.findAllLocation();
    }

    @Override
    public Location findLocationById(Long id){
        return locationRepository.findAllLocationById(id);
    }
}
