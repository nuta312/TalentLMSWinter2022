package com.digital.ui;

import com.digital.utils.FakerGenerator;
import com.github.javafaker.Faker;

public enum users {
    NAME(FakerGenerator.randomFirstName()),
    SURNAME(FakerGenerator.randomLastName()),
    EMAIL(FakerGenerator.randomEmail()),
    PASSWORD(FakerGenerator.randomPassword()),
    BIO("some info about someone"),
    LEARNERTYPE("Trainer-Type"),//"Admin-Type"||"Trainer-Type"||"Learner-Type"
    TIMEZONE("92"),//by value
    LANGUAGE("ru"),
    CHECKBOXSTATUS("Active"),
    CHECKBOXDEACTIVE("deactivate_user")
    ;
    String userInfo;
    users(String userInfo){
        this.userInfo=userInfo;
    }
    public String getUserInfo(){
        return userInfo;
    }
}
