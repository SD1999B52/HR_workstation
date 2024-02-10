package com.workstation.repository;

import com.workstation.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, 
PagingAndSortingRepository<UserEntity, Long> {
    Boolean existsByUsername(String username);
    void deleteByEmployeeId(Long id);
    void deleteAllByEmployeeId(Long id);
    UserEntity findByUsername(String username);
}