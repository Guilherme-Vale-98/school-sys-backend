package com.gui.schoolsysbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.Update;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
@Document(collection = "students")
public class Student {
    @Id
    private String id;

    private String name;


    private Date createdAt;

    private Date updatedAt;

    private HashMap<Course, Grade> courses;

    public Student() {
    }

    public Student(String id, String name, Date createdAt, Date updatedAt, HashMap<Course, Grade> courses) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.courses = courses;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public HashMap<Course, Grade> getCourses() {
        return courses;
    }

    public void setCourses(HashMap<Course, Grade> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(createdAt, student.createdAt) && Objects.equals(updatedAt, student.updatedAt) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, updatedAt, courses);
    }
}
