package com.digital.enums;

public enum AddCourse {
    SAMPLES("Samples"),
    TITLE("Home / Courses / Add course"),
    COURSES_TITLE("Home / Courses"),
    ERROR_INLINE("'Course name' is required"),
    REPORTS_RESULT("Home / Reports / Course reports / "),
    EDIT_RESULT("Home / Courses / "),
    CLONE_TITLE("Clone"),
    DELETE_TITLE("Delete Course?"),
    HOME_RESULT("Home / Courses");

    String value;

    AddCourse (String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
