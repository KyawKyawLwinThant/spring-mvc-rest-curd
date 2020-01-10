package com.example.restcruddemo.service;

import com.example.restcruddemo.domain.Student;
import com.example.restcruddemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.getOne(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
