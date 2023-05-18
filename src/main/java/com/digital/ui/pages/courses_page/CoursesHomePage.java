package com.digital.ui.pages.courses_page;

import com.digital.ui.driver.Driver;
import com.digital.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.digital.enums.AddCourse.*;
import static org.testng.Assert.assertTrue;

import java.util.List;

/**
 * @author Burulai Narzieva
 */


public class CoursesHomePage extends BasePage {
    @FindBy(xpath = "(//a[contains(text(),'Courses')])[1]")
    public WebElement coursesPageLink;

    @FindBy(xpath = "(//a[@class='btn btn-danger'])[1]")
    public WebElement deleteAlertBtn;

    @FindBy(xpath = "//span[@class='tl-formatted-course-name']")
    public List<WebElement> listOfCourses;

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis']")
    public WebElement resultOfTitle;

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis']")
    public WebElement test;

    @FindBy(xpath = "//h3[text()='Clone']")
    public WebElement cloneTitle;

    @FindBy(xpath = "//a[@id='tl-clone-modal-confirm-submit']")
    public WebElement confirmDeletionBtn;

    @FindBy(xpath = "//h3[text()='Delete Course?']")
    public WebElement deleteTitle;


    public CoursesHomePage openCoursesPage() {
        coursesPageLink.click();
        return this;
    }


    public CoursesHomePage baseFunction(String title) {
        WebElement element = Driver.getDriver().findElement(
                By.xpath("//span[text()='" + listOfCourses.get(1).getText()
                        + "']/following::td[3]/descendant::i[@title='" + title + "']"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
        return this;
    }

    public CoursesHomePage reportCourseBtnOnCoursePage() {
        baseFunction("Reports");
        elementActions.customAssertEquals(resultOfTitle,
                REPORTS_RESULT.getValue() + listOfCourses.get(1).getText());
        return this;
    }


    public CoursesHomePage editCourseBtnOnCoursePage() {
        baseFunction("Edit");
        elementActions.customAssertEquals(resultOfTitle,
                EDIT_RESULT.getValue() + listOfCourses.get(0).getText());
        return this;
    }

    public CoursesHomePage cloneCourseBtnOnCoursePage() {
        baseFunction("Clone");
        elementActions.customAssertEquals(cloneTitle, CLONE_TITLE.getValue());
        return this;
    }

    public CoursesHomePage confirmClone() {
        elementActions.press(confirmDeletionBtn);
        for (int i = 0; i < listOfCourses.size(); i++) {
            if (listOfCourses.get(i).getText() == listOfCourses.get(1).getText() + " (clone)") {
                assertTrue(true);
            }
        }
        return this;
    }

    public CoursesHomePage deleteCourseBtnOnCoursePage() {
        baseFunction("Delete");
        elementActions.customAssertEquals(deleteTitle, DELETE_TITLE.getValue());
        return this;
    }

    public CoursesHomePage confirmDeletion() {
        elementActions.press(deleteAlertBtn);
        for (int i = 0; i < listOfCourses.size(); i++) {
            if (listOfCourses.get(i).getText() != listOfCourses.get(1).getText()) {
                assertTrue(true);
            }
        }
        return this;
    }


    public CoursesHomePage viewCourseBtnOnCoursePage() {
        baseFunction("Go to course");
        elementActions.customAssertEquals(test, HOME_RESULT.getValue());
        return this;
    }

}











































//    @FindBy(xpath = "//tr[@role='row']")
//    public List<WebElement> allCourseList;
//
//    @FindBy(xpath = "//td/span")
//    public List<WebElement> allStatusOfCourses;
//
//    @FindBy(xpath = "//i[@alt='Delete']")
//    public List<WebElement> allDeleteBtn;
//
//    @FindBy(xpath = "(//a[@class='btn btn-danger'])[1]")
//    public WebElement deleteOkBtn;
//
//    @FindBy(xpath = "//a[@class='clone-btn none-decoration']")
//    public List<WebElement> allCloneBtn;
//
//    @FindBy(xpath = "//a[@id='tl-clone-modal-confirm-submit']")
//    public WebElement cloneOkBtn;
//
//
//    @FindBy(xpath = "//span[text()='The Little Foxes']/following::td[3]/descendant::i[@title='Delete']")
//    public WebElement testDelete;
//


//    public CoursesHomePage deletingCourse(){
//
//        for (WebElement course : allCourseList) {
//            elementActions.moveToElement(course);
//
//            for (WebElement statusOfCourse : allStatusOfCourses) {
//                elementActions.moveToElement(statusOfCourse);
//
//                    for (WebElement toDeleteBtn : allDeleteBtn) {
//                        elementActions.press(toDeleteBtn);
//                        elementActions.press(deleteOkBtn);
//                    }
//                }
//        }
//        return this;
//    }
//

