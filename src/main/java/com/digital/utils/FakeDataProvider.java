package com.digital.utils;

import com.github.javafaker.Faker;

public class FakeDataProvider {

  public static Faker faker = new Faker();

    public static String generateFirstName(){
        return faker.name().firstName();
    }
    public static String generateSiteName(){
        return faker.company().name();
    }

    public static void main(String[] args) {
        System.out.println(generateSiteName());
    }


}
