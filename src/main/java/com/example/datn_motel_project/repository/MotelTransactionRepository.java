package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.MotelTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotelTransactionRepository  extends JpaRepository<MotelTransaction,Long> {
}
