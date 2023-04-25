package com.digital.ui.pages.courses_page;

import com.digital.enums.AddCourse;
import com.digital.ui.driver.Driver;
import com.digital.ui.pages.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AddCoursePage extends BasePage {
    public static Faker faker = new Faker();

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

    @FindBy(xpath = "//a[text()='cancel']")
    public WebElement cancelBtn;



    public AddCoursePage addingNewCourse() {
        elementActions.press(addCourseBtn);
        return this;
    }

    String book = faker.book().title();

    public AddCoursePage fillCourseInputs() {
        elementActions.input(courseNameInp, book);
        elementActions.press(select);
        elementActions.input(categoryInp, AddCourse.SAMPLES.getValue());
        elementActions.pressDownAndEnter(categoryInp);

        elementActions.input(descriptionInp, faker.book().publisher());
        return this;
    }

    public AddCoursePage choosePrice() {
        price.click();
        elementActions.input(priceInp, AddCourse.PRICE.getValue());
        priceInp.click();
        return this;
    }

    public AddCoursePage saveNewCourse() {
        elementActions.press(dropdown);
        elementActions.pressUpAndEnter(saveBtn);
        return this;
    }

    public AddCoursePage cancelBtn() {
        elementActions.press(cancelBtn);
        return this;
    }

    public AddCoursePage checkAddedCourseWithAssert() {
        List<WebElement> test = Driver.getDriver().findElements(By.tagName("td"));

        for(int i = 0; i < test.size(); i++) {
            if(test.get(i).getText().equals(book)) {
                Assert.assertEquals(test.get(i).getText(), book);
            }
        }
        return this;
    }

}
