package com.example.datn_motel_project.service;

import com.example.datn_motel_project.entity.TimePay;

import java.util.List;

public interface TimePayService {
    List<TimePay> findAllTimePay();

    public List<String> getListStringTimePay();
    public String getStringTimePayById(Integer id);
}
