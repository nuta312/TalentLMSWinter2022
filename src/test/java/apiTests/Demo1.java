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
        requestSpecification.pathParam("id", "3");

        Response response = requestSpecification.request(Method.GET, "/{id}");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());

    //    int num = 0;
    }

    @Test
    public void createNewUserTest(){
        String userPayLoad = "{\n" +
                "        \"name\": \"Vasili Ivanov\",\n" +
                "        \"email\": \"vasya@gmail.com\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    }";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://gorest.co.in");
        requestSpecification.header("Authorization", "Bearer 4e701b3d184664b25356ecfcb67551058a05a4e12011bc6fd30efdfc8618d3a0");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body(userPayLoad);

        Response response = requestSpecification.request("POST", "/public/v2/users");
        response.prettyPrint();
    //    int num = 0;
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
    public void createNewRandomUserTest(){
        String userPayLoad = "{\n" +
                "        \"name\": \"" + name + "\",\n" +
                "        \"email\": \""+ email +  "\",\n" +
                "        \"gender\": \"" +gender +"\",\n" +
                "        \"status\": \"" + randomStatus() +"\"\n" +
                "    }";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://gorest.co.in/public/v2/users");
        requestSpecification.header("Authorization", "Bearer 4e701b3d184664b25356ecfcb67551058a05a4e12011bc6fd30efdfc8618d3a0");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body(userPayLoad);

        Response response = requestSpecification.request(Method.POST);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 201);
        //    int num = 0;
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
        System.out.println(response);
    }



}






