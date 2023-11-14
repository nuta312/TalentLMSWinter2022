package com.digital.utils;

import com.digital.entities.Course;
import com.digital.entities.User;

public class EntitiesManager {
    public static User generateUser(){
        return User.builder()
                .firstName(FakeDataProvider.generateFirstName())
                .lastName(FakeDataProvider.generateLastName())
                .email(FakeDataProvider.generateEmail())
                .login(FakeDataProvider.generateLogin())
                .password(FakeDataProvider.generatePassword())
                .build();
    }

    public static Course generateCourse(){
        return  Course.builder()
                .name(FakeDataProvider.generaCourseName())
                .description(FakeDataProvider.generateDescription())
                .build();
    }

    public static void main(String[] args) {
        System.out.println(JsonUtils.convertJavaObjectToJson(generateUser()));
    }
}
