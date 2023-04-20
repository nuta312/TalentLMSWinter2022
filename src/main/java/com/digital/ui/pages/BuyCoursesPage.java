package com.digital.ui.pages;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyCoursesPage extends BasePage{



    WebElementActions elementActions = new WebElementActions();


    @FindBy(xpath = "//div/a[@href='https://kubabeck.talentlms.com/course/index/gridPref:reset']")
    WebElement coursesMain;

    @FindBy(xpath = "//a[text()='Buy courses']")
    WebElement buyCourse;

    public BuyCoursesPage clickCourses() throws InterruptedException {
        elementActions.press(buyCourse);
        return this;
    }



}
