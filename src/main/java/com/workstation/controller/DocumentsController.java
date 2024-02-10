package com.workstation.controller;

import com.workstation.entity.DocumentEntity;
import com.workstation.service.DocumentsService;
import com.workstation.tool.PaginationTool;

import java.io.IOException;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DocumentsController {
    
    public final int SIZE = 20;//количество строк на страницу
    
    private final DocumentsService documentsService;
    
    public DocumentsController(DocumentsService documentsService) {
        this.documentsService = documentsService;
    }
    
    //удаление файла
    @RequestMapping(value = "/main/documents", method = RequestMethod.POST, 
    params = "delete")
    public String delete(@PageableDefault(size = SIZE) Pageable pageable, 
    @RequestParam Long delete, Model model) throws IOException {
        
        documentsService.deleteDocument(delete);
        
        return main(pageable, model);
    }
    
    //загрузка файла
    @RequestMapping(value = "/main/documents", method = RequestMethod.POST, 
    params = "upload")
    public String upload(@PageableDefault(size = SIZE) Pageable pageable, 
    @RequestParam("document") MultipartFile document, Model model) 
    throws IOException {
        
        documentsService.uploadDocument(document);
        
        return main(pageable, model);
    }
    
    //скачивание файла
    @RequestMapping(value = "/main/documents", method = RequestMethod.GET, 
    params = "id")
    public ResponseEntity<InputStreamResource> download(@RequestParam Long id, 
    Model model) throws IOException {
        return documentsService.downloadDocument(id);
    }
    
    @RequestMapping(value = "/main/documents", method = RequestMethod.GET)
    public String main(@PageableDefault(page = 0, size = SIZE, 
    direction = Sort.Direction.ASC, sort = "id") Pageable pageable, Model model) {
        
        Page<DocumentEntity> page = documentsService.getDocuments(pageable);
        
        PaginationTool.addToModel(page, model);
        
        model.addAttribute("documents", page);
        
        return "documents";
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
    
    @ExceptionHandler()
    public ResponseEntity<String> handle(IOException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus
        .BAD_REQUEST);
    }
}