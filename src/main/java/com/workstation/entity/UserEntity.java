package com.workstation.entity;

import javax.persistence.*;

//список пользователей имеющих доступ к системе

@Entity
@Table(name = "users")
public class UserEntity {
    
    //номер записи 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //данные сотрудника
    @OneToOne
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;
    
    //логин сотрудника
    @Column(name = "username", columnDefinition = "text", nullable = false, unique = true)
    private String username;
    
    //пароль сотрудника
    @Column(name = "password", columnDefinition = "text", nullable = false)
    private String password;
    
    //возможность входа
    @Column(name = "enabled", columnDefinition = "boolean", nullable = false)
    private Boolean enabled;
    
    /*доступ сотрудника
    limited - ограниченный
    full - полный*/
    @Column(name = "authority", columnDefinition = "text", nullable = false)
    private String authority;
    
    public UserEntity() {
        
    }
    
    public UserEntity(EmployeeEntity employee, String username, 
    String password, String authority, Boolean enabled) {
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.enabled = enabled;
    }
    
    public Long getId() {
        return id;
    }
    
    public EmployeeEntity getEmployee() {
        return employee;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getAuthority() {
        return authority;
    }

    public Boolean getEnabled() {
        return enabled;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    @Override
    public String toString() {
        return "users [id=" + id 
                + ", employee=" + employee 
                + ", username=" + username 
                + ", password=" + password 
                + ", authority=" + authority
                + ", enabled=" + enabled
                + "]";
    }
}