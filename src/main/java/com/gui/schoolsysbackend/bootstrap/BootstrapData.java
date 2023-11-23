package com.gui.schoolsysbackend.bootstrap;

import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class BootstrapData implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        studentRepository.deleteAll();

        Student student1 = new Student(null, "Teste1", new Date(), new Date(), null);

        studentRepository.save(student1);
    }
}
