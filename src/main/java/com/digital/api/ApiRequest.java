

public abstract class ApiRequest {

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
