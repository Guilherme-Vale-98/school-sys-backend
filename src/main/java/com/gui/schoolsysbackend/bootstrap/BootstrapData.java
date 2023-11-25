package com.gui.schoolsysbackend.bootstrap;

import com.gui.schoolsysbackend.model.Course;
import com.gui.schoolsysbackend.model.Grade;
import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.repositories.StudentRepository;
import com.gui.schoolsysbackend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.HashMap;

@Configuration
public class BootstrapData implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        studentRepository.deleteAll();
        HashMap<String, Grade> courses = new HashMap<>();
        courses.put("Mathematics",
                Grade.B);

        Student student1 = new Student(null,"Luke Skywalker", new Date(), null, courses);

        //studentRepository.save(student1);

        studentService.saveNewStudent(student1);
    }
}
