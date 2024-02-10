package com.workstation.repository;

import com.workstation.entity.BenefitEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends JpaRepository<BenefitEntity, Long> {
    void deleteByEmployeeId(Long id);
    void deleteAllByEmployeeId(Long id);
    List<BenefitEntity> findByEmployeeId(Long id);
}