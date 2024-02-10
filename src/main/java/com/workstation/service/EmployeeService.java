package com.workstation.service;

import com.workstation.form.EmployeeForm;
import com.workstation.entity.*;
import com.workstation.repository.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
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
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, 
    PassportRepository passportRepository, HiringRepository hiringRepository, 
    DismissalRepository dismissalRepository, PositionRepository positionRepository, 
    PhysicalRepository physicalRepository, SickRepository sickRepository, 
    AssignmentRepository assignmentRepository, TrainingRepository trainingRepository, 
    BenefitRepository benefitRepository, VacationRepository vacationRepository, 
    EncouragementRepository encouragementRepository, 
    DepartmentRepository departmentRepository) {
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
        this.departmentRepository = departmentRepository;
    }
    
    //создать/изменить
    public void insertEmployee(EmployeeForm employeeForm) {
        
        //сохраняем сотрудника в бд и получаем его обратно (получение ид и тд)
        EmployeeEntity employeeEntity = employeeRepository.save(employeeForm
        .getEmployee());
        
        //записываем сотрудника в паспортные данные и сохраняем
        PassportEntity passportEntity = employeeForm.getPassport();
        passportEntity.setEmployee(employeeEntity);
        passportRepository.save(passportEntity);
        
        //и тд
        hiringRepository.deleteAllByEmployeeId(employeeEntity.getId());
        if (employeeForm.getHiring() != null) {
            for (HiringEntity hiringEntity : employeeForm.getHiring()) {
                hiringEntity.setEmployee(employeeEntity);
                hiringRepository.save(hiringEntity);
            }
        }
        
        dismissalRepository.deleteAllByEmployeeId(employeeEntity.getId());
        if (employeeForm.getDismissal() != null) {
            for (DismissalEntity dismissalEntity : employeeForm.getDismissal()) {
                dismissalEntity.setEmployee(employeeEntity);
                dismissalRepository.save(dismissalEntity);
            }
        }
        
        positionRepository.deleteAllByEmployeeId(employeeEntity.getId());
        if (employeeForm.getPosition() != null) {
            for (PositionEntity positionEntity : employeeForm.getPosition()) {
                positionEntity.setEmployee(employeeEntity);
                positionRepository.save(positionEntity);
            }
        }
        
        physicalRepository.deleteAllByEmployeeId(employeeEntity.getId());
        if (employeeForm.getPhysical() != null) {
            for (PhysicalEntity physicalEntity : employeeForm.getPhysical()) {
                physicalEntity.setEmployee(employeeEntity);
                physicalRepository.save(physicalEntity);
            }
        }
        
        sickRepository.deleteAllByEmployeeId(employeeEntity.getId());
        if (employeeForm.getSick() != null) {
            for (SickEntity sickEntity : employeeForm.getSick()) {
                sickEntity.setEmployee(employeeEntity);
                sickRepository.save(sickEntity);
            }
        }
        
        assignmentRepository.deleteAllByEmployeeId(employeeEntity.getId());
        if (employeeForm.getAssignment() != null) {
            for (AssignmentEntity assignmentEntity : employeeForm.getAssignment()) {
                assignmentEntity.setEmployee(employeeEntity);
                assignmentRepository.save(assignmentEntity);
            }
        }
        
        trainingRepository.deleteAllByEmployeeId(employeeEntity.getId());
        if (employeeForm.getTraining() != null) {
            for (TrainingEntity trainingEntity : employeeForm.getTraining()) {
                trainingEntity.setEmployee(employeeEntity);
                trainingRepository.save(trainingEntity);
            }
        }
        
        benefitRepository.deleteAllByEmployeeId(employeeEntity.getId());
        if (employeeForm.getBenefit() != null) {
            for (BenefitEntity benefitEntity : employeeForm.getBenefit()) {
                benefitEntity.setEmployee(employeeEntity);
                benefitRepository.save(benefitEntity);
            }
        }
        
        vacationRepository.deleteAllByEmployeeId(employeeEntity.getId());
        if (employeeForm.getVacation() != null) {
            for (VacationEntity vacationEntity : employeeForm.getVacation()) {
                vacationEntity.setEmployee(employeeEntity);
                vacationRepository.save(vacationEntity);
            }
        }
        
        encouragementRepository.deleteAllByEmployeeId(employeeEntity.getId());
        if (employeeForm.getEncouragement() != null) {
            for (EncouragementEntity encouragementEntity : employeeForm
            .getEncouragement()) {
                encouragementEntity.setEmployee(employeeEntity);
                encouragementRepository.save(encouragementEntity);
            }
        }
    }
    
    //получить значения таблицы отделы/цеха
    public List<DepartmentEntity> getDepartments() {
        return departmentRepository.findAll();
    }
    
    //получить сотрудника по иду из таблицы
    public EmployeeEntity getEmployee(Long id) {
        return employeeRepository.findById(id).get();
    }
    
    //получить паспорт по иду сотрудника
    public PassportEntity getPassport(Long id) {
        return passportRepository.findByEmployeeId(id).get();
    }
    
    //получить данные о найме сотрудника
    public List<HiringEntity> getHirings(Long id) {
        return hiringRepository.findByEmployeeId(id);
    }
    
    //получить данные о увольнении сотрудника
    public List<DismissalEntity> getDismissals(Long id) {
        return dismissalRepository.findByEmployeeId(id);
    }
    
    //получить данные о должностях
    public List<PositionEntity> getPositions(Long id) {
        return positionRepository.findByEmployeeId(id);
    }
    
    //получить данные о мед. обслед.
    public List<PhysicalEntity> getPhysicals(Long id) {
        return physicalRepository.findByEmployeeId(id);
    }
    
    //получить данные о больничных листа
    public List<SickEntity> getSicks(Long id) {
        return sickRepository.findByEmployeeId(id);
    }
    
    //получить данные о командировках
    public List<AssignmentEntity> getAssignments(Long id) {
        return assignmentRepository.findByEmployeeId(id);
    }
    
    //получить данные о повышениях квалификации
    public List<TrainingEntity> getTrainings(Long id) {
        return trainingRepository.findByEmployeeId(id);
    }
    
    //получить данные о социальных льготах
    public List<BenefitEntity> getBenefits(Long id) {
        return benefitRepository.findByEmployeeId(id);
    }
    
    //получить данные о отпусках
    public List<VacationEntity> getVacations(Long id) {
        return vacationRepository.findByEmployeeId(id);
    }
    
    //получить данные о поощрениях
    public List<EncouragementEntity> getEncouragements(Long id) {
        return encouragementRepository.findByEmployeeId(id);
    }
}