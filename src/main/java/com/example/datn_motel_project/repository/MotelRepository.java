package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.dto.AccountInfoDto;
import com.example.datn_motel_project.dto.MotelSubDto;
import com.example.datn_motel_project.entity.AccountTransactionDetail;
import com.example.datn_motel_project.entity.Motel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MotelRepository  extends JpaRepository<Motel,Long> {
    @Query(value = "SELECT a.id as id ,a.full_name as name , a.phone as tel , a.email as email, a.create_at as timeJoin, a.address as address" +
            " FROM motel as m inner join account as a on m.account_id = a.id where m.id = ?1 and m.delete_flag = 0",nativeQuery = true)
    public AccountInfoDto getAccountPortMotel(Long motelId);

    @Query(value = "select distinct mpid.deposits, mpid.price, tp.id as typePayId  from   motel as m \n" +
            "inner join (motel_pay_info_detail as mpid inner join time_pay as tp on (mpid.time_pay_id = tp.id and tp.delete_flag = 0 )) on (m.id = mpid.motel_id and mpid.delete_flag = 0)  \n" +
            "where  m.id = ?1 and m.delete_flag = 0" , nativeQuery = true)
    public MotelSubDto findInfoSubByMotelId(Long id);
}
