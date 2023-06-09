package com.digital.utils;

import com.github.javafaker.Faker;

public class FakeDataProvider {

    public static Faker faker = new Faker();

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generatePassword() {
        return faker.internet().password(15, 17, true, true, true) + ".";
    }

    public static String generateLogin() {
        return faker.name().username();
    }

    public static String generateSiteName() {
        return faker.company().name();
    }

    public static String generateAnyText() {
        return faker.chuckNorris().fact();
    }

    public static String generateOverriddenLanguage() {
        return faker.nation().language();
    }

    public static String generateCountry() {
        return faker.address().country();
    }

    public static String generateCity() {
        return faker.address().city();
    }


    public static void main(String[] args) {
        System.out.println(generateFirstName());
    }


}
