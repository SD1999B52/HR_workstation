package com.workstation.entity;

import javax.persistence.*;

//информация об отделах предприятия

@Entity
@Table(name = "departments")
public class DepartmentEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //наименование
    @Column(name = "name", columnDefinition = "text")
    private String name;
    
    //номер кабинета/цеха
    @Column(name = "number", columnDefinition = "bigint")
    private Long number;
    
    public DepartmentEntity() {
        
    }
    
    public DepartmentEntity(String name, Long number) {
        this.name = name;
        this.number = number;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public Long getNumber() {
        return number;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setNumber(Long number) {
        this.number = number;
    }
    
    @Override
    public String toString() {
        return "Departments [id=" + id 
                + ", name=" + name
                + ", number=" + number
                + "]";
    }
}