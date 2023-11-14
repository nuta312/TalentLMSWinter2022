package com.digital.api.controllers;

import com.digital.api.ApiRequest;
import com.digital.entities.User;
import com.digital.entities.UserSignUp;
import com.digital.utils.EntitiesManager;
import com.digital.utils.JsonUtils;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.digital.api.TalentLmsBasicEndPoints.*;
import static org.testng.AssertJUnit.assertEquals;

public class UserController extends ApiRequest {
    private static final String USER_ID = "/?id=3";
    public UserController(String baseUrl, String apiKey) {
        super(baseUrl, apiKey);
    }

    public User[] receiveUsers(){
       return super.get(generateEndPoint(API, V1, USERS)).as(User[].class);
    }


    public User receiveSingleUser1(String by, String idOrEmail){
     return get(generateEndPoint(API, V1, USERS), pathParam(by, idOrEmail)).as(User.class);
    } // ne rabochiy

    public User receiveSingleUser(String by, String idOrEmail){
        HashMap<String, String> map = new HashMap<>(){{
            put(by, idOrEmail);
        }};
       return get(generateEndPoint(API, V1, USERS, formatParameters(map))).as(User.class);
    }

    public User createUser(User user){
        String userJson = JsonUtils.convertJavaObjectToJson(user);
        return super.post(generateEndPoint(API, V1, SIGNUP), userJson).as(User.class);
    }

    public Response userDelete(String id){
        return super.post(generateEndPoint(API, V1, DELETE_USER), "user_id=" + id);
    }

    public Response deleteUser(String userId){
        Map<String, String> formParams = new HashMap<>(){{
            put("user_id",String.valueOf(userId));
            put("deleted_by_user_id", "1");
        }};
        return post(generateEndPoint(API, V1, DELETE_USER), formParams);
    }

    public User receiveUserByEmail(String email){
        return super.get(generateEndPoint(API, V1, USERS + email)).as(User.class);
    }

    public User receiveUserById(String userId){
        return super.get(generateEndPoint(API, V1, USERS + userId)).as(User.class);
    }

    public User receiveUserByName(String userName){
        return super.get(generateEndPoint(API, V1, USERS + userName)).as(User.class);
    }

    public User isUserOnline(String param) {
        return super.get(generateEndPoint(API, V1 + param)).as(User.class);
    }



//    public static void main(String[] args) {
//        UserController userController = new UserController("https://kubabeck.talentlms.com","hbxbx4nzcMDNwFjAlbV23KNQq6P5wf");
//        User[] users = userController.receiveUsers();
//        Arrays.stream(users).forEach(s -> System.out.println(s.getFirstName()));
//        assertEquals(200, userController.getStatusCode());
//    }


    public static void main(String[] args) {
        UserController userController = new UserController("https://kubabeck.talentlms.com","hbxbx4nzcMDNwFjAlbV23KNQq6P5wf");
      //  userController.deleteUser("20");
     //
        //
        //   User user = userController.receiveUserById(USER_ID);
       // User user = userController.receiveUserByEmail("/?email=johnny@gmail.com");
     //   User user = userController.receiveUserByName("/?username=Kubanych");
     //   User user = userController.isUserOnline("/isuseronline/?user_id=1");
        User user = userController.receiveSingleUser("email", "ktashbaev1989@gmail.com");

//        User user = EntitiesManager.generateUser();
//        userController.createUser(user);
//        System.out.println(user.getLastName());
//        assertEquals(200, userController.getStatusCode());
    }
}













