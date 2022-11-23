package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.dto.AccountInfoDto;
import com.example.datn_motel_project.entity.AccountTransactionDetail;
import com.example.datn_motel_project.entity.Motel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MotelRepository  extends JpaRepository<Motel,Long> {
    @Query(value = "SELECT a.id as id ,a.full_name as name , a.phone as tel , a.email as email " +
            " FROM motel as m inner join account as a on m.account_id = a.id where m.id = ?1",nativeQuery = true)
    public AccountInfoDto getAccountPortMotel(Long motelId);
}
