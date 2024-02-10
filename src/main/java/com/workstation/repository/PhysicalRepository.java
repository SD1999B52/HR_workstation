package com.workstation.repository;

import com.workstation.entity.PhysicalEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalRepository extends JpaRepository<PhysicalEntity, Long> {
    void deleteByEmployeeId(Long id);
    void deleteAllByEmployeeId(Long id);
    List<PhysicalEntity> findByEmployeeId(Long id);
}