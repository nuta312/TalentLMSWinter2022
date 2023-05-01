package ui.smoke;

import com.digital.ui.driver.Driver;
import com.digital.ui.pages.AzizasTask;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class AzizasTest {
    AzizasTask at = new AzizasTask();

    @Test
    public void Test () throws InterruptedException {
        at.openSite()
                .authorization();
        at.addUser();
        WebElement element = Driver.getDriver().findElement(By.xpath("//span[@class='label label-registration']"));
        at.compareResult("GROUP MEMBER",element.getText());

                at.synchUser()


               .unsynchUser()
                .removeUser()
                .openCoursesTab()
                .addCourseTab();
        WebElement element2 = Driver.getDriver().findElement(By.xpath("(//span[@class='label label-registration'])[2]"));
        at.compareResult("GROUP MEMBER",element2.getText());
                at.removeCourseTab();

                //.closeChrome();

    }

//    String [] expectedResult = {"User added to group successfully",
//            "User synchronized successfully.",
//            "User unsynchronized successfully.",
//            "User removed from group successfully.",
//            "Course added to group successfully.",
//            "Course removed from group successfully."};
//
//    //use assert to compare expected and actual results
//    int count = 0;
    public static void compareResult(String expectedResult, String actualResult) {
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println("Expected result: " + expectedResult);
        System.out.println("Actual result: " + actualResult);
        System.out.println("Test passed");
    }






}
