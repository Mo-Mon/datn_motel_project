package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.AccountTransactionDetail;
import com.example.datn_motel_project.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository  extends JpaRepository<Gender,Long> {
}
