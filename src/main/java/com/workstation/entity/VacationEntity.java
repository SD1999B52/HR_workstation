package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//информация об отпусках сотрудников

@Entity
@Table(name = "vacations")
public class VacationEntity {
    
    //номер записи 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //номер сотрудника
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //вид отпуска
    @Column(name = "tov", columnDefinition = "text")
    private String tov;
    
    //основание отпуска
    @Column(name = "bases", columnDefinition = "text")
    private String bases;
    
    //дата начала отпуска
    @Column(name = "dosv", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dosv;
    
    //дата конца отпуска
    @Column(name = "doev", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date doev;
    
    public VacationEntity() {
        
    }
    
    public VacationEntity(EmployeeEntity employee, String tov, 
    String bases, Date dosv, Date doev) {
        this.employee = employee;
        this.tov = tov;
        this.bases = bases;
        this.dosv = dosv;
        this.doev = doev;
    }
    
    public Long getId() {
        return id;
    }
    
    public EmployeeEntity getEmployee() {
        return employee;
    }
    
    public String getTov() {
        return tov;
    }
    
    public String getBases() {
        return bases;
    }
    
    public Date getDosv() {
        return dosv;
    }
    
    public Date getDoev() {
        return doev;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
    
    public void setTov(String tov) {
        this.tov = tov;
    }
    
    public void setBases(String bases) {
        this.bases = bases;
    }
    
    public void setDosv(Date dosv) {
        this.dosv = dosv;
    }
    
    public void setDoev(Date doev) {
        this.doev = doev;
    }
    
    @Override
    public String toString() {
        return "Vacations [id=" + id 
                + ", employee=" + employee 
                + ", tov=" + tov 
                + ", bases=" + bases 
                + ", dosv=" + dosv 
                + ", doev=" + doev 
                + "]";
    }
}