package com.gui.schoolsysbackend.services;

import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void updateStudent(String id, Student student){
        Optional<Student> foundStudent = studentRepository.findById(id);
        foundStudent.ifPresent(value -> {
            value.setName(student.getName());
            value.setUpdatedAt(new Date());
            value.setCourses(student.getCourses());
            studentRepository.save(foundStudent.get());
        }
        );

    };

    public Student saveNewStudent(Student student){
        return studentRepository.save(student);
    }



}
