package com.gui.schoolsysbackend.bootstrap;

import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.repositories.StudentRepository;
import com.gui.schoolsysbackend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class BootstrapData implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        //studentRepository.deleteAll();

        Student student1 = studentRepository.findStudentByName("carlos");

        //studentRepository.save(student1);

        studentService.updateStudent(student1.getId(), new Student("carlos"));
    }
}
