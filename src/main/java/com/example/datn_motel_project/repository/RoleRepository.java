package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query(value = "select * from role inner join user_role on role.id = user_role.role_id inner join account on user_role.user_id = account.id where account.id = ?1 ",nativeQuery = true)
    public List<Role> findAllRoleByAccountId(Long id);
}
