package com.digital.utils;

import com.github.javafaker.Faker;

public class FakerGenerator {

    static Faker faker = new Faker();


    public static String randomFirstName(){ return faker.name().firstName();
    }
    public static String randomLastName(){
        return faker.name().lastName();
    }

    public static String randomEmail(){
        return faker.internet().emailAddress();
    }

    public static String randomUserName(){
        return faker.name().username();
    }

    public static String randomBio(){
        return faker.chuckNorris().fact();
    }

    public static String randomPassword(){
        return faker.internet().password(8,12,true,true,true);
    }

}