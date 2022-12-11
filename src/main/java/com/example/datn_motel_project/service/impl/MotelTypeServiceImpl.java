package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.entity.MotelType;
import com.example.datn_motel_project.repository.MotelTypeRepository;
import com.example.datn_motel_project.service.MotelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotelTypeServiceImpl implements MotelTypeService {
    @Autowired
    private MotelTypeRepository motelTypeRepository;

    @Override
    public List<String> getAllNameMotelType(){
        return  motelTypeRepository.getAllNameMotelType();
    }

    @Override
    public List<MotelType> findAllMotelType(){
        return motelTypeRepository.findAllMotelType();
    }

    @Override
    public MotelType findMotelTypeById(Long id){
        return motelTypeRepository.findMotelTypeById(id);
    }

    @Override
    public List<MotelType> findMotelTypeByMotelId(Long motelId){
        return motelTypeRepository.findMotelTypeByMotelId(motelId);
    }

    @Override
    public List<Long> finMotelTypeIdByMotelId(Long motelId){
        return motelTypeRepository.findMotelTypeIdByMotelId(motelId);
    }

}
