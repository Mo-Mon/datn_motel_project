package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProjectMotel extends BaseEntity {

    private String name;

    private String info;

    @OneToMany(mappedBy = "projectMotel", cascade = CascadeType.ALL)
    private Set<Motel> motels;


}
