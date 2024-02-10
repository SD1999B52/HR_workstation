package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//информация о больничных листах сотрудников

@Entity
@Table(name = "sick")
public class SickEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //номер сотрудника
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //номер больничного листа
    @Column(name = "certificate", columnDefinition = "text")
    private String certificate;
    
    //дата начала нетрудоспособности
    @Column(name = "dossl", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dossl;
    
    //дата конца нетрудоспособности
    @Column(name = "doesl", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date doesl;
    
    public SickEntity() {
        
    }
    
    public SickEntity(EmployeeEntity employee, String certificate, 
    Date dossl, Date doesl) {
        this.employee = employee;
        this.certificate = certificate;
        this.dossl = dossl;
        this.doesl = doesl;
    }
    
    public Long getId() {
        return id;
    }
    
    public EmployeeEntity getEmployee() {
        return employee;
    }
    
    public String getCertificate() {
        return certificate;
    }
    
    public Date getDossl() {
        return dossl;
    }
    
    public Date getDoesl() {
        return doesl;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
    
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
    
    public void setDossl(Date dossl) {
        this.dossl = dossl;
    }
    
    public void setDoesl(Date doesl) {
        this.doesl = doesl;
    }
    
    @Override
    public String toString() {
        return "Sick [id=" + id 
                + ", employee=" + employee
                + ", certificate=" + certificate
                + ", dossl=" + dossl
                + ", doesl=" + doesl
                + "]";
    }
}