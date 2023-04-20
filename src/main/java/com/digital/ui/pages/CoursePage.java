package com.digital.ui.pages;

import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage extends BasePage{

    WebElementActions elementActions = new WebElementActions();

    @FindBy(xpath = "//a[text()='Add course']")
    public WebElement addCourseBtn;

    public CoursePage addCourseMethod() {
        elementActions.press(addCourseBtn);
        return this;
    }




}
