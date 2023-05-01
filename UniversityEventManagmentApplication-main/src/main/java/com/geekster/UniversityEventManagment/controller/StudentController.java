package com.geekster.UniversityEventManagment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geekster.UniversityEventManagment.model.Student;
import com.geekster.UniversityEventManagment.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/addStudent")
    public String addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return "added";
    }

    @DeleteMapping(value = "/deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
    }

    @GetMapping(value = "/getAllStudent")
    public Iterable<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/getStudentById/{studentId}")
    public Optional<Student> getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }



}
