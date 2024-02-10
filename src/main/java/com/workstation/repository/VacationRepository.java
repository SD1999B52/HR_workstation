package com.workstation.repository;

import com.workstation.entity.VacationEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRepository extends JpaRepository<VacationEntity, Long> {
    void deleteByEmployeeId(Long id);
    void deleteAllByEmployeeId(Long id);
    List<VacationEntity> findByEmployeeId(Long id);
}