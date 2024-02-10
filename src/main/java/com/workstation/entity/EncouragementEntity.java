package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//информация о поощрениях сотрудников

@Entity
@Table(name = "encouragements")
public class EncouragementEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //номер сотрудника
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //тип поощрения
    @Column(name = "toe", columnDefinition = "text")
    private String toe;
    
    //основание поощрения
    @Column(name = "bases", columnDefinition = "text")
    private String bases;
    
    //номер документа
    @Column(name = "document", columnDefinition = "text")
    private String document;
    
    //дата поощрения
    @Column(name = "doe", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date doe;
    
    public EncouragementEntity() {
        
    }

    public EncouragementEntity(EmployeeEntity employee, String toe, 
    String bases, String document, Date doe) {
        this.employee = employee;
        this.toe = toe;
        this.bases = bases;
        this.document = document;
        this.doe = doe;
    }

    public Long getId() {
        return id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public String getToe() {
        return toe;
    }

    public String getBases() {
        return bases;
    }

    public String getDocument() {
        return document;
    }

    public Date getDoe() {
        return doe;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setToe(String toe) {
        this.toe = toe;
    }

    public void setBases(String bases) {
        this.bases = bases;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setDoe(Date doe) {
        this.doe = doe;
    }
    
    @Override
    public String toString() {
        return "Encouragements [id=" + id 
                + ", employee=" + employee
                + ", toe=" + toe
                + ", bases=" + bases
                + ", document=" + document
                + ", doe=" + doe
                + "]";
    }
}