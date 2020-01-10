package com.example.restcruddemo.service;

import com.example.restcruddemo.domain.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);
    Student findById(int id);
    List<Student> findAll();
}
