package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository  extends JpaRepository<Image,Long> {
}
