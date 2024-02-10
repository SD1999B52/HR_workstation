package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//информация о социальных льготах сотрудников

@Entity
@Table(name = "benefits")
public class BenefitEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //номер сотрудника
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //наименование льготы
    @Column(name = "name", columnDefinition = "text")
    private String name;
    
    //номер документа
    @Column(name = "document", columnDefinition = "text")
    private String document;
    
    //дата начала действия
    @Column(name = "dosb", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dosb;
    
    public BenefitEntity() {
        
    }
    
    public BenefitEntity(EmployeeEntity employee, String name, 
    String document, Date dosb) {
        this.employee = employee;
        this.name = name;
        this.document = document;
        this.dosb = dosb;
    }
    
    public Long getId() {
        return id;
    }
    
    public EmployeeEntity getEmployee() {
        return employee;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDocument() {
        return document;
    }
    
    public Date getDosb() {
        return dosb;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDocument(String document) {
        this.document = document;
    }

    public void setDosb(Date dosb) {
        this.dosb = dosb;
    }
    
    @Override
    public String toString() {
        return "Benefits [id=" + id 
                + ", employee=" + employee
                + ", name=" + name
                + ", document=" + document
                + ", dosb=" + dosb
                + "]";
    }
}