package com.example.datn_motel_project.service;

import com.example.datn_motel_project.entity.ProjectMotel;

import java.util.List;

public interface ProjectMotelService {
    List<ProjectMotel> findAllProjectMotel();

    Long findIdByMotelId(Long id);

    ProjectMotel findByMotelId(Long id);
}
