package com.digital.ui.pages.courses_page;

import com.digital.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseHomePage extends BasePage {
    @FindBy(xpath = "(//a[contains(text(),'Courses')])[1]")
    public WebElement coursesPageLink;

    public CourseHomePage openCoursesPage(){
        coursesPageLink.click();
        return this;
    }
}
