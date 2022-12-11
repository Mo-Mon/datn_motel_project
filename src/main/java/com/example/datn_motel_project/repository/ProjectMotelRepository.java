package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.ProjectMotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectMotelRepository  extends JpaRepository<ProjectMotel,Long> {
    @Query(value = "select * from project_motel where delete_flag = 0 ",nativeQuery = true)
    public List<ProjectMotel> findAllProjectMotel();

    @Query(value = "SELECT pm.id FROM motel as m inner join project_motel as pm on (m.project_id = pm.id and pm.delete_flag = 0)\n" +
            "where m.id = ?1 and m.delete_flag = 0", nativeQuery = true)
    public Long findIdByMotelId(Long id);

    @Query(value = "SELECT pm.* FROM motel as m inner join project_motel as pm on (m.project_id = pm.id and pm.delete_flag = 0)\n" +
            "where m.id = ?1 and m.delete_flag = 0", nativeQuery = true)
    public ProjectMotel findByMotelId(Long id);
}
