package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AmenitiesRepository  extends JpaRepository<Amenities,Long> {

    @Query(value = "select * from amenities where delete_flag = 0 and ( flag_custom_seller  = 0 or account_id = ?1)",nativeQuery = true)
    public List<Amenities> getAmenitiesByAccount(Long accountId);

    @Query(value = "select * from amenities where delete_flag = 0 and flag_custom_seller  = 0", nativeQuery = true)
    public List<Amenities> findAllByMaster();

    @Query(value = "select * from amenities where delete_flag = 0 ", nativeQuery = true)
    public List<Amenities> findAll();

    @Query(value = "select * from amenities where delete_flag = 0 and type = ?1 and ( flag_custom_seller  = 0 or account_id = ?2)",nativeQuery = true)
    public List<Amenities> findAmenitiesInOutByAccount(String type,Long accountId);

    @Query(value = "select * from amenities where delete_flag = 0 and flag_custom_seller  = 0 and type = ?1", nativeQuery = true)
    public List<Amenities> findAllByMasterInOut(String type);

    @Query(value = "select * from amenities where delete_flag = 0 and id = ?1", nativeQuery = true)
    public Amenities findAllById(Long id);
}
