package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

//информация о документе и его расположении на сервере

@Entity
@Table(name = "documents")
public class DocumentEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //номер сотрудника загрузившего документ
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //имя документа (изначальное)
    @Column(name = "name", columnDefinition = "text", nullable = false)
    private String name;
    
    //размер документа
    @Column(name = "dsize", columnDefinition = "bigint", nullable = false)
    private Long dsize;
    
    //путь к файлу на сервере
    @Column(name = "file", columnDefinition = "text", nullable = false)
    private String file;
    
    //дата загрузки документа
    @CreationTimestamp
    @Column(name = "dod", columnDefinition = "timestamp", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dod;
    
    public DocumentEntity() {
        
    }
    
    public DocumentEntity(EmployeeEntity employee, String name, Long dsize, 
    String file, Date dod) {
        this.employee = employee;
        this.name = name;
        this.dsize = dsize;
        this.file = file;
        this.dod = dod;
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
    
    public Long getDsize() {
        return dsize;
    }
    
    public String getFile() {
        return file;
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDsize(Long dsize) {
        this.dsize = dsize;
    }
    
    public void setFile(String file) {
        this.file = file;
    }
    
    public void setDod(Date dod) {
        this.dod = dod;
    }
    
    @Override
    public String toString() {
        return "Documents [id=" + id 
                + ", employee=" + employee
                + ", name=" + name
                + ", dsize=" + dsize
                + ", file=" + file
                + ", dod=" + dod
                + "]";
    }
}