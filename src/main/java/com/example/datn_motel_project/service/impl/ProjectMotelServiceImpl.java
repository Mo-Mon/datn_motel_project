package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.entity.ProjectMotel;
import com.example.datn_motel_project.repository.ProjectMotelRepository;
import com.example.datn_motel_project.service.ProjectMotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMotelServiceImpl implements ProjectMotelService {
    @Autowired
    private ProjectMotelRepository projectMotelRepository;

    @Override
    public List<ProjectMotel> findAllProjectMotel(){
        return projectMotelRepository.findAllProjectMotel();
    }
}
