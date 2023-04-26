package com.digital.ui.pages.courses_page;

import com.digital.ui.driver.Driver;
import com.digital.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Burulai Narzieva
 */

public class CoursesHomePage extends BasePage {
    @FindBy(xpath = "(//a[contains(text(),'Courses')])[1]")
    public WebElement coursesPageLink;

    @FindBy(xpath = "//i[@class='icon-pencil icon-grid']")
    public WebElement deleteBtn;

    @FindBy(xpath = "(//a[@class='btn btn-danger'])[1]")
    public WebElement deleteAlertBtn;

    @FindBy(xpath = "//span[@class='tl-formatted-course-name']")
    public List<WebElement> listOfCourses;




    public CoursesHomePage openCoursesPage(){
        coursesPageLink.click();
        return this;
    }

    public CoursesHomePage delete() {
        elementActions.press(deleteBtn);
        return this;
    }

    public CoursesHomePage baseFunction(String title) {
        WebElement element = Driver.getDriver().findElement(
                By.xpath("//span[text()='" + listOfCourses.get(1).getText()
                        + "']/following::td[3]/descendant::i[@title='" + title + "']"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
        return this;
    }

    public CoursesHomePage reportCourseBtnOnCoursePage()  {
        baseFunction("Reports");
        // .....................
        return this;
    }

    public CoursesHomePage editCourseBtnOnCoursePage()  {
        baseFunction("Edit");
        // .....................
        return this;
    }

    public CoursesHomePage cloneCourseBtnOnCoursePage()  {
        baseFunction("Clone");
        // .....................
        return this;
    }

    public CoursesHomePage deletingCourseBtnOnCoursePage()  {
        baseFunction("Delete");
        elementActions.press(deleteAlertBtn);
        return this;
    }

    public CoursesHomePage viewCourseBtnOnCoursePage()  {
        baseFunction("Go to course");
        // .....................
        return this;
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
}
