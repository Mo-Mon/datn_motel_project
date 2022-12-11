package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.dto.AccountInfoDto;
import com.example.datn_motel_project.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountByEmail(String email);

    @Query(value = "SELECT a.id as id ,a.full_name as name , a.phone as tel , a.email as email, a.create_at as timeJoin, a.address as address" +
            " FROM account as a where a.id = ?1 and a.delete_flag = 0",nativeQuery = true)
    public AccountInfoDto getAccountInfo(Long id);
}
