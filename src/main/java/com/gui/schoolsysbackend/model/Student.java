package com.gui.schoolsysbackend.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public class Student {

    private UUID uuid;

    private String name;

    private Date createdAt;

    private Date updatedAt;

    private HashSet<Course> courses;

    public Student() {
    }

    public Student(UUID uuid, String name, Date createdAt, Date updatedAt, HashSet<Course> courses) {
        this.uuid = uuid;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.courses = courses;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public HashSet<Course> getCourses() {
        return courses;
    }

    public void setCourses(HashSet<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(uuid, student.uuid) && Objects.equals(name, student.name) && Objects.equals(createdAt, student.createdAt) && Objects.equals(updatedAt, student.updatedAt) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, createdAt, updatedAt, courses);
    }
}
