package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Amenities extends BaseEntity {
    private String name;
    private boolean flagCustomSeller;
    private String type;
    private Long accountId;

    @ManyToMany(mappedBy = "amenities")
    private Set<Motel> motels;


}
