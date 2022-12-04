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
}
