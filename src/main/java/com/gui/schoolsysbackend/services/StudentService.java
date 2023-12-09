package com.gui.schoolsysbackend.services;

import com.gui.schoolsysbackend.controllers.InvalidGradeException;
import com.gui.schoolsysbackend.controllers.NotFoundException;
import com.gui.schoolsysbackend.model.Grade;
import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void updateStudent(String name, Student student){
        Optional<Student> foundStudent = studentRepository.findStudentByNameIgnoreCase(name);
        foundStudent.ifPresent(value -> {
            if(enumCheck(student)){
                throw new InvalidGradeException();
            }
            value.setName(student.getName());
            value.setUpdatedAt();
            value.setCourses(student.getCourses());
            studentRepository.save(foundStudent.get());
        }
        );

    }

    private static boolean enumCheck(Student student) {
        return student.getCourses().values().stream()
                .noneMatch(grade -> Arrays.stream(Grade.values()).map(Grade::getGradeValue).toList().contains(grade));
    }

    ;

    public Student saveNewStudent(Student student){
        if (enumCheck(student)){
            throw new InvalidGradeException();
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
