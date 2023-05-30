package com.digital.ui.pages.usersHP.userPage;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.basePage.BasePage;
import com.digital.ui.pages.usersHP.course.Courses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage {

    WebElementActions elementActions = new WebElementActions();
    Actions actions = new Actions(Driver.getDriver());


    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li[2]")
    public WebElement coursesField;

    @FindBy(xpath = "//a[@href='https://aisana0803.talentlms.com/user/groups/id:5']")
    public WebElement groupsField;

    public UsersPage clickUser(String usersName) {
        WebElement user = Driver.getDriver()
                .findElement(By
                        .xpath("//tr[@role='row']/td/a/span[contains(., '" + usersName + "')]"));
        webElementActions.press(user);
        return this;
    }

    public UsersPage selectSectionCoursesField() {
        webElementActions.press(coursesField);
        return this;
    }

    public UsersPage selectGroupField() {
        webElementActions.press(groupsField);
        return this;
    }

    private final Courses courses = new Courses();

    public Courses goToCourses() {
        return courses;
    }

    public UsersPage seeReportsOfLearner(String userName){
        WebElement user = Driver.getDriver().findElement(By.xpath("//tr[@role][contains(.,'"+userName+"')]"));
       actions.moveToElement(user).perform();
        WebElement elReports = Driver.getDriver()
                .findElement(By.xpath("//tr[@role][contains(.,'"+userName+"')]//td[7]//div//i[@alt='Reports']"));
        actions.moveToElement(elReports).click().perform();
        return this;
    }

    public UsersPage logIntoAccount(String userName){
        WebElement user = Driver.getDriver().findElement(By.xpath("//tr[@role][contains(.,'"+userName+"')]"));
        actions.moveToElement(user).perform();
        WebElement logIntoAccount = Driver.getDriver()
                .findElement(By.xpath("//tr[@role][contains(.,'"+userName+"')]//td[7]//div//i[@alt='Log into account']"));
        actions.moveToElement(logIntoAccount).click().perform();
        return this;
    }




}
