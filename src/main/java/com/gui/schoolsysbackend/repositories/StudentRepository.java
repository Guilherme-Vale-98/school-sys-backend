package com.gui.schoolsysbackend.repositories;

import com.gui.schoolsysbackend.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByNameIgnoreCase(String name);
}
