package com.digital.enums;

public enum Courses {
    MACHINE_COURSE("What is Machine Learning?"),
    BUILDING_COURSE("Building Your Career"),
    SECOND_MACHINE("What is Machine Learning? (AIE02)");

    String course;

    Courses(String course){
        this.course = course;
    }

    public String getCourse(){
        return this.course;
    }
}
