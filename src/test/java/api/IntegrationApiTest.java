package api;

import com.digital.asserts.ApiAssert;
import com.digital.asserts.CourseAssert;
import com.digital.entities.Course;
import com.digital.entities.User;
import com.digital.utils.EntitiesManager;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

@Slf4j
public class IntegrationApiTest extends BaseApiTest {
    User expectedUser;
    User actualUser;
    Course course;
    Course actualCourse;
    Course expectedCourse;

    @BeforeClass(alwaysRun = true)
    public void checkAndDeleteUsers(){
        User[] allUsers = userController.receiveUsers();
        for (User s : allUsers){
            if(s.getId().equals("1")){
                continue;
            }
            userController.deleteUser(String.valueOf(s.getId()));
        }
    }

//    @Test
//    public void createUsers(){
//        List<String> usersId = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//           User createdUser = userController.createUser(EntitiesManager.generateUser());
//           usersId.add(createdUser.getId());
//        }
//        System.out.println(usersId);
//    }

    @BeforeTest(alwaysRun = true)
    public void generateTest(){
        expectedUser = EntitiesManager.generateUser();
        expectedCourse = EntitiesManager.generateCourse();
    }
    @Test(priority = 1)
    public void createUser(){
        actualUser = userController.createUser(expectedUser);
        ApiAssert.assertThat(userController.getResponse())
                .isCorrectStatusCode(200)
                .assertUser(actualUser)
                .isCorrectName(expectedUser.getFirstName())
                .isCorrectLastName(expectedUser.getLastName());
    }
    @Test(priority = 2)
    public void createCourse(){
        actualCourse = courseController.createCourse(expectedCourse);
        ApiAssert.assertThat(courseController.getResponse())
                .isCorrectStatusCode(200)
                .assertCourse(actualCourse)
                .isCorrectName(expectedCourse.getName())
                .isCorrectCode(expectedCourse.getCode());


    }
    @Test(priority = 3)
    public void addUserToCourse(){
        courseController.addUserToCourse(actualUser.getId(), actualCourse.getId());
        actualCourse = courseController.getCourseById("id", actualCourse.getId());
        System.out.println(actualCourse);
        ApiAssert.assertThat(courseController.getResponse())
                .assertCourse(actualCourse)
                .isUserAddedToCourse(actualCourse.getId());

    }

    @Test(priority = 4)
    public void deleteCourse(){
        courseController.courseDelete(actualCourse.getId());
    }









    @AfterClass
    public void DeleteUsers(){
        User[] allUsers = userController.receiveUsers();
        //  log.info("Checked Users are : {}", Arrays.toString(allUsers));
        if(allUsers.length > 1) {
            for (User s : allUsers){
                if(s.getId().equals("1")){
                    continue;
                }
                userController.deleteUser(s.getId());
            }
        }

    }
}
