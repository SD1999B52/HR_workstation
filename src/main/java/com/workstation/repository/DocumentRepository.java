package com.workstation.repository;

import com.workstation.entity.DocumentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long>, 
PagingAndSortingRepository<DocumentEntity, Long> {
    
}