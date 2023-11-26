package com.gui.schoolsysbackend.services;

import com.gui.schoolsysbackend.model.Course;
import com.gui.schoolsysbackend.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    CourseRepository courseRepository;

    @Autowired
    CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    public Course saveNewCourse(Course course){
        return courseRepository.save(course);
    }

    public Optional<Course> updateCourse(String title, Course course){
        return courseRepository.findCourseByTitle(title);
    }

}
