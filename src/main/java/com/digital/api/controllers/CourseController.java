package com.digital.api.controllers;

import com.digital.api.ApiRequest;
import com.digital.entities.Course;
import com.digital.utils.EntitiesManager;
import com.digital.utils.JsonUtils;
import io.restassured.response.Response;

import java.util.HashMap;

import static com.digital.api.TalentLmsBasicEndPoints.*;

public class CourseController extends ApiRequest {
    public CourseController(String baseUrl, String apiKey) {
        super(baseUrl, apiKey);
    }
    public Course[] getCourses(){
        return super.get(generateEndPoint(API, V1, COURSES)).as(Course[].class);
    }
    public Course getCourseById(String by, String courseId){
        HashMap<String, String> map = new HashMap<>(){{
            put(by, courseId);
        }};
        return super.get(generateEndPoint(API, V1, COURSES, formatParameters(map))).as(Course.class);
    }
    public Course createCourse(Course course){
        String courseBody = JsonUtils.convertJavaObjectToJson(course);
        return super.post(generateEndPoint(API, V1, CREATE_COURSE), courseBody).as(Course.class);
    }

    public Response courseDelete(String id){
        return super.post(generateEndPoint(API, V1, DELETE_COURSE), "course_id=" + id);
    }

    public Response addUserToCourse(String userId, String courseId){
        Course course = Course.builder().userid(userId).courseId(courseId).build();
        String addUserToCourseBody = JsonUtils.convertJavaObjectToJson(course);
        return super.post(generateEndPoint(API, V1, ADD_USER_TO_COURSE) ,addUserToCourseBody);
    }


    public static void main(String[] args) {
        CourseController courseController = new CourseController("https://kubabeck.talentlms.com","hbxbx4nzcMDNwFjAlbV23KNQq6P5wf");
       // Courses[] courses = courseController.getCourses();
       // courseController.getCourseById("id", "130");
      //  courseController.createCourse(EntitiesManager.generateCourse());
        courseController.addUserToCourse("3", "131");

    }
}
