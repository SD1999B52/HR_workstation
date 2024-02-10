package com.workstation.controller;

import com.workstation.entity.UserEntity;
import com.workstation.service.UsersService;
import com.workstation.tool.PaginationTool;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {
    
    public final int SIZE = 20;//количество строк на страницу
    
    private final UsersService usersService;
    
    private final PasswordEncoder passwordEncoder;
    
    public UsersController(UsersService usersService,  
    PasswordEncoder passwordEncoder) {
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }
    
    //создание записи
    @RequestMapping(value = "/main/users", method = RequestMethod.POST, 
    params = "insert")
    public String insert(@PageableDefault(size = SIZE) Pageable pageable, 
    @ModelAttribute("user") UserEntity userEntity, Model model) {
        
        //шифруем пароль (переделать)
        userEntity.setPassword(passwordEncoder.encode(userEntity
        .getPassword()));
        
        usersService.insertUser(userEntity);
        
        return main(pageable, model);
    }
    
    //удаление записи
    @RequestMapping(value = "/main/users", method = RequestMethod.POST, 
    params = "delete")
    public String delete(@PageableDefault(size = SIZE) Pageable pageable, 
    @RequestParam Long delete, Model model) {
        
        usersService.deleteUser(delete);
        
        return main(pageable, model);
    }
    
    @RequestMapping(value = "/main/users", method = RequestMethod.GET)
    public String main(@PageableDefault(page = 0, size = SIZE, 
    direction = Direction.ASC, sort = "id") Pageable pageable, Model model) {
        
        Page<UserEntity> page = usersService.getUsers(pageable);
        
        PaginationTool.addToModel(page, model);
        
        model.addAttribute("employees", usersService
        .getEmployees());
        model.addAttribute("users", page);
        model.addAttribute("user", new UserEntity());
        
        return "users";
    }
    
    //возврат текста исключений
    @ExceptionHandler()
    public ResponseEntity<String> handle(ConstraintViolationException e) {
        return new ResponseEntity<>(e.getSQLException().getMessage(), 
  HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler()
    public ResponseEntity<String> handle(DataException e) {
        return new ResponseEntity<>(e.getSQLException().getMessage(), 
  HttpStatus.BAD_REQUEST);
    }
}