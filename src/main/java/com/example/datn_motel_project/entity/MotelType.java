package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MotelType extends BaseEntity {
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "motelType", fetch = FetchType.LAZY)
    private Set<Motel> motels;
}
