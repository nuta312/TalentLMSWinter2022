package com.digital.enums;

public enum Cars {

    AUDI("Audi"),
    VOLVO("VOLVO");

    String car;

    Cars (String car){
        this.car = car;
    }

    public String getCar(){
        return this.car;
    }
}
