package com.workstation.service;

import java.util.List;
import java.util.Optional;

import com.workstation.entity.DepartmentEntity;
import com.workstation.repository.DepartmentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentsService {
    private final DepartmentRepository departmentRepository;
    
    public DepartmentsService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    
    public void insertDepartment(DepartmentEntity departmentEntity) {
        departmentRepository.save(departmentEntity);
    }
    
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
    
    public Optional<DepartmentEntity> getDepartment(Long id) {
        return departmentRepository.findById(id);
    }
    
    public List<DepartmentEntity> getDepartments() {
        return departmentRepository.findAll();
    }
    
    //получить значения таблицы разделенное на страницы
    public Page<DepartmentEntity> getDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }
}