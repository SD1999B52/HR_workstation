package com.workstation.repository;

import com.workstation.entity.HiringEntity;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiringRepository extends JpaRepository<HiringEntity, Long> {
    void deleteByEmployeeId(Long id);
    void deleteAllByEmployeeId(Long id);
    List<HiringEntity> findByEmployeeId(Long id);
}