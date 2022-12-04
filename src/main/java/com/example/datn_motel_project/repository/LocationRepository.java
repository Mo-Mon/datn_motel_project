package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository  extends JpaRepository<Location,Long> {
    @Query(value = "select * from location where delete_flag = 0",nativeQuery = true)
    public List<Location> findAllLocation();

    @Query(value = "select * from location where delete_flag = 0 and id =?1",nativeQuery = true)
    public Location findAllLocationById(Long id);
}
