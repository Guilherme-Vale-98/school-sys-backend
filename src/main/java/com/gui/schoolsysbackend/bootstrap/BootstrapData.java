package com.gui.schoolsysbackend.bootstrap;

import com.gui.schoolsysbackend.model.Course;
import com.gui.schoolsysbackend.model.Grade;
import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.model.Teacher;
import com.gui.schoolsysbackend.repositories.StudentRepository;
import com.gui.schoolsysbackend.services.CourseService;
import com.gui.schoolsysbackend.services.StudentService;
import com.gui.schoolsysbackend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class BootstrapData implements CommandLineRunner {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;

    @Override
    public void run(String... args) throws Exception {
/*
        Teacher teacher = new Teacher(null, "Yoda");
        teacher.setName("Yoda from Dagobah");
        teacherService.updateTeacher("yoda", teacher);

        System.out.println(teacherService.getAllTeachers().get(0));*/

    }
}
