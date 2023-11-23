package com.gui.schoolsysbackend.repositories;

import com.gui.schoolsysbackend.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentRepository extends MongoRepository<Student, String> {
}
