package com.workstation.repository;

import com.workstation.entity.PassportEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<PassportEntity, Long> {
    void deleteByEmployeeId(Long id);
    void deleteAllByEmployeeId(Long id);
    Optional<PassportEntity> findByEmployeeId(Long id);
}