package com.workstation.entity;

//DateTimeFormat работает нормально только с этой датой
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//основная информация о сотрудниках

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //фамилия
    @Column(name = "surname", columnDefinition = "text")
    private String surname;
    
    //имя
    @Column(name = "name", columnDefinition = "text")
    private String name;
    
    //отчество
    @Column(name = "patronymic", columnDefinition = "text")
    private String patronymic;
    
    //дата рождения
    @Column(name = "dob", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dob;
    
    //образование
    @Column(name = "education", columnDefinition = "text")
    private String education;
    
    //номер телефона
    @Column(name = "phone", columnDefinition = "text")
    private String phone;
    
    public EmployeeEntity() {
        
    }

    public EmployeeEntity(String surname, String name, 
    String patronymic, Date dob, String education, String phone) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dob = dob;
        this.education = education;
        this.phone = phone;
    }
    
    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getDob() {
        return dob;
    }

    public String getEducation() {
        return education;
    }

    public String getPhone() {
        return phone;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return "employees [id=" + id 
                + ", surname=" + surname
                + ", name=" + name
                + ", patronymic=" + patronymic
                + ", dob=" + dob
                + ", education=" + education
                + ", phone=" + phone
                + "]";
    }
}