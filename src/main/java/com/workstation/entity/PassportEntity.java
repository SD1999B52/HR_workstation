package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//основные реквизиты паспортов сотрудников

@Entity
@Table(name = "passports")
public class PassportEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //данные сотрудника
    @OneToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //серия паспорта
    @Column(name = "series", columnDefinition = "text")
    private String series;
    
    //номер паспорта
    @Column(name = "number", columnDefinition = "text")
    private String number;
    
    //кем выдан
    @Column(name = "issued", columnDefinition = "text")
    private String issued;
    
    //когда выдан
    @Column(name = "doi", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date doi;
    
    //прописка
    @Column(name = "registration", columnDefinition = "text")
    private String registration;
    
    public PassportEntity() {
        
    }

    public PassportEntity(EmployeeEntity employee, String series, 
    String number, String issued, Date doi, String registration) {
        this.employee = employee;
        this.series = series;
        this.number = number;
        this.issued = issued;
        this.doi = doi;
        this.registration = registration;
    }

    public Long getId() {
        return id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public String getSeries() {
        return series;
    }

    public String getNumber() {
        return number;
    }

    public String getIssued() {
        return issued;
    }

    public Date getDoi() {
        return doi;
    }

    public String getRegistration() {
        return registration;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public void setDoi(Date doi) {
        this.doi = doi;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
    
    @Override
    public String toString() {
        return "Passport [id=" + id 
                + ", employee=" + employee
                + ", series=" + series
                + ", number=" + number
                + ", issued=" + issued
                + ", doi=" + doi
                + ", registration=" + registration
                + "]";
    }
}