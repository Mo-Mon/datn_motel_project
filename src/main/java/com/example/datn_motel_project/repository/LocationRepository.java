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

    @Query(value = "SELECT l.* FROM motel as m inner join location as l on (m.location_id = l.id and l.delete_flag = 0)" +
            "where m.id = ?1 and m.delete_flag = 0",nativeQuery = true)
    public Location findLocationByMotelId(Long id);

    @Query(value = "SELECT l.id FROM motel as m inner join location as l on (m.location_id = l.id and l.delete_flag = 0)" +
            "where m.id = ?1 and m.delete_flag = 0",nativeQuery = true)
    public Long findLocationIdByMotelId(Long id);
}
