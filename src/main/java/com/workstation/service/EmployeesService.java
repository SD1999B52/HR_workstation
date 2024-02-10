package com.workstation.service;

import com.workstation.entity.EmployeeEntity;
import com.workstation.repository.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeesService {
    private final EmployeeRepository employeeRepository;
    private final PassportRepository passportRepository;
    private final HiringRepository hiringRepository;
    private final DismissalRepository dismissalRepository;
    private final PositionRepository positionRepository;
    private final PhysicalRepository physicalRepository;
    private final SickRepository sickRepository;
    private final AssignmentRepository assignmentRepository;
    private final TrainingRepository trainingRepository;
    private final BenefitRepository benefitRepository;
    private final VacationRepository vacationRepository;
    private final EncouragementRepository encouragementRepository;
    
    public EmployeesService(EmployeeRepository employeeRepository, 
    PassportRepository passportRepository, HiringRepository hiringRepository, 
    DismissalRepository dismissalRepository, PositionRepository positionRepository, 
    PhysicalRepository physicalRepository, SickRepository sickRepository, 
    AssignmentRepository assignmentRepository, TrainingRepository trainingRepository, 
    BenefitRepository benefitRepository, VacationRepository vacationRepository, 
    EncouragementRepository encouragementRepository) {
        this.employeeRepository = employeeRepository;
        this.passportRepository = passportRepository;
        this.hiringRepository = hiringRepository;
        this.dismissalRepository = dismissalRepository;
        this.positionRepository = positionRepository;
        this.physicalRepository = physicalRepository;
        this.sickRepository = sickRepository;
        this.assignmentRepository = assignmentRepository;
        this.trainingRepository = trainingRepository;
        this.benefitRepository = benefitRepository;
        this.vacationRepository = vacationRepository;
        this.encouragementRepository = encouragementRepository;
    }
    
    //удалить сотрудника со всеми его рабочими и персональными данными
    //смотреть на карточке
    public void deleteEmployee(Long id) {
        passportRepository.deleteByEmployeeId(id);
        hiringRepository.deleteByEmployeeId(id);
        dismissalRepository.deleteByEmployeeId(id);
        positionRepository.deleteByEmployeeId(id);
        physicalRepository.deleteByEmployeeId(id);
        sickRepository.deleteByEmployeeId(id);
        assignmentRepository.deleteByEmployeeId(id);
        trainingRepository.deleteByEmployeeId(id);
        benefitRepository.deleteByEmployeeId(id);
        vacationRepository.deleteByEmployeeId(id);
        encouragementRepository.deleteByEmployeeId(id);
        
        employeeRepository.deleteById(id);
    }
    
    //получить значения таблицы разделенное на страницы
    public Page<EmployeeEntity> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}