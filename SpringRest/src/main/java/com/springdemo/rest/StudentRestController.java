package com.springdemo.rest;

import com.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController{

    private List<Student> studentList;

    @GetMapping("/students")
    public List<Student> getStudentList(){

        return studentList;

    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if ((studentId>=studentList.size()) || (studentId<0))
            throw new StudentNotFoundException("Student Not Found- "+studentId);


        return studentList.get(studentId);
    }

    @PostConstruct
    private List<Student> getStudents() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Alina","Nahidi"));
        studentList.add(new Student("Mario","Rassi"));
        studentList.add(new Student("Mery","Robert"));
        return studentList;
    }


}
