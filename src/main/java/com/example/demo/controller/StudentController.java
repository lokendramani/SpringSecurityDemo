package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/apps/v1")
public class StudentController {

    List<Student> studentList = Arrays.asList(new Student("1", "Lokendra"),new Student("2","Aman"));

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") String studentId){
        return studentList.stream().filter(student -> student.getId().equals(studentId)).findFirst()
                .orElseThrow(() ->new IllegalArgumentException("Student with id:"+studentId +" not found"));
    }
}
