package com.digital.asserts;

import com.digital.entities.Course;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
@Slf4j
public class CourseAssert {
    Course actualCourses;

    public CourseAssert(Course actualCourses) {
        this.actualCourses = actualCourses;
    }

    public CourseAssert isCorrectName(String expectedName) {
        Assert.assertEquals(actualCourses.getName(), expectedName);
        log.info("Name is correct, Expected {}, Actual {}", expectedName, actualCourses.getName());
        return this;
    }

    public CourseAssert isCorrectCode(Integer expectedCode){
        Assert.assertEquals(actualCourses.getCode(), expectedCode);
        log.info("LastName is correct, expected {}, Actual {}", expectedCode, actualCourses.getCode());
        return this;
    }
    public CourseAssert isUserAddedToCourse(String id) {
        Assert.assertEquals(id, actualCourses.getId());
        return this;
    }
}
