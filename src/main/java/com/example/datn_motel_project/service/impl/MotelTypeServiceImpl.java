package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.repository.MotelTypeRepository;
import com.example.datn_motel_project.service.MotelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotelTypeServiceImpl implements MotelTypeService {
    @Autowired
    private MotelTypeRepository motelTypeRepository;
    public List<String> getAllNameMotelType(){
        return  motelTypeRepository.getAllNameMotelType();
    }
}
