package com.example.datn_motel_project.service;

import com.example.datn_motel_project.entity.Gender;

import java.util.List;

public interface GenderService {
    List<Gender> findAll();

    Gender findById(Long id);
}
