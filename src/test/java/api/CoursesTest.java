package api;

import com.digital.entities.Course;
import com.digital.utils.EntitiesManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CoursesTest extends BaseApiTest{
    Course course;
    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        course = EntitiesManager.generateCourse();
    }
    @Test
    public void createCourses(){
        Course createdCourse = courseController.createCourse(course);
        course.setId(createdCourse.getId());
        courseController.addUserToCourse("24", createdCourse.getId());
        Assert.assertNotNull(createdCourse.getId());
    }
    @Test
    public void addUserCourse(){
        courseController.addUserToCourse("24", "134 ");
    }

    @AfterClass
    public void  afterClass(){
        courseController.courseDelete(course.getId());
    }
}
