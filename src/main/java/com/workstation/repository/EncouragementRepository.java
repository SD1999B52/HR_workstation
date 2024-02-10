package com.workstation.repository;

import com.workstation.entity.EncouragementEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncouragementRepository extends JpaRepository<EncouragementEntity, 
Long> {
    void deleteByEmployeeId(Long id);
    void deleteAllByEmployeeId(Long id);
    List<EncouragementEntity> findByEmployeeId(Long id);
}