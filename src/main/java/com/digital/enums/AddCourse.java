package com.digital.enums;

public enum AddCourse {
    SAMPLES("Samples"),
    TITLE("Home / Courses / Add course"),
    COURSES_TITLE("Home / Courses"),
    ERROR_INLINE("'Course name' is required");

    String value;

    AddCourse (String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
