package com.digital.ui.pages;

import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class ViewCourseCatalogPage extends BasePage {

    WebElementActions elementActions = new WebElementActions();


    @FindBy(xpath = "//a[text()='View course catalog']")
    public WebElement viewCourseCatalogBtn;

    @FindBy(xpath = "//input[@placeholder='Search courses']")
    public WebElement searchCourses;

    @FindBy(xpath = "(//div[@class='tl-clear-input-btn'])[3]")
    public WebElement searchClearCourses;

    @FindBy(xpath = "(//span[@class='catalog_course_name tl-bold-item']/a)[1]")
    public WebElement introductionToTalentLms;

    @FindBy(xpath = "//a[@class='pull-left tl-return-to-catalog-from-course-info']")
    public WebElement backBtn;

    @FindBy(xpath = "//a[@title='Order']")
    public WebElement dropDownCourseOrder;


    public ViewCourseCatalogPage catalogBtn() {
        viewCourseCatalogBtn.click();
        return this;
    }

    public ViewCourseCatalogPage inputCourses() {
        elementActions.input(searchCourses, "Introduction to TalentLMS");
        return this;
    }

    public ViewCourseCatalogPage openIntroductionTalentLms() {
        introductionToTalentLms.click();
        return this;
    }

    public ViewCourseCatalogPage backBtn() {
        elementActions.press(backBtn);
        return this;
    }

    public ViewCourseCatalogPage courseOrder() {
        List<String> listOfOrder = List.of("Date", "Name", "Price");
        dropDownCourseOrder.click();
        dropDownCourseOrder.sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER);
        return this;
    }
}



