package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.entity.Gender;
import com.example.datn_motel_project.repository.GenderRepository;
import com.example.datn_motel_project.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderRepository genderRepository;

    @Override
    public List<Gender> findAll(){
        return genderRepository.findAllGender();
    }

    @Override
    public Gender findById(Long id){
        return genderRepository.findAllGenderById(id);
    }

    @Override
    public List<Long> getListIdByMotelId(Long id){
        return genderRepository.findAllIdGenderByMotelId(id);
    }

}
