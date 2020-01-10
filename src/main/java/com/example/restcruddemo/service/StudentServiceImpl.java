package com.example.restcruddemo.service;

import com.example.restcruddemo.domain.Student;
import com.example.restcruddemo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void removeStudent(int id) {
        this.studentRepository.deleteById(id);
    }

    @Override @Transactional
    public void update(Student student, int existingStudentId) {
        Student oldStudent=studentRepository.getOne(existingStudentId);
        oldStudent.setAge(student.getAge());
        oldStudent.setName(student.getName());
        oldStudent.setSchool(student.getSchool());
    }

    @Override @Transactional
    public void changeSchool(int studentId, String school) {
        Student student=studentRepository.getOne(studentId);
        student.setSchool(school);
    }
}
