package com.example.restcruddemo.service;

import com.example.restcruddemo.domain.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);
    Student findById(int id);
    List<Student> findAll();
    void removeStudent(int id);
    void update(Student student,int existingStudentId);
    void changeSchool(int studentId,String school);



}
