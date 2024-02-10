package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//информация о медицинских обследованиях сотрудников

@Entity
@Table(name = "physicals")
public class PhysicalEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //номер сотрудника
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //дата обследования
    @Column(name = "dome", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dome;
    
    //медучреждение
    @Column(name = "institution", columnDefinition = "text")
    private String institution;
    
    //заключение врачей
    @Column(name = "conclusion", columnDefinition = "text")
    private String conclusion;
    
    public PhysicalEntity() {
        
    }

    public PhysicalEntity(EmployeeEntity employee, Date dome, 
    String institution, String conclusion) {
        this.employee = employee;
        this.dome = dome;
        this.institution = institution;
        this.conclusion = conclusion;
    }

    public Long getId() {
        return id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public Date getDome() {
        return dome;
    }

    public String getInstitution() {
        return institution;
    }

    public String getConclusion() {
        return conclusion;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setDome(Date dome) {
        this.dome = dome;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
    
    @Override
    public String toString() {
        return "Physicals [id=" + id 
                + ", employee=" + employee
                + ", dome=" + dome
                + ", institution=" + institution
                + ", conclusion=" + conclusion
                + "]";
    }
}