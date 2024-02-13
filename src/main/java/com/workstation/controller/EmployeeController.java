package com.workstation.controller;

import com.workstation.entity.*;
import com.workstation.form.EmployeeForm;
import com.workstation.service.EmployeeService;

import java.util.ArrayList;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    
    private final EmployeeService employeeService;
    
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    //кнопка сохрания/создания данных/нет сотрудника
    @RequestMapping(value = "/main/employee", method = RequestMethod.POST, 
    params = "insert")
    public String insert(@ModelAttribute EmployeeForm employeeForm, Model model) {
        
        employeeService.insertEmployee(employeeForm);
        
        return main(employeeForm.getEmployee().getId(), model);
    }
    
    //вывод данных сотрудника по ид
    @RequestMapping(value = "/main/employee", method = RequestMethod.GET, 
    params = "id")
    public String main(@RequestParam Long id, Model model) {
        model.addAttribute("departments", employeeService
        .getDepartments());
        
        model.addAttribute("employee", employeeService
        .getEmployee(id));
        model.addAttribute("passport", employeeService
        .getPassport(id));
        model.addAttribute("personal", employeeService
        .getPersonal(id));
        
        //если нет то возвращает пустые list-ы
        model.addAttribute("hirings", employeeService
        .getHirings(id));
        model.addAttribute("dismissals", employeeService
        .getDismissals(id));
        model.addAttribute("positions", employeeService
        .getPositions(id));
        model.addAttribute("physicals", employeeService
        .getPhysicals(id));
        model.addAttribute("sicks", employeeService
        .getSicks(id));
        model.addAttribute("assignments", employeeService
        .getAssignments(id));
        model.addAttribute("trainings", employeeService
        .getTrainings(id));
        model.addAttribute("benefits", employeeService
        .getBenefits(id));
        model.addAttribute("vacations", employeeService
        .getVacations(id));
        model.addAttribute("encouragements", employeeService
        .getEncouragements(id));
        
        return "employee";
    }
    
    //создание записи о сотруднике
    @RequestMapping(value = "/main/employee", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("departments", employeeService
        .getDepartments());
        
        model.addAttribute("employee", new EmployeeEntity());
        model.addAttribute("passport", new PassportEntity());
        model.addAttribute("personal", new PersonalEntity());
        
        model.addAttribute("hirings", new ArrayList<HiringEntity>());
        model.addAttribute("dismissals", new ArrayList<DismissalEntity>());
        model.addAttribute("positions", new ArrayList<PositionEntity>());
        model.addAttribute("physicals", new ArrayList<PhysicalEntity>());
        model.addAttribute("sicks", new ArrayList<SickEntity>());
        model.addAttribute("assignments", new ArrayList<AssignmentEntity>());
        model.addAttribute("trainings", new ArrayList<TrainingEntity>());
        model.addAttribute("benefits", new ArrayList<BenefitEntity>());
        model.addAttribute("vacations", new ArrayList<VacationEntity>());
        model.addAttribute("encouragements", 
        new ArrayList<EncouragementEntity>());
        
        return "employee";
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