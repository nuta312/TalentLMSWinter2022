package apiTests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Demo1 {
    @Test
    public void demoTest1(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/api/users");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);

        Response response = requestSpecification.request(Method.GET);
        response.prettyPrint();
    }

//    @Test
//    public void createNewUserTest() {
//        String userPayload = "    {\n" +
//                "        \"name\": \"Jim Beam\",\n" +
//                "        \"email\": \"jack3329@gmail.com\",\n" +
//                "        \"gender\": \"male\",\n" +
//                "        \"status\": \"active\"\n" +
//                "    }";
//
//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://gorest.co.in/public/v2/users");
//        requestSpecification.header("Authorization", "Bearer 9bb228962a5436bc9ac217ad3511d60faa102226c6a7b8f46b24690095d0f249");
//        requestSpecification.contentType(ContentType.JSON);
//        requestSpecification.accept(ContentType.JSON);
//        requestSpecification.body(userPayload);
//        Response response = requestSpecification.request("POST");
//        response.prettyPrint();
//        Assert.assertEquals(response.getStatusCode(), 422);
//    }
    public static Faker faker = new Faker();
    public String randomStatus(){
        String [] genders = {"active","inactive"};
        int randomIndex = (int) (Math.random() * genders.length);
        return genders[randomIndex];
    }


    @Test
    public void createNewUserTest() {

        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String gender = faker.demographic().sex();

        String userPayload = "    {\n" +
                "        \"name\": \"" + name + "\",\n" +
                "        \"email\": \"" + email + "\",\n" +
                "        \"gender\": \""+ gender + "\",\n" +
                "        \"status\": \"" + randomStatus() +"\"\n" +
                "    }";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://gorest.co.in");
        requestSpecification.header("Authorization", "Bearer 709021d5a7d6c6c17f7ade19c688d5d3cbf4f7581083689bee7b163f5cdad47c");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body(userPayload);

        Response response = requestSpecification.request("POST", "/public/v2/users");
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 201);


    }
}
