package com.digital.ui.pages;

import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchInputCoursePage extends BasePage{
    WebElementActions elementActions = new WebElementActions();

    @FindBy(xpath = "//label[@class='tl-can-clear-input']")
    WebElement searchCourseInputField;


    public SearchInputCoursePage searchInputCourse(String searchNewCourse){
        elementActions.input(searchCourseInputField, searchNewCourse);
        return this;
    }



}
