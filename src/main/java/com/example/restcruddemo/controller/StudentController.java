package com.example.restcruddemo.controller;

import com.example.restcruddemo.domain.Student;
import com.example.restcruddemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/creation")
    public String crate(){
        Arrays.asList(new Student("Thaw Thaw",23,"Lahta"),
                new Student("Maw Maw",22,"Yangon"),
                new Student("Khing",23,"Latha"))
                .stream()
                .forEach(studentService::create);
        return "successfully created.";
    }

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> showAllStudents(){
        return studentService.findAll();
    }

    @GetMapping(value="/all/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Student showStudentById(@PathVariable int id){
        return studentService.findById(id);
    }

    @PostMapping(value ="/all",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.create(student);
        return new ResponseEntity<String>("success",HttpStatus.CREATED);
    }




}
