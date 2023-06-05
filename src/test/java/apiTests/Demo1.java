package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Demo1 {

    @Test
    public void demoTest1() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/api/users");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.pathParam("id", "4");
//        requestSpecification.get("/users{id}");

        Response response = requestSpecification.request(Method.GET, "/{id}");

        response.prettyPrint();
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());


    }

    @Test
    public void createNewUserTest() {
        String userPayload = "    {\n" +
                "        \"name\": \"Jim Beam\",\n" +
                "        \"email\": \"jack332212132@gmail.com\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    }";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://gorest.co.in");
        requestSpecification.header("Authorization", "Bearer 9bb228962a5436bc9ac217ad3511d60faa102226c6a7b8f46b24690095d0f249");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body(userPayload);

        Response response = requestSpecification.request("POST", "/public/v2/users");
        response.prettyPrint();

    }

    @Test
    public void jsonPathTest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/api/users");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);

        Response response = requestSpecification.request(Method.GET);

        JsonPath jsonPath = response.jsonPath();
        int totalUsers = jsonPath.getInt("total");
        System.out.println(totalUsers);

        String emma = jsonPath.getString("data[2].first_name");
        System.out.println(emma);

    }
}
