package com.workstation.service;

import com.workstation.entity.DocumentEntity;
import com.workstation.entity.EmployeeEntity;
import com.workstation.repository.DocumentRepository;
import com.workstation.repository.EmployeeRepository;
import com.workstation.repository.UserRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentsService {
    
    //директория хранения файлов
    public final String DOCUMENTS = "documents";
    
    private final DocumentRepository documentRepository;
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    
    public DocumentsService(DocumentRepository documentRepository, 
    EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.documentRepository = documentRepository;
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }
    
    public List<DocumentEntity> getDocuments() {
        return documentRepository.findAll();
    }
    
    //получить значения таблицы разделенное на страницы
    public Page<DocumentEntity> getDocuments(Pageable pageable) {
        return documentRepository.findAll(pageable);
    }
    
    //удалить документ
    public void deleteDocument(Long id) {
        
        DocumentEntity document = documentRepository.findById(id).get();
        
        File file = new File(DOCUMENTS, document.getFile());
        file.delete();
        
        documentRepository.deleteById(id);
    }
    
    //скачать документ
    public ResponseEntity<InputStreamResource> downloadDocument(Long id) 
    throws IOException {
        
        DocumentEntity document = documentRepository.findById(id).get();
        
        File file = new File(DOCUMENTS, document.getFile());
        
        ContentDisposition contentDisposition = ContentDisposition
            .builder("attachment")
            .filename(document.getName(), StandardCharsets.UTF_8)
            .build();
        
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, 
            contentDisposition.toString())
            .contentType(MediaType.MULTIPART_FORM_DATA)
            .contentLength(file.length())
            .body(new InputStreamResource(new FileInputStream(file)));
    }
    
    //загрузить документ
    public void uploadDocument(MultipartFile document) throws IOException {
        
        //получить логин текущего пользователя
        String user = SecurityContextHolder.getContext().getAuthentication()
        .getName();
        
        //создание папки для хранения файлов
        File folder = new File(DOCUMENTS);
        
        if (! folder.exists()) {
            folder.mkdir();
        }
        
        if (! document.isEmpty()) {
            
            //генерация уникального имени файла (переделать)
            String file = generateString();
            while (new File(folder, file).exists()) {
                file = generateString();
            }
            
            //получить данные сотрудника загрузившего документ
            EmployeeEntity employee = userRepository.findByUsername(user)
            .getEmployee();
            
            DocumentEntity documentEntity = new DocumentEntity();
            documentEntity.setName(document.getOriginalFilename());
            documentEntity.setDsize(document.getSize());
            documentEntity.setEmployee(employee);
            documentEntity.setFile(file);
            //дата выставляется hibernate
            
            documentRepository.save(documentEntity);
                
            //сохраняем файл (getAbsoluteFile - без него ошибка нахождения пути 
            //- проверить)
            document.transferTo(new File(folder, file).toPath());
        }
    }
    
    //генерация уникальной строки (переделать)
    private String generateString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}