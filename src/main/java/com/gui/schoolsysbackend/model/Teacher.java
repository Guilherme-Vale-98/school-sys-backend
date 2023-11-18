package com.gui.schoolsysbackend.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Teacher {

    private UUID uuid;

    private String name;

    private Date createdAt;

    private Date updatedAt;


    public Teacher() {
    }

    public Teacher(UUID uuid, String name, Date createdAt, Date updatedAt) {
        this.uuid = uuid;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher teacher)) return false;
        return Objects.equals(uuid, teacher.uuid) && Objects.equals(name, teacher.name) && Objects.equals(createdAt, teacher.createdAt) && Objects.equals(updatedAt, teacher.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, createdAt, updatedAt);
    }
}
