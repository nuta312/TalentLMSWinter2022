package com.digital.api;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j
@Data
public abstract class ApiRequest {

    private final String SLASH = "/";
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
//                .headers(this.headers)
                .relaxedHTTPSValidation();
    }

    public int getStatusCode() {
        return this.response.getStatusCode();
    }

    public Response get(String endPoint) {
        log.info("Performed GET {}", endPoint);
        this.response = given()
                .spec(this.spec)
                .get(endPoint);
        logResponse();
        return this.response;
    }

    public Response post(String endPoint, String body) {
        log.info("Performed POST {}", endPoint);
        log.info("Body is {}", body);
        this.response = given()
                .spec(this.spec)
                .body(body)
                .post(endPoint);
        logResponse();
        return this.response;
    }

    public Response post(String endPoint, Map<String, String> formParams) {
        log.info("Performed POST {}", endPoint);
        log.info("Form params is {}", formParams);
        this.response = given()
                .spec(this.spec)
                .formParams(formParams)
                .post(endPoint);
        logResponse();
        return this.response;
    }

    public void logResponse() {
        log.warn("Response is: {}", this.response.getBody().asString());
        log.warn("Status code is: {}", this.response.getStatusCode());
    }

    public String generateEndpoint(String... args) {
        StringBuilder result = new StringBuilder();
        for (String arg : args) {
            result.append(arg).append(SLASH);
        }
        return result.substring(0, result.length() - 1);
    }

    public static String formatParameters(HashMap<String, String> parameters) {
        StringBuilder query = new StringBuilder("?");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            query.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        return query.deleteCharAt(query.length() - 1).toString();
    }
}