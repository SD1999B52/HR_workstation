package com.workstation.repository;

import com.workstation.entity.DismissalEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DismissalRepository extends JpaRepository<DismissalEntity, 
Long> {
    void deleteByEmployeeId(Long id);
    void deleteAllByEmployeeId(Long id);
    List<DismissalEntity> findByEmployeeId(Long id);
}