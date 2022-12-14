package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Location extends BaseEntity {
    private String name;
    private String info;
    @OneToMany(mappedBy = "location")
    private Set<Motel> motels;
}
