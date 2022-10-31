package com.example.datn_motel_project.entity.base;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Date updateAt;
    private Boolean deleteFlag;
    private String updateBy;
    private Date createAt;
    private String createBy;
}
