package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Amenities extends BaseEntity {
    private String name;
    private boolean flagCustomSeller;
    private String type;

    @ManyToMany(mappedBy = "amenities")
    private Set<Motel> motels;


}
