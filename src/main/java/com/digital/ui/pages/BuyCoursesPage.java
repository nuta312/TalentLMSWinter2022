package com.digital.ui.pages;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyCoursesPage extends BasePage{



    WebElementActions elementActions = new WebElementActions();


    @FindBy(xpath = "(//a[contains(text(),'Courses')])[1]")
    WebElement coursesMain;

    @FindBy(xpath = "//a[text()='Buy courses']")
    WebElement buyCourse;

    ///////////////////////////////////////////

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchCourseInputField;

    @FindBy(id = "movie_player")
    WebElement youTubeWindow;

    // List of Courses

    @FindBy(xpath = "//span[text()='Introduction to TalentLMS']")
    WebElement introductOfTalentLms;

    public BuyCoursesPage clickCourses() throws InterruptedException {
        elementActions.press(buyCourse);
        return this;
    }

    public BuyCoursesPage searchAndFindCourse(String nameOfCourse) {
        WebElement course = Driver.getDriver().findElement(By.xpath("//span[text()='"+ nameOfCourse +"']"));
        searchCourseInputField.sendKeys(nameOfCourse);
        course.click();
        return this;
    }

    public BuyCoursesPage clickYouTubeWindow(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,500)");

        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js2.executeScript("arguments[0].click();", youTubeWindow);
        return this;
    }

    public BuyCoursesPage clickSearchInputField(String courseName){
        elementActions.input(searchCourseInputField, courseName);
        return this;
    }



}
