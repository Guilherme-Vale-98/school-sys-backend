package com.gui.schoolsysbackend.repositories;

import com.gui.schoolsysbackend.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
