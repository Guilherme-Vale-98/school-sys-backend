package com.gui.schoolsysbackend.repositories;

import com.gui.schoolsysbackend.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
    Optional<Teacher> findTeacherByNameIgnoreCase(String name);
}
