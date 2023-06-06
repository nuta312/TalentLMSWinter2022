package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Demo1 {
    @Test
    public void demoTest1(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/api/users/2");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);

        Response response = requestSpecification.request(Method.GET);
        response.prettyPrint();
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
    //    int num = 0;
    }

    @Test
    public void createNewUserTest(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://gorest.co.in/public/v2/users");
       // requestSpecification.header("token", "Bearer")
    }
}
