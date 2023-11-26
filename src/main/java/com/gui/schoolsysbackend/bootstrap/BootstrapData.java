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
        //studentRepository.deleteAll();
        //HashMap<String, Grade> courses = new HashMap<>();
        //courses.put("Mathematics",
          //      Grade.B);

        //Student student1 = new Student(null,"Luke Skywalker", new Date(), null, courses);

        //studentRepository.save(student1);

        //studentService.saveNewStudent(student1);
        //Student student1 = studentService.getStudent("Luke Skywalker");
        //student1.getCourses().replace("Mathematics", "k");
        //studentService.updateStudent("Luke Skywalker" , student1);

       // Teacher teacher1 = new Teacher(null, "Jose", null, null);

/*        //Course course1 = courseService.saveNewCourse(
               new Course(null, "History", teacher1, new Date(), null)
       );*/

        System.out.println(courseService.getCourseByTitle("History").get());

        Teacher teacher2 = new Teacher(null, "Maria", null, null);
       courseService.getCourseByTitle("History").ifPresent(
                value -> {
                    value.setTeacher(teacher2);
                    courseService.updateCourse("History", value);
                }

        );

        System.out.println(courseService.getCourseByTitle("History").get());

    }
}
