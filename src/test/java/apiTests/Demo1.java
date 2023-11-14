package apiTests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.requestSpecification;


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



    public static Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String gender = faker.demographic().sex();

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



    @Test
    public void jsonPathTest(){

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/api/users");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
     //   requestSpecification.pathParam("id", "3");

        Response response = requestSpecification.request(Method.GET);

        JsonPath jsonPath = response.jsonPath();
        int totalUsers = jsonPath.getInt("total");
        System.out.println(totalUsers);
    }

    @Test
    public void getEmmaTest(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/api/users?page=1");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
     //   requestSpecification.pathParam("first_name", "Emma");
        //   requestSpecification.pathParam("id", "3");

        Response response = requestSpecification.request(Method.GET);

        JsonPath jsonPath = response.jsonPath();
        String nameEmma = jsonPath.getString("data[2].first_name");
        System.out.println(nameEmma);
    }



}






