package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseEntity {
    private String path;
    private String name;
    @ManyToOne
    @JoinColumn(name = "motel_id")
    private Motel motel;
}
