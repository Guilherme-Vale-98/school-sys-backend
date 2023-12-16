package com.gui.schoolsysbackend.controllers;

import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.model.Teacher;
import com.gui.schoolsysbackend.services.TeacherService;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = TEACHER_PATH)
    public ResponseEntity handlePost(@RequestBody Teacher teacher){
        Teacher savedTeacher = teacherService.saveNewTeacher(teacher);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", TEACHER_PATH + "/" + savedTeacher.getName());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value = TEACHER_PATH_NAME)
    public ResponseEntity handleDeleteTeacher(@PathVariable("teacherName") String name){
        teacherService.deleteTeacher(name);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = TEACHER_PATH_NAME)
    public ResponseEntity updateTeacher(@PathVariable("teacherName") String name, @RequestBody Teacher teacher){
        teacherService.updateTeacher(name, teacher);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
