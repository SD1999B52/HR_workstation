package com.workstation.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//информация о должностях сотрудников

@Entity
@Table(name = "positions")
public class PositionEntity {
    
    //номер записи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //номер сотрудника
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //код отдела/цеха
    @ManyToOne
    @JoinColumn(name = "dept", nullable = false)
    private DepartmentEntity dept;
    
    //наименование должности
    @Column(name = "name", columnDefinition = "text")
    private String name;
    
    //оклад (/100 РМ)
    @Column(name = "salary", columnDefinition = "bigint")
    private Long salary;
    
    //дата назначения
    @Column(name = "doe", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date doe;
    
    public PositionEntity() {
        
    }

    public PositionEntity(EmployeeEntity employee, DepartmentEntity dept, 
    String name, Long salary, Date doe) {
        this.employee = employee;
        this.dept = dept;
        this.name = name;
        this.salary = salary;
        this.doe = doe;
    }
    
    public Long getId() {
        return id;
    }
    
    public EmployeeEntity getEmployee() {
        return employee;
    }
    
    public DepartmentEntity getDept() {
        return dept;
    }
    
    public String getName() {
        return name;
    }
    
    public Long getSalary() {
        return salary;
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

    public void setDept(DepartmentEntity dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public void setDoe(Date doe) {
        this.doe = doe;
    }
    
    @Override
    public String toString() {
        return "Positions [id=" + id 
                + ", employee=" + employee
                + ", dept=" + dept
                + ", name=" + name
                + ", salary=" + salary
                + ", doe=" + doe
                + "]";
    }
}