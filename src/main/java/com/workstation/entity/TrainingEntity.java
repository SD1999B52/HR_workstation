package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//информация о повышениях квалификаций сотрудников

@Entity
@Table(name = "trainings")
public class TrainingEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //номер сотрудника
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //дополнительные сведения
    @Column(name = "information", columnDefinition = "text")
    private String information;
    
    //дата начала повышения квалификации
    @Column(name = "dosat", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dosat;
    
    //дата конца повышения квалификации
    @Column(name = "doeat", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date doeat;
    
    //учреждение
    @Column(name = "institution", columnDefinition = "text")
    private String institution;
    
    public TrainingEntity() {
        
    }

    public TrainingEntity(EmployeeEntity employee, String information, 
    Date dosat, Date doeat, String institution) {
        this.employee = employee;
        this.information = information;
        this.dosat = dosat;
        this.doeat = doeat;
        this.institution = institution;
    }

    public Long getId() {
        return id;
    }
    
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public String getInformation() {
        return information;
    }

    public Date getDosat() {
        return dosat;
    }
    
    public Date getDoeat() {
        return doeat;
    }

    public String getInstitution() {
        return institution;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setDosat(Date dosat) {
        this.dosat = dosat;
    }
    
    public void setDoeat(Date doeat) {
        this.doeat = doeat;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
    
    @Override
    public String toString() {
        return "Trainings [id=" + id 
                + ", employee=" + employee
                + ", information=" + information
                + ", dosat=" + dosat
                + ", doeat=" + doeat
                + ", institution=" + institution
                + "]";
    }
}