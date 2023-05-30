package com.digital.ui.pages.usersHP.course;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Courses extends BasePage {
    public WebElementActions webElementActions = new WebElementActions();
    Actions actions = new Actions(Driver.getDriver());

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement allCourses;

    @FindBy(xpath = "//tr[contains(.,'Instructor')]")
    public WebElement instructorField;

    @FindBy(xpath = "//a[@class='btn dropdown-toggle']")
    public WebElement btnMassActions;

    @FindBy(xpath = "//a[text()='Enroll']")
    public WebElement enrollInMassActions;

    @FindBy(xpath = "//a[text()='Unenroll']")
    public WebElement unenrollInMassActions;

    @FindBy(xpath = "//a[text()='Reset progress']")
    public WebElement resetProgressInMassActions;

    // alert btns

    @FindBy(xpath = "//a[@class='btn tl-mass-assign btn-success']") //(//a[@role='menuitem'])[1]
    public WebElement btnEnrollInAlert;

    @FindBy(xpath = "//a[@class='btn btn-danger tl-mass-unassign']")
    public WebElement btnUnenrollInAlert;

    @FindBy(xpath = "//td[@class=' tl-align-center tl-table-operations-cell']/div")
    public WebElement prePlusBtns;


    public Courses enroll(String course) throws InterruptedException {
        WebElement minusElement = Driver.getDriver().findElement(By
                .xpath("//tr[contains(., '" + course + "')]/td[3][contains(., '-')]"));
        if (minusElement.isDisplayed()) {
            WebElement selectBtn = Driver.getDriver().findElement(By
                    .xpath("//tr[contains(., '" + course + "')]//input[@type='checkbox']"));
            webElementActions.getActions().moveToElement(selectBtn).click().perform();
            Thread.sleep(2000);
            WebElement btnEnroll = Driver.getDriver().findElement(By
                    .xpath("//tr[contains(., '" + course + "')]//i[contains(@alt,'Enroll')]"));
            webElementActions.getActions().moveToElement(btnEnroll).click().perform();
            Thread.sleep(3000);
        }
        return this;
    }

    public Courses unenroll(String courseName) throws InterruptedException {
        WebElement minusElement = Driver.getDriver().findElement(By
                .xpath("//tr[contains(., '" + courseName + "')]/td[3][contains(., 'Learner')]"));
        if (minusElement.isDisplayed()) {
            WebElement selectBtn = Driver.getDriver().findElement(By
                    .xpath("//tr[contains(., '" + courseName + "')]//input[@type='checkbox']"));
            webElementActions.getActions().moveToElement(selectBtn).click().perform();
            Thread.sleep(2000);
            WebElement btnUnenroll = Driver.getDriver().findElement(By
                    .xpath("//tr[contains(., '" + courseName + "')]//i[contains(@alt,'Unenroll')]"));
            webElementActions.getActions().moveToElement(btnUnenroll).click().perform();
            Thread.sleep(2000);
        }

        return this;
    }
    public Courses enrollToAllCourses() {
        List<WebElement> allPlusBtns = Driver.getDriver().findElements(By
                .xpath("//td[@class=' tl-align-center tl-table-operations-cell']/div/i[@alt='Enroll']"));
        for (int i = 0; i < allPlusBtns.size(); i++) {
            webElementActions.pressJs(allPlusBtns.get(i));
        }
        return this;
    }

    public Courses unenrollFromAllCourses() {
        List<WebElement> allMinBtns = Driver.getDriver().findElements(By
                .xpath("//td[@class=' tl-align-center tl-table-operations-cell']/div/i[@alt='Unenroll']"));
        for (int i = 0; i < allMinBtns.size(); i++) {
            webElementActions.pressJs(allMinBtns.get(i));
        }
        return this;
    }

    public Courses resetProgress(WebElement element) throws InterruptedException {
        webElementActions.getActions().moveToElement(element).click().perform();
        Thread.sleep(2000);
        webElementActions.getActions().moveToElement(btnMassActions).click().perform();
        webElementActions.getActions().click(resetProgressInMassActions).perform();
        Thread.sleep(2000);
        return this;
    }

    public Courses changeRoleToLearner(String courseName) throws InterruptedException {
        WebElement instructorBtn = Driver.getDriver()
                .findElement(By
                        .xpath("//tr[contains(., '" + courseName + "')]/td[3][contains(., 'Instructor')]"));
        if (instructorBtn.isDisplayed()) {
            instructorBtn.click();
            Thread.sleep(2000);
            WebElement btnLearnerInInstructorRole = Driver.getDriver()
                    .findElement(By
                            .xpath("//tr[contains(., '" + courseName + "')]/td[3][contains(., 'Instructor')]//div[contains(., 'Learner')]"));
            btnLearnerInInstructorRole.click();
        }
        return this;
    }

    public Courses changeAllRolesToLearner() {
        List<WebElement> allInstructorBtns = Driver.getDriver()
                .findElements(By.xpath("//tr/td[3][contains(., 'Instructor')]"));
        List<WebElement> allLearnerBtnsInInstructorRole = Driver.getDriver()
                .findElements(By.xpath("//tr/td[3][contains(., 'Instructor')]//div[contains(., 'Learner')]"));
        for (int i = 0; i < allInstructorBtns.size(); i++) {
            for (int j = 0; j < allLearnerBtnsInInstructorRole.size(); j++) {
                webElementActions.pressJs(allInstructorBtns.get(i));
                webElementActions.pressJs(allLearnerBtnsInInstructorRole.get(i));
            }
        }
        return this;

    }

    public Courses changeRoleToInstructor(String courseName) throws InterruptedException {
        WebElement instructorBtn = Driver.getDriver()
                .findElement(By
                        .xpath("//tr[contains(., '"+courseName+"')]/td[3][contains(., 'Learner')]"));
        if (instructorBtn.isDisplayed()) {
            instructorBtn.click();
            Thread.sleep(2000);
            WebElement btnLearnerInInstructorRole = Driver.getDriver()
                    .findElement(By
                            .xpath("//tr[contains(., '" + courseName + "')]/td[3][contains(., 'Learner')]//div[contains(., 'Instructor')]"));
            btnLearnerInInstructorRole.click();
        }
        return this;
    }

    public Courses changeAllRolesToInstructor() {
        List<WebElement> allInstructorBtns = Driver.getDriver()
                .findElements(By.xpath("//tr/td[3][contains(., 'Learner')]"));
        List<WebElement> allLearnerBtnsInInstructorRole = Driver.getDriver()
                .findElements(By.xpath("//tr/td[3][contains(., 'Learner')]//div[contains(., 'Instructor')]"));
        for (int i = 0; i < allInstructorBtns.size(); i++) {
            for (int j = 0; j < allLearnerBtnsInInstructorRole.size(); j++) {
                webElementActions.pressJs(allInstructorBtns.get(i));
                webElementActions.pressJs(allLearnerBtnsInInstructorRole.get(i));
            }
        }
        return this;

    }


}
