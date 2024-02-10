package com.workstation.repository;

import com.workstation.entity.TrainingEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingEntity, Long> {
    void deleteByEmployeeId(Long id);
    void deleteAllByEmployeeId(Long id);
    List<TrainingEntity> findByEmployeeId(Long id);
}