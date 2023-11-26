package com.gui.schoolsysbackend.services;

import com.gui.schoolsysbackend.model.Course;
import com.gui.schoolsysbackend.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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
        Optional<Course> foundCourse = courseRepository.findCourseByTitle(title);
        foundCourse.ifPresent(value->{
            value.setTitle(course.getTitle());
            value.setTeacher(course.getTeacher());
            value.setUpdatedAt(new Date());
            courseRepository.save(value);
        });
        return foundCourse;
    }

    public void deleteCourse(String title){
        if (courseRepository.findCourseByTitle(title).isPresent()){
            courseRepository.delete(courseRepository.findCourseByTitle(title).get());
        }
    }

    public Optional<Course> getCourseByTitle(String title){
        return (courseRepository.findCourseByTitle(title));
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

}
