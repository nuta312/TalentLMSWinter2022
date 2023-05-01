package com.digital.ui.pages;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AzizasTask extends LoginPage{

    WebDriver driver = Driver.getDriver();

    @FindBy(xpath = "//i[@title='Add to group']")
    WebElement addUserToGroup;


    @FindBy(xpath = "(//i[@title='Add the remaining group courses to user'])[1]")
    WebElement synchronizeUser;

    @FindBy(xpath = "(//i[@title='Remove all group courses from user'])[1]")
    WebElement unsynchronizeUser;

    @FindBy(xpath = "(//i[@title='Remove from group'])[1]")
    WebElement removeUserFromGroup;

    @FindBy(linkText = "Courses")
    WebElement coursesTab;

    @FindBy(xpath = "//i[@title='Remove from group']")
    WebElement removeCourse;

    @FindBy(xpath = "//i[@title='Add to group']")
    WebElement addCourse;


    public AzizasTask openSite(){

        driver.get("https://azizastest.talentlms.com/group/users/id:4");
        return this;
    }

    public AzizasTask addUser() throws InterruptedException {
        Thread.sleep(2000);
        addUserToGroup.click();
        return this;
    }
    public AzizasTask synchUser() throws InterruptedException {
        Thread.sleep(2000);
        synchronizeUser.click();
        return this;

    }
    public AzizasTask unsynchUser() throws InterruptedException {
        Thread.sleep(2000);
        unsynchronizeUser.click();
        return this;
    }
    public  AzizasTask removeUser() throws InterruptedException {
        Thread.sleep(2000);
        removeUserFromGroup.click();
        return this;
    }
    public AzizasTask openCoursesTab () throws InterruptedException{
        Thread.sleep(2000);
        coursesTab.click();
        return this;
    }
    public AzizasTask removeCourseTab () throws InterruptedException{
        Thread.sleep(2000);
        removeCourse.click();
        return this;
    }
    public AzizasTask addCourseTab () throws InterruptedException{
        Thread.sleep(2000);
        addCourse.click();
        return this;
    }
    public AzizasTask closeChrome () {
        driver.quit();
        return this;
    }

    public AzizasTask compareResult(String expectedResult, String actualResult) {
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println("Expected result: " + expectedResult);
        System.out.println("Actual result: " + actualResult);
        System.out.println("Test passed");
        return this;
    }

}
