package com.example.datn_motel_project.repository;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class MotelInfoRepository {
    @PersistenceContext
    private EntityManager em;

}
