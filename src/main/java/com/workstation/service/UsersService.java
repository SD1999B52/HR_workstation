package com.workstation.service;

import java.util.List;
import java.util.Optional;

import com.workstation.entity.EmployeeEntity;
import com.workstation.entity.UserEntity;
import com.workstation.repository.EmployeeRepository;
import com.workstation.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public UsersService(EmployeeRepository employeeRepository, 
    UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }
    
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
    
    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }
    
    public void insertUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
    
    public Optional<UserEntity> getUser(Long id) {
        return userRepository.findById(id);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    //получить значения таблицы разделенное на страницы
    public Page<UserEntity> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}