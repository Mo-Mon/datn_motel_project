package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.ProjectMotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectMotelRepository  extends JpaRepository<ProjectMotel,Long> {
    @Query(value = "select * from project_motel where delete_flag = 0 ",nativeQuery = true)
    public List<ProjectMotel> findAllProjectMotel();
}
