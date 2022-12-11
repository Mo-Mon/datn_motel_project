package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.MotelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MotelTypeRepository  extends JpaRepository<MotelType,Long> {

    @Query(value = "SELECT name FROM motel_type where delete_flag = 0", nativeQuery = true)
    public List<String> getAllNameMotelType();

    @Query(value = "SELECT * FROM motel_type where delete_flag = 0", nativeQuery = true)
    public List<MotelType> findAllMotelType();

    @Query(value = "SELECT * FROM motel_type where delete_flag = 0 and id = ?1", nativeQuery = true)
    public MotelType findMotelTypeById(Long id);

    @Query(value = "select mt.* From motel as m " +
            "inner join motel_type_detail as mtd on ( m.id = mtd.motel_id and m.delete_flag = 0 ) " +
            "inner join motel_type as mt on ( mtd.type_id = mt.id and mt.delete_flag = 0) " +
            "where m.id = ?1",nativeQuery = true)
    public List<MotelType> findMotelTypeByMotelId(Long motelId);

    @Query(value = "select mt.id From motel as m " +
            "inner join motel_type_detail as mtd on ( m.id = mtd.motel_id and m.delete_flag = 0 ) " +
            "inner join motel_type as mt on ( mtd.type_id = mt.id and mt.delete_flag = 0) " +
            "where m.id = ?1",nativeQuery = true)
    public List<Long> findMotelTypeIdByMotelId(Long motelId);
}
