package com.workstation.repository;

import com.workstation.entity.SickEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SickRepository extends JpaRepository<SickEntity, Long> {
    void deleteByEmployeeId(Long id);
    void deleteAllByEmployeeId(Long id);
    List<SickEntity> findByEmployeeId(Long id);
}