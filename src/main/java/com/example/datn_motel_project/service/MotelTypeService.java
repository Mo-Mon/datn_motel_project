package com.example.datn_motel_project.service;

import com.example.datn_motel_project.entity.MotelType;

import java.util.List;

public interface MotelTypeService {
    public List<String> getAllNameMotelType();

    List<MotelType> findAllMotelType();

    MotelType findMotelTypeById(Long id);
}
