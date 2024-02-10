package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//информация о командировках сотрудников

@Entity
@Table(name = "assignments")
public class AssignmentEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //номер сотрудника
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //место командировки
    @Column(name = "place", columnDefinition = "text")
    private String place;
    
    //номер приказа
    @Column(name = "number", columnDefinition = "text")
    private String number;
    
    //дополнительные сведения
    @Column(name = "information", columnDefinition = "text")
    private String information;
    
    //дата начала командировки
    @Column(name = "dosbt", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dosbt;
    
    //дата конца командировки
    @Column(name = "doebt", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date doebt;
    
    public AssignmentEntity() {
        
    }

    public AssignmentEntity(EmployeeEntity employee, String place, 
    String number, String information, Date dosbt, Date doebt) {
        this.employee = employee;
        this.place = place;
        this.number = number;
        this.information = information;
        this.dosbt = dosbt;
        this.doebt = doebt;
    }

    public Long getId() {
        return id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public String getPlace() {
        return place;
    }

    public String getNumber() {
        return number;
    }

    public String getInformation() {
        return information;
    }

    public Date getDosbt() {
        return dosbt;
    }

    public Date getDoebt() {
        return doebt;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setDosbt(Date dosbt) {
        this.dosbt = dosbt;
    }

    public void setDoebt(Date doebt) {
        this.doebt = doebt;
    }
    
    @Override
    public String toString() {
        return "Assignments [id=" + id 
                + ", employee=" + employee
                + ", place=" + place
                + ", number=" + number
                + ", information=" + information
                + ", dosbt=" + dosbt
                + ", doebt=" + doebt
                + "]";
    }
}