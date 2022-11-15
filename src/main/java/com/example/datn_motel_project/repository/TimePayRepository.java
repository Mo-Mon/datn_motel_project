package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.TimePay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimePayRepository  extends JpaRepository<TimePay,Long> {
    @Query(value = "select type_time from time_pay",nativeQuery = true)
    public List<String> getListStringTimePay();
}
