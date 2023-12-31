package com.gui.schoolsysbackend.services;

import com.gui.schoolsysbackend.model.Grade;
import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void updateStudent(String name, Student student){
        Optional<Student> foundStudent = studentRepository.findStudentByNameIgnoreCase(name);
        foundStudent.ifPresent(value -> {
            if(!enumCheck(student)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Grade");
            }
            value.setName(student.getName());
            value.setUpdatedAt();
            value.setCourses(student.getCourses());
            studentRepository.save(foundStudent.get());
        }
        );

    }

    private static boolean enumCheck(Student student) {
        return new HashSet<>(Arrays.stream(Grade.values()).map(Grade::getGradeValue).toList()).containsAll(student.getCourses().values());
    }

    ;

    public Student saveNewStudent(Student student){
        if (!enumCheck(student)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Grade");
        }
        return studentRepository.save(student);
    }

    public Student getStudent(String name){
        return  studentRepository.findStudentByNameIgnoreCase(name).orElseThrow(NotFoundException::new);
    }

    public void deleteStudent(String name){
        studentRepository.delete(studentRepository.findStudentByNameIgnoreCase(name).orElseThrow(NotFoundException::new));
    }

    public List<Student> getAllStudents(){
        return  studentRepository.findAll();
    }

}
