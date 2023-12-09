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
        Course foundCourse = courseRepository.findCourseByTitleIgnoreCase(title).get();
           foundCourse.setTitle(course.getTitle());
            foundCourse.setTeacher(course.getTeacher());
            foundCourse.setUpdatedAt(new Date());
            courseRepository.save(foundCourse);
        return Optional.of(foundCourse);
    }

    public void deleteCourse(String title){
        if (courseRepository.findCourseByTitleIgnoreCase(title).isPresent()){
            courseRepository.delete(courseRepository.findCourseByTitleIgnoreCase(title).get());
        }
    }

    public Optional<Course> getCourseByTitle(String title){
        return (courseRepository.findCourseByTitleIgnoreCase(title));
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

}
