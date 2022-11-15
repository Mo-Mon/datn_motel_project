package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.repository.TimePayRepository;
import com.example.datn_motel_project.service.TimePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TimePayServiceImpl implements TimePayService {
    @Autowired
    private TimePayRepository timePayRepository;

    public List<String> getListStringTimePay(){
        return timePayRepository.getListStringTimePay();
    }

}
