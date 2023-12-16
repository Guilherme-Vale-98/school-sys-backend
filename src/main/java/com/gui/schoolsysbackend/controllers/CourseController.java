package com.gui.schoolsysbackend.controllers;

import com.gui.schoolsysbackend.model.Course;
import com.gui.schoolsysbackend.services.CourseService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private final String COURSE_PATH = "/v1/courses";

    private final String COURSE_PATH_TITLE = COURSE_PATH + "/{title}";

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping(value = COURSE_PATH)
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses = courseService.getAllCourses();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Info", "Getting all courses");
        httpHeaders.add("Desc", "Retrieve courses from database");
        return new ResponseEntity<>(courses, httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = COURSE_PATH_TITLE)
    public ResponseEntity<Course> getCourseByTitle(@PathVariable("title") String title){
        Course course = courseService.getCourseByTitle(title);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Info", "Getting course by title:" + title);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(course);
    }

    @PutMapping(value = COURSE_PATH_TITLE)
    public ResponseEntity<Course> updateCourseByTitle(@PathVariable("title") String title, @RequestBody Course course){
        courseService.updateCourse(title, course);
        return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = COURSE_PATH)
    public ResponseEntity<Course> saveNewCourse(@RequestBody Course course){
        courseService.saveNewCourse(course);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", COURSE_PATH + "/" + course.getTitle());
        return new ResponseEntity<Course>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value = COURSE_PATH_TITLE)
    public ResponseEntity<Course> deleteCourseByTitle(@PathVariable("title") String title){
        courseService.deleteCourse(title);
        return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
    }


}
