package com.gui.schoolsysbackend.controllers;

import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.services.StudentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    public static final String STUDENT_PATH = "/v1/students";
    public static final String STUDENT_PATH_NAME = STUDENT_PATH + "/{studentName}";

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping(value = STUDENT_PATH)
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    };

    @GetMapping(value = STUDENT_PATH_NAME)
    public Student getStudentById(@PathVariable("studentName") String name ){
        return studentService.getStudent(name);
    }

    @PostMapping(value = STUDENT_PATH)
    public ResponseEntity handlePost(@RequestBody Student student){
        Student savedStudent = studentService.saveNewStudent(
                new Student(null, student.getName(), student.getCourses())
        );

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", STUDENT_PATH + "/" + savedStudent.getName());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value = STUDENT_PATH_NAME)
    public ResponseEntity handleDeleteStudent(@PathVariable("studentName") String name){
        studentService.deleteStudent(name);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = STUDENT_PATH_NAME)
    public ResponseEntity updateStudent(@PathVariable("studentName") String name, @RequestBody Student student){
        studentService.updateStudent(name, student);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
