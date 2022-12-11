package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ImageRepository  extends JpaRepository<Image,Long> {

    @Query(value = "select distinct i.* from motel as m " +
            "inner join image as i on ( m.id = i.motel_id and i.delete_flag = 0) " +
            "where  m.id = ?1 and m.delete_flag = 0", nativeQuery = true)
    public List<Image> findImageByMotelId(Long id);

    @Query(value = "select distinct * from image where delete_flag = 0 and id = ?1",nativeQuery = true)
    public Optional<Image> findById(Long id);
}
