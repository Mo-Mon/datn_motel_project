package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.entity.Amenities;
import com.example.datn_motel_project.repository.AmenitiesRepository;
import com.example.datn_motel_project.service.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenitiesServiceImpl implements AmenitiesService {
    @Autowired
    private AmenitiesRepository amenitiesRepository;

    @Override
    public Amenities findById(Long id){
        return amenitiesRepository.findAllById(id);
    }

    @Override
    public List<Amenities> findAmenities(String type, Long accountId){
        if(accountId == null){
            if(type == null){
                return amenitiesRepository.findAll();
            }else{
                return amenitiesRepository.findAllByMasterInOut(type);
            }
        }else {
            if(type == null){
                return amenitiesRepository.getAmenitiesByAccount(accountId);
            }else{
                return amenitiesRepository.findAmenitiesInOutByAccount(type, accountId);
            }
        }
    }

    @Override
    public List<Long> findAmenitiesInIdByMotelId(Long motelId){
        return amenitiesRepository.findAmenitiesInOutIdByMotelId(motelId,"0");
    }

    @Override
    public List<Long> findAmenitiesOutIdByMotelId(Long motelId){
        return amenitiesRepository.findAmenitiesInOutIdByMotelId(motelId,"1");
    }
}
