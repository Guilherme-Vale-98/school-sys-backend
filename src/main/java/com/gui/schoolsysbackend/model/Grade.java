package com.gui.schoolsysbackend.model;

import java.util.Arrays;
import java.util.List;

public enum Grade {
    A_PLUS("A+"),
    A("A"),
    A_MINUS("A-"),
    B_PLUS("B+"),
    B("B"),
    B_MINUS("B-"),
    C_PLUS("C+"),
    C("C"),
    C_MINUS("C-"),
    D_PLUS("D+"),
    D("D"),
    D_MINUS("D-"),
    F("F");

    private final String gradeValue;

    Grade(String gradeValue) {
        this.gradeValue = gradeValue;
    }

    public String getGradeValue() {
        return gradeValue;
    }
}