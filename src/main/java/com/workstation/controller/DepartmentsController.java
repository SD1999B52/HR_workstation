package com.workstation.controller;

import com.workstation.entity.DepartmentEntity;
import com.workstation.service.DepartmentsService;
import com.workstation.tool.PaginationTool;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepartmentsController {
    
    public static final int SIZE = 20;//количество строк на страницу
    
    private final DepartmentsService departmentsService;
    
    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }
    
    //создание записи
    @RequestMapping(value = "/main/departments", method = RequestMethod.POST, 
    params = "insert")
    public String insert(@PageableDefault(size = SIZE) Pageable pageable, 
    @ModelAttribute("department") DepartmentEntity departmentEntity, Model model) {
        
        departmentsService.insertDepartment(departmentEntity);
        
        return main(pageable, model);
    }
    
    //удаление записи
    @RequestMapping(value = "/main/departments", method = RequestMethod.POST, 
    params = "delete")
    public String delete(@PageableDefault(size = SIZE) Pageable pageable, 
    @RequestParam Long delete, Model model) {
        
        departmentsService.deleteDepartment(delete);
        
        return main(pageable, model);
    }
    
    @RequestMapping(value = "/main/departments", method = RequestMethod.GET)
    public String main(@PageableDefault(page = 0, size = SIZE, 
    direction = Direction.ASC, sort = "id") Pageable pageable, Model model) {
        
        Page<DepartmentEntity> page = departmentsService.getDepartments(pageable);
        
        PaginationTool.addToModel(page, model);
        
        model.addAttribute("departments", page);
        model.addAttribute("department", new DepartmentEntity());
        
        return "departments";
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