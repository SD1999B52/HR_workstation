package com.workstation.form;

import com.workstation.entity.*;

import java.util.List;

public class EmployeeForm {
    private EmployeeEntity employee;
    private PassportEntity passport;
    private PersonalEntity personal;
    
    private List<HiringEntity> hiring;
    private List<DismissalEntity> dismissal;
    private List<PositionEntity> position;
    
    private List<PhysicalEntity> physical;
    private List<SickEntity> sick;
    
    private List<AssignmentEntity> assignment;
    private List<TrainingEntity> training;
    
    private List<BenefitEntity> benefit;
    private List<VacationEntity> vacation;
    private List<EncouragementEntity> encouragement;

    public EmployeeForm() {
        
    }
    
    public EmployeeForm(EmployeeEntity employee, PassportEntity passport,
    PersonalEntity personal,List<HiringEntity> hiring, 
    List<DismissalEntity> dismissal, List<PositionEntity> position, 
    List<PhysicalEntity> physical, List<SickEntity> sick, 
    List<AssignmentEntity> assignment, List<TrainingEntity> training, 
    List<BenefitEntity> benefit, List<VacationEntity> vacation, 
    List<EncouragementEntity> encouragement) {
        this.employee = employee;
        this.passport = passport;
        this.personal = personal;
        this.hiring = hiring;
        this.dismissal = dismissal;
        this.position = position;
        this.physical = physical;
        this.sick = sick;
        this.assignment = assignment;
        this.training = training;
        this.benefit = benefit;
        this.vacation = vacation;
        this.encouragement = encouragement;
    }
    
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setPassport(PassportEntity passport) {
        this.passport = passport;
    }

    public void setPersonal(PersonalEntity personal) {
        this.personal = personal;
    }

    public void setHiring(List<HiringEntity> hiring) {
        this.hiring = hiring;
    }

    public void setDismissal(List<DismissalEntity> dismissal) {
        this.dismissal = dismissal;
    }

    public void setPosition(List<PositionEntity> position) {
        this.position = position;
    }

    public void setPhysical(List<PhysicalEntity> physical) {
        this.physical = physical;
    }

    public void setSick(List<SickEntity> sick) {
        this.sick = sick;
    }

    public void setAssignment(List<AssignmentEntity> assignment) {
        this.assignment = assignment;
    }

    public void setTraining(List<TrainingEntity> training) {
        this.training = training;
    }

    public void setBenefit(List<BenefitEntity> benefit) {
        this.benefit = benefit;
    }

    public void setVacation(List<VacationEntity> vacation) {
        this.vacation = vacation;
    }

    public void setEncouragement(List<EncouragementEntity> encouragement) {
        this.encouragement = encouragement;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public PassportEntity getPassport() {
        return passport;
    }

    public PersonalEntity getPersonal() {
        return personal;
    }

    public List<HiringEntity> getHiring() {
        return hiring;
    }

    public List<DismissalEntity> getDismissal() {
        return dismissal;
    }

    public List<PositionEntity> getPosition() {
        return position;
    }

    public List<PhysicalEntity> getPhysical() {
        return physical;
    }

    public List<SickEntity> getSick() {
        return sick;
    }

    public List<AssignmentEntity> getAssignment() {
        return assignment;
    }

    public List<TrainingEntity> getTraining() {
        return training;
    }

    public List<BenefitEntity> getBenefit() {
        return benefit;
    }

    public List<VacationEntity> getVacation() {
        return vacation;
    }

    public List<EncouragementEntity> getEncouragement() {
        return encouragement;
    }
}