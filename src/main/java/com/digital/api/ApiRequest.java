package com.digital.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
@Data
@Slf4j
public abstract class ApiRequest {

    private static final String SLASH = "/";
       protected String baseUrl;
       protected String apiKey;
       protected Headers headers;
       protected RequestSpecification spec;
       protected Response response;

    public ApiRequest(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.spec = given()
                .auth()
                .basic(this.apiKey, "")
                .baseUri(this.baseUrl)
              //  .headers(this.headers)
                .relaxedHTTPSValidation();
    }

    public int getStatusCode(){
        return this.response.getStatusCode();
    }

    public static String formatParameters(HashMap<String, String> parameters) {
        StringBuilder query = new StringBuilder("?");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            query.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        return query.deleteCharAt(query.length() - 1).toString();
    }

    public Response get(String endPoint){
        log.info("Performed GET {}", endPoint);
         this.response = given()
                 .spec(this.spec)
                 .get(endPoint);
         logResponse();
         return this.response;
    }

    public Response get(String endPoint, Map<String, String> pathParam){
        log.info("Performed GET {}", endPoint);
        this.response = given()
                .spec(this.spec)
                .pathParams(pathParam)
                .get(endPoint);
        logResponse();
        return this.response;
    }

    public Response post(String endPoint, String body) {
        log.info("Performed POST {}", endPoint);
        log.info("Body is {}", body);
        this.response = given()
                .contentType(ContentType.URLENC)
                .spec(this.spec)
                .body(body)
                .post(endPoint);
        logResponse();
        return this.response;
    }
    public Response post(String endPoint, Map<String, String> formParams) {
        log.info("Performed POST {}", endPoint);
        log.info("FormParams is {}", formParams);
        this.response = given()
                .contentType(ContentType.URLENC)
                .spec(this.spec)
                .formParams(formParams)
                .post(endPoint);
        logResponse();
        return this.response;
    }
    public void logResponse(){
        log.warn("Response is : {}" , this.response.getBody().asPrettyString());
        log.warn("Status code is : {}" , this.response.getStatusCode());
    }

    public static void main(String[] args) {
        String format = String.format("Response is : %s", "word");
        System.out.println(format);
    }
    public String generateEndPoint(String ...args){
        StringBuilder result = new StringBuilder();
        for (String arg : args){
            result.append(arg).append(SLASH);
        }
        return result.substring(0, result.length()-1);
    }

    public Map<String,String> pathParam(String key, String value){
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>(){{
            put(key, value);
        }};
        return linkedHashMap;
    }
}


























































//package com.digital.api;
//
//import io.restassured.http.Headers;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import lombok.Data;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import static io.restassured.RestAssured.given;
////import static jdk.internal.net.http.common.Log.logResponse;
//@Data
//public abstract class ApiRequest {
//    private static Logger logger = LogManager.getLogger(ApiRequest.class);
//  protected String baseUrl;
//  protected String apiKey;
//  protected Headers headers;
//  protected RequestSpecification spec;
//  protected Response response;
//
//    public ApiRequest(String url, String apiKey) {
//        this.url = url;
//        this.apiKey = apiKey;
//        this.spec = given()
//                .auth()
//                .basic(this.apiKey, "")
//                .baseUri(this.baseUrl)
//                .headers(this.headers)
//                .relaxedHTTPSValidation();
//    }
//
//    public Response get(String endPoint){
//        logger.info("performed GET {}", endPoint);
//         this.response = given()
//                .spec(this.spec)
//                .get(endPoint);
//        logResponse();
//         return this.response;
//    }
//
//    public Response post(String endPoint, String body){
//        logger.info("Performed Post: {}", endPoint);
//        logger.info("Body is: {}",body);
//        this.response = given()
//                .spec(this.spec)
//                .body(body)
//                .post(endPoint);
//        logResponse();
//        return this.response;
//    }
//
//    public void logResponse(){
//        logger.warn("Response is: {}", this.response.getBody().asString());
//        logger.warn("Status code is: {}", this.response.getStatusCode());
//
//    }
//}
