package com.gui.schoolsysbackend.services;

import com.gui.schoolsysbackend.model.Course;
import com.gui.schoolsysbackend.model.Student;
import com.gui.schoolsysbackend.model.Teacher;
import com.gui.schoolsysbackend.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {


    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student student0;

    private Student student1;

    @BeforeEach
    public void setup() {

        HashMap<String, String> dummyCourses = new HashMap<>();
        dummyCourses.put("DummyCourse0", "B");
        dummyCourses.put("DummyCourse1", "A");

        HashMap<String, String> dummyInvalidCourses = new HashMap<>();
        dummyInvalidCourses.put("DummyCourse0", "B");
        dummyInvalidCourses.put("DummyCourse1", "X");
        student0 = new Student(null, "student0", null, null, dummyCourses);
        student1 = new Student(null, "student1", null, null, dummyInvalidCourses);
    }

    @Test
    public void saveNewStudentTest(){
        given(studentRepository.save(student0)).willReturn(student0);

        Student savedStudent = studentService.saveNewStudent(student0);
        assertNotNull(savedStudent);
        assertEquals("student0", savedStudent.getName());

    }

    @Test
    public void saveNewStudentInvalidGradeTest(){
        assertThrows(ResponseStatusException.class, () -> studentService.saveNewStudent(student1));
    }
    @Test
    public void updateStudentShouldNotThrowAnyException(){
        given(studentRepository.findStudentByNameIgnoreCase("STUDENT0")).willReturn(Optional.of(student0));
        HashMap<String, String> dummyCourses = new HashMap<>();
        dummyCourses.put("DummyCourse0", "B");
        dummyCourses.put("DummyCourse1", "A");


        Student updatedStudent = new Student(null, "updated", null, null, dummyCourses);
        assertDoesNotThrow(()-> studentService.updateStudent("STUDENT0", updatedStudent));

    }
    @Test
    public void GivenInvalidGradesUpdateStudentShouldThrowResponseStatusException(){
        given(studentRepository.findStudentByNameIgnoreCase("STUDENT0")).willReturn(Optional.of(student0));
        HashMap<String, String> dummyCourses = new HashMap<>();
        dummyCourses.put("DummyCourse0", "B");
        dummyCourses.put("DummyCourse1", "X");

        Student updatedStudent = new Student(null, "updated", null, null, dummyCourses);
        assertThrows(ResponseStatusException.class,()-> studentService.updateStudent("STUDENT0", updatedStudent));
    }



}
