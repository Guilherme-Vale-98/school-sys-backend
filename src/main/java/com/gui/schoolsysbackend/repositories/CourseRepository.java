package com.gui.schoolsysbackend.repositories;

import com.gui.schoolsysbackend.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CourseRepository extends MongoRepository<Course, String> {
    Optional<Course> findCourseByTitleIgnoreCase(String title);
}
