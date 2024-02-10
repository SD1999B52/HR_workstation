package com.workstation.repository;

import com.workstation.entity.DepartmentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, 
Long>, PagingAndSortingRepository<DepartmentEntity, Long> {
    
}