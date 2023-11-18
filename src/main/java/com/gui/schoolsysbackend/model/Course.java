package com.gui.schoolsysbackend.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Course {
    private UUID uuid;

    private String title;

    private Teacher teacher;

    private Date createdAt;

    private Date updatedAt;

    public Course() {
    }

    public Course(UUID uuid, String title, CourseSituation courseSituation, String grade, Teacher teacher, Date createdAt, Date updatedAt) {
        this.uuid = uuid;
        this.title = title;
        this.teacher = teacher;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Objects.equals(uuid, course.uuid) && Objects.equals(title, course.title) && Objects.equals(teacher, course.teacher) && Objects.equals(createdAt, course.createdAt) && Objects.equals(updatedAt, course.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, title, teacher, createdAt, updatedAt);
    }
}
