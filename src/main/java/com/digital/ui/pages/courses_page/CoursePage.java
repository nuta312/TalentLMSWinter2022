package com.digital.ui.pages.courses_page;

import com.digital.enums.Cars;
import com.digital.enums.CoursePageData;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage extends BasePage {

    WebElementActions elemActions = new WebElementActions();

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

    @FindBy(xpath = "//input[@name='submit_course']")
    public WebElement saveBtn;



    public CoursePage fillCourseInputs() {
        elemActions.input(courseNameInp, CoursePageData.COURSE_NAME1.getInpVal());
        elemActions.input(descriptionInp, CoursePageData.DESCRIPTION1.getInpVal());

        elemActions.press(select);
//        elemActions.pressDownAndEnter(select);
        elemActions.input(categoryInp, CoursePageData.CATEGORY1.getInpVal());
        elemActions.pressDownAndEnter(categoryInp);


//        courseNameInp.sendKeys("aaaaaaa");
//        categoryInp.sendKeys("ghjkl");
//        descriptionInp.sendKeys("bbbbbb");
        return this;
    }

    public CoursePage clickSaveBtn() {
        elemActions.press(dropdown);
        elemActions.pressUpAndEnter(saveBtn);
        return this;
    }


    public CoursePage addCourseMethod() {
        elemActions.press(addCourseBtn);
        return this;
    }




}
