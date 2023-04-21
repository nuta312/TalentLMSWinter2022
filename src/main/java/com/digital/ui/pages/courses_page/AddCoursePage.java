package com.digital.ui.pages.courses_page;

import com.digital.enums.CoursePageData;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCoursePage extends BasePage {

    WebElementActions elemActions = new WebElementActions();

    @FindBy(xpath = "(//a[contains(text(),'Courses')])[1]")
    public WebElement coursesPageLink;

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

    // //a[contains(text(),'Select image')]
    // //img[@src='pages/images/unknown_big.png']
    @FindBy(xpath = "//span[@class='preview']")
    public WebElement selectImg;


    @FindBy(xpath = "//a[@class='tl-bold-link tl-show-price-link']")
    public WebElement price;

    @FindBy(xpath = "//input[@id='course-price']")
    public WebElement priceInp;

    //input[@id='course-price']





    public AddCoursePage addCourseMethod() {
        elemActions.press(addCourseBtn);
        return this;
    }

    public AddCoursePage fillCourseInputs() {
        elemActions.input(courseNameInp, CoursePageData.COURSE_NAME1.getInpVal());

        elemActions.press(select);
        elemActions.input(categoryInp, CoursePageData.CATEGORY1.getInpVal());
        elemActions.pressDownAndEnter(categoryInp);

        elemActions.input(descriptionInp, CoursePageData.DESCRIPTION1.getInpVal());

//        selectImg.click();
//        selectImg.sendKeys(CoursePageData.IMAGE_PATH.getInpVal());
//        selectImg.submit();
//        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
//        executor.executeScript("arguments[0].click();", selectImg);
        return this;
    }


    public AddCoursePage choosePrice() {
        price.click();
        elemActions.input(priceInp, "100");
        priceInp.click();
        return this;
    }

    public AddCoursePage clickSaveBtn() {
        elemActions.press(dropdown);
        elemActions.pressUpAndEnter(saveBtn);
        return this;
    }

    public AddCoursePage openCoursesPage(){
        coursesPageLink.click();
        return this;
    }










}
