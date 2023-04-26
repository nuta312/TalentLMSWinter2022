package com.digital.ui.pages.courses_page;

import static com.digital.enums.AddCourse.ERROR_INLINE;
import static com.digital.enums.AddCourse.COURSES_TITLE;
import static com.digital.enums.AddCourse.SAMPLES;
import static com.digital.enums.AddCourse.TITLE;

import com.digital.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

/**
 * @author Burulai Narzieva
 */

public class AddCoursePage extends BasePage {
    @FindBy(xpath = "//a[text()='Add course']")
    public WebElement addCourseBtn;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-large']")
    public WebElement addFirstCourseBtn;

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis']")
    public WebElement addCourseTitle;

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis']")
    public WebElement coursesTitle;

    @FindBy(xpath = "//input[@placeholder='e.g. Introduction to Accounting']")
    public WebElement courseNameInp;

    @FindBy(xpath = "(//span[@class='help-inline'])[1]")
    public WebElement errorInline;

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

    @FindBy(xpath = "//a[text()='cancel']")
    public WebElement cancelBtn;

    @FindBy(tagName = "td")
    public List<WebElement> listOfCourses;




    public static String getRandomPrice () {
        Random rand = new Random();
        int price = rand.nextInt(3000);
        return Integer.toString(price);
    }


    public AddCoursePage choosePrice() {
        price.click();
        priceInp.sendKeys(getRandomPrice());
        priceInp.click();
        return this;
    }


    public AddCoursePage saveNewCourse() {
        elementActions.press(dropdown);
        elementActions.pressUpAndEnter(saveBtn);
        return this;
    }

    public AddCoursePage addingNewCourse() {
        elementActions.press(listOfCourses.size() >= 1
                ? addCourseBtn
                : addFirstCourseBtn)
                .customAssertEquals(addCourseTitle, TITLE.getValue());
        return this;
    }

    String book = faker.book().title();
    public AddCoursePage fillCourseInputs() {
        elementActions.input(courseNameInp, book)
                .press(select)
                .input(categoryInp, SAMPLES.getValue())
                .pressDownAndEnter(categoryInp)
                .input(descriptionInp, faker.book().publisher());
        return this;
    }

    public AddCoursePage cancelBtn() {
        elementActions.press(cancelBtn);
        elementActions.customAssertEquals(coursesTitle, COURSES_TITLE.getValue());
        return this;
    }

    public AddCoursePage checkEmptyFieldsWithAssert() {
        elementActions.customAssertEquals(errorInline, ERROR_INLINE.getValue());
        return this;
    }

    public AddCoursePage checkAddedCourseWithAssert() {
        for(int i = 0; i < listOfCourses.size(); i++) {
            if(listOfCourses.get(i).getText().equals(book)) {
                elementActions.customAssertEquals(listOfCourses.get(i), book);
            }
        }
        return this;
    }

}
