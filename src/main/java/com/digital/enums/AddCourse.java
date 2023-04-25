package com.digital.enums;

public enum AddCourse {
    SAMPLES("Samples"),
    PRICE("100");

    String value;

    AddCourse (String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
