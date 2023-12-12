package com.gui.schoolsysbackend.controllers;

import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.model.Teacher;
import com.gui.schoolsysbackend.services.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    public static final String TEACHER_PATH = "/v1/teachers";
    public static final String TEACHER_PATH_NAME = TEACHER_PATH + "/{teacherName}";

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping(value = TEACHER_PATH)
    public List<Teacher> getTeachers(){
        return teacherService.getAllTeachers();
    };

    @GetMapping(value = TEACHER_PATH_NAME)
    public Teacher getTeacherByName(@PathVariable("teacherName") String name ){
        return teacherService.getTeacher(name);
    }

}
