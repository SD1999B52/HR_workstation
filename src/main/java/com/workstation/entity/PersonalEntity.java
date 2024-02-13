package com.workstation.entity;

import javax.persistence.*;

//персональная документация сотрудника

@Entity
@Table(name = "personals")
public class PersonalEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //данные сотрудника
    @OneToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //ИНН
    @Column(name = "inn", columnDefinition = "text")
    private String inn;
    
    //СНИЛС
    @Column(name = "snils", columnDefinition = "text")
    private String snils;
    
    //военный билет
    @Column(name = "milid", columnDefinition = "text")
    private String milid;
    
    //банковские реквизиты
    @Column(name = "bankdet", columnDefinition = "text")
    private String bankdet;
    
    //СТД-Р
    @Column(name = "stdr", columnDefinition = "text")
    private String stdr;
    
    public PersonalEntity() {
        
    }
    
    public PersonalEntity(EmployeeEntity employee, String inn, String snils, 
    String milid, String bankdet, String stdr) {
        this.employee = employee;
        this.inn = inn;
        this.snils = snils;
        this.milid = milid;
        this.bankdet = bankdet;
        this.stdr = stdr;
    }

    public Long getId() {
        return id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public String getInn() {
        return inn;
    }

    public String getSnils() {
        return snils;
    }

    public String getMilid() {
        return milid;
    }

    public String getBankdet() {
        return bankdet;
    }

    public String getStdr() {
        return stdr;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public void setMilid(String milid) {
        this.milid = milid;
    }

    public void setBankdet(String bankdet) {
        this.bankdet = bankdet;
    }

    public void setStdr(String stdr) {
        this.stdr = stdr;
    }
    
    @Override
    public String toString() {
        return "Personal [id=" + id 
                + ", employee=" + employee
                + ", inn=" + inn
                + ", snils=" + snils
                + ", milid=" + milid
                + ", bankdet=" + bankdet
                + ", stdr=" + stdr
                + "]";
    }
}