package com.gui.schoolsysbackend.services;

import com.gui.schoolsysbackend.model.Teacher;
import com.gui.schoolsysbackend.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    TeacherRepository teacherRepository;

    TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public Optional<Teacher> getTeacher(String name){
        return teacherRepository.findTeacherByNameIgnoreCase(name);
    }
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher saveNewTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(String name){
        if(teacherRepository.findTeacherByNameIgnoreCase(name).isPresent()){
            teacherRepository.delete(teacherRepository.findTeacherByNameIgnoreCase(name).get());
        }
    }

    public Optional<Teacher> updateTeacher(String name, Teacher teacher){
        Teacher foundTeacher = teacherRepository.findTeacherByNameIgnoreCase(name).get();
        foundTeacher.setName(teacher.getName());
        foundTeacher.setUpdatedAt();
        teacherRepository.save(foundTeacher);
        return Optional.of(foundTeacher);
    }


}
