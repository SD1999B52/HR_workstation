package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//информация о приеме на работу сотрудников

@Entity
@Table(name = "hirings")
public class HiringEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //данные сотрудника
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //дата приема на работу
    @Column(name = "doh", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date doh;
    
    //заметки
    @Column(name = "notes", columnDefinition = "text")
    private String notes;

    public HiringEntity() {
        
    }

    public HiringEntity(EmployeeEntity employee, Date doh, String notes) {
        this.employee = employee;
        this.doh = doh;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public Date getDoh() {
        return doh;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setDoh(Date doh) {
        this.doh = doh;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }
    
    @Override
    public String toString() {
        return "Hirings [id=" + id 
                + ", employee=" + employee
                + ", doh=" + doh
                + ", notes=" + notes
                + "]";
    }
}