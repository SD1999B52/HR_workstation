package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//список шаблонов документов

@Entity
@Table(name = "templates")
public class TemplateEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //имя шаблона
    @Column(name = "name", columnDefinition = "text")
    private String name;
    
    //путь к шаблону на сервере
    @Column(name = "file", columnDefinition = "text")
    private String file;
    
    //дата загрузки шаблона
    @Column(name = "dod", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dod;
    
    public TemplateEntity() {
        
    }
    
    public TemplateEntity(String name, String file, 
    Date dod) {
        this.name = name;
        this.file = file;
        this.dod = dod;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setFile(String file) {
        this.file = file;
    }
    
    public void setDod(Date dod) {
        this.dod = dod;
    }
    
    @Override
    public String toString() {
        return "Templates [id=" + id 
                + ", name=" + name 
                + ", file=" + file
                + ", dod=" + dod
                + "]";
    }
}