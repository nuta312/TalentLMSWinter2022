package com.digital.ui.pages.courses_page;

import com.digital.enums.CoursePageData;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCoursePage extends BasePage {

    @FindBy(xpath = "//a[text()='Add course']")
    public WebElement addCourseBtn;

    @FindBy(xpath = "//input[@placeholder='e.g. Introduction to Accounting']")
    public WebElement courseNameInp;

    @FindBy(xpath = "//a[@class='select2-choice select2-default']")
    public WebElement select;

    @FindBy(xpath = "//a[@class='select2-choice select2-default']")
    public WebElement categoryInp;

    @FindBy(xpath = "//textarea[@class='span7']")
    public WebElement descriptionInp;

    @FindBy(xpath = "//a[@class='btn btn-primary dropdown-toggle']")
    public WebElement dropdown;

    @FindBy(xpath = "//a[contains(text(),'Save and go to course index')]")
    public WebElement saveBtn;
    @FindBy(xpath = "//a[@class='tl-bold-link tl-show-price-link']")
    public WebElement price;

    @FindBy(xpath = "//input[@id='course-price']")
    public WebElement priceInp;



    public AddCoursePage addCourseMethod() {
        elementActions.press(addCourseBtn);
        return this;
    }

    public AddCoursePage fillCourseInputs() {
        elementActions.input(courseNameInp, CoursePageData.COURSE_NAME1.getInpVal());

        elementActions.press(select);
        elementActions.input(categoryInp, CoursePageData.CATEGORY1.getInpVal());
        elementActions.pressDownAndEnter(categoryInp);

        elementActions.input(descriptionInp, CoursePageData.DESCRIPTION1.getInpVal());
        return this;
    }

    public AddCoursePage choosePrice() {
        price.click();
        elementActions.input(priceInp, "100");
        priceInp.click();
        return this;
    }

    public AddCoursePage clickSaveBtn() {
        elementActions.press(dropdown);
        elementActions.pressUpAndEnter(saveBtn);
        return this;
    }
}
