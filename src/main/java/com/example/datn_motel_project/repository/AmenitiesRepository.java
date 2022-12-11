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

    @Query(value = "select a.id from motel as m \n" +
            "inner join motel_amenities_detail as mad on ( m.id = mad.motel_id and m.delete_flag = 0 )\n" +
            "inner join amenities as a on ( mad.amenties_id = a.id and a.delete_flag = 0 )\n" +
            "where m.id = ?1 and a.type = ?2", nativeQuery = true)
    public List<Long> findAmenitiesInOutIdByMotelId(Long motelId, String type);


}
