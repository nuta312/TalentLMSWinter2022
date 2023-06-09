package com.digital.api.controllers;

import com.digital.api.ApiRequest;
import com.digital.api.TalentLmsBaseEndpoints;
import com.digital.entities.User;
import com.digital.utils.EntitiesManager;
import com.digital.utils.JsonUtils;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.digital.api.TalentLmsBaseEndpoints.*;
import static org.testng.AssertJUnit.assertEquals;

public class UserController extends ApiRequest {
    public UserController(String baseUrl, String apiKey) {
        super(baseUrl, apiKey);
    }

    public User[] receiveUsers() {
        return super.get(generateEndpoint(API, V1, USERS)).as(User[].class);
    }

    public User receiveUser(String by, String key) {
        HashMap<String, String> map = new HashMap<>() {{
            put(by, key);
        }};
        return super.get(generateEndpoint(API, V1, USERS, formatParameters(map))).as(User.class);
    }

    public User createUser(User user) {
        String userJson = JsonUtils.convertJavaObjectToJson(user);
        return super.post(generateEndpoint(API, V1, SIGNUP), userJson).as(User.class);
    }

    public Response deleteUser(String userId) {
        Map<String, String> formParams = new HashMap<>() {{
            put("user_id", String.valueOf(userId));
            put("deleted_by_user_id", "1");
        }};

        return super.post(generateEndpoint(API, V1, DELETE_USER), formParams);
    }

    public static void main(String[] args) {
        UserController userController = new UserController("https://aisana.talentlms.com", "trBblAXp821n7gWF77KX7KEqlUaCa5");
//        User user = EntitiesManager.generateUser();
//        userController.createUser(user);
        userController.deleteUser("20");

//        User[] users = userController.receiveUsers();
//        Arrays.stream(users).forEach(user
//                -> System.out.println(user.getLastName()));
//        assertEquals(200, userController.getStatusCode());
//        userController.receiveUser("id", "2");

    }
}
