package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> studentList = Arrays.asList(new Student("1", "Lokendra"),new Student("2","Aman"));

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getStudentList(){
        return studentList;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("registerNewStudent"+student);

    }

    @DeleteMapping(path="{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("id") Integer studentId){
        System.out.println("deleteStudent "+studentId);
    }

    @PutMapping(path="{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("id") Integer studentId, @RequestBody Student student){
        System.out.println("updateStudent Student id:"+studentId+" updated with:"+student);
    }
}
