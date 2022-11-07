package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.MotelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MotelTypeRepository  extends JpaRepository<MotelType,Long> {
    @Query(value = "SELECT name FROM motel_type", nativeQuery = true)
    public List<String> getAllNameMotelType();

}
