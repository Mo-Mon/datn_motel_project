package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.AccountTransactionDetail;
import com.example.datn_motel_project.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenderRepository  extends JpaRepository<Gender,Long> {
    @Query(value = "select * from gender where delete_flag = 0",nativeQuery = true)
    public List<Gender> findAllGender();

    @Query(value = "select * from gender where delete_flag = 0 and id = ?1",nativeQuery = true)
    public Gender findAllGenderById(Long id);

    @Query(value = "SELECT distinct g.* FROM motel as m inner join motel_limit_gender as mlg on (m.id = mlg.motel_id and m.delete_flag = 0) inner join gender as g on (mlg.gender_id = g.id and g.delete_flag = 0)\n" +
            "where m.id = ?1 ",nativeQuery = true)
    public List<Gender> findAllGenderByMotelId(Long motelId);

    @Query(value = "SELECT distinct g.id FROM motel as m inner join motel_limit_gender as mlg on (m.id = mlg.motel_id and m.delete_flag = 0) inner join gender as g on (mlg.gender_id = g.id and g.delete_flag = 0)\n" +
            "where m.id = ?1 ",nativeQuery = true)
    public List<Long> findAllIdGenderByMotelId(Long motelId);
}
