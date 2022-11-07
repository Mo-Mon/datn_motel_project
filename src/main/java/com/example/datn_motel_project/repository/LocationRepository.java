package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository  extends JpaRepository<Location,Long> {
}
