package com.geekster.UniversityEventManagment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.UniversityEventManagment.repo.StudentRepo;
import com.geekster.UniversityEventManagment.model.Student;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
    }

    public Iterable<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepo.findById(studentId);
    }
}
