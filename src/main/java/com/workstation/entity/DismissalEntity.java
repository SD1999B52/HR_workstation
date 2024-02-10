package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//информация о увольнении сотрудников

@Entity
@Table(name = "dismissals")
public class DismissalEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //номер сотрудника
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //дата увольнения
    @Column(name = "dod", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dod;
    
    //заметки
    @Column(name = "notes", columnDefinition = "text")
    private String notes;
    
    public DismissalEntity() {
        
    }

    public DismissalEntity(EmployeeEntity employee, Date dod, String notes) {
        this.employee = employee;
        this.dod = dod;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public Date getDod() {
        return dod;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }
    
    @Override
    public String toString() {
        return "Dismissals [id=" + id 
                + ", employee=" + employee
                + ", dod=" + dod
                + ", notes=" + notes
                + "]";
    }
}