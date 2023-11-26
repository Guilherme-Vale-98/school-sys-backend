package com.gui.schoolsysbackend.bootstrap;

import com.gui.schoolsysbackend.model.Course;
import com.gui.schoolsysbackend.model.Grade;
import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.model.Teacher;
import com.gui.schoolsysbackend.repositories.StudentRepository;
import com.gui.schoolsysbackend.services.CourseService;
import com.gui.schoolsysbackend.services.StudentService;
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

    @Override
    public void run(String... args) throws Exception {
        Teacher t2 = new Teacher(null, "Ben Kenobi", new Date(), null);
        Course cos = new Course(null, "Physics", t2, new Date(), null );

        courseService.updateCourse("Physics", cos);

    }
}
