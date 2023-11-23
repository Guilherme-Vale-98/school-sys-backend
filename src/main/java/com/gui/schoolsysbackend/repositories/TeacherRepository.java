package com.gui.schoolsysbackend.repositories;

import com.gui.schoolsysbackend.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
}
