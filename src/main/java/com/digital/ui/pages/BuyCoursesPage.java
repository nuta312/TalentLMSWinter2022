package com.digital.ui.pages;

import com.digital.enums.Courses;
import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
  * @author Kubanych
  **/
public class BuyCoursesPage extends BasePage{

    Actions actions = new Actions(Driver.getDriver());

    WebElementActions elementActions = new WebElementActions();

    @FindBy(xpath = "(//a[contains(text(),'Courses')])[1]")
    public WebElement coursesMain;

    @FindBy(xpath = "//a[text()='Buy courses']")
    public WebElement buyCourse;

    ///////////////////////////////////////////

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchCourseInputField;

    @FindBy(xpath = "//tbody[@class='listMarketplace']")
    public WebElement machineLearningCourse;

    @FindBy(xpath = "//a[text()='return to TalentLibrary']")
    public WebElement returnLinkBtn;

    @FindBy(xpath = "//ul[@class='dynatree-container']")
    WebElement rightCollections;

    // Elements For Assert

    @FindBy(xpath = "(//li[@id='dynatree-id-92']//span//span)[2]")
    public WebElement checkBusinessSkill;

    @FindBy(xpath = "//span[text()='What is Machine Learning?']")
    public WebElement machineLearnText;

    @FindBy(xpath = "(//span[text()='What is Machine Learning? '])[2]")
    public WebElement enteredMachineText;

    @FindBy(xpath = "//span[text()='Preventing Discrimination & Harassment: CA Employee']")
    public WebElement checkOtherPreventing;

    ////////////////////////////////////////////////////
    // Other Course Providers page

    @FindBy(xpath = "//a[text()='Other course providers']")
    public WebElement otherCourseProv;

    @FindBy(xpath = "//label[@class='tl-can-clear-input']")
    public WebElement inputBuildingCareerCrse;

    @FindBy(xpath = "//span[text()='Building Your Career']")
    public WebElement buildingCareerText;

    /////////////////////////////////////////////
    //

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement GO_TO;

    @FindBy(xpath = "(//i[@class='tl-icon16 icon-book'])[2]")
    public WebElement goToCourses;


    public  List<String> getCollections(){
        List<WebElement> lists = Driver.getDriver().findElements(By.xpath("//ul[@class='dynatree-container']"));
        List<String> elements = new ArrayList<>();

        int count = 0;
        for (WebElement e : lists) {
            elements.add(e.getText());
         //   System.out.println(e.getText());
            count++;

        }
        System.out.println(count);
        System.out.println(elements.size() + " element's size" );
        return elements;
    }


    public BuyCoursesPage goTO() throws InterruptedException {
        actions.moveToElement(GO_TO).perform();
        Thread.sleep(1000);
        actions.moveToElement(goToCourses).perform();
        goToCourses.click();
        return this;
    }




    public BuyCoursesPage clickCourses() throws InterruptedException {
        elementActions.press(buyCourse);
        return this;
    }

    public BuyCoursesPage searchAndFindCourse() {
     //   elementActions.input(searchCourseInputField, Courses.MACHINE_COURSE.getCourse());
        searchCourseInputField.sendKeys(Courses.MACHINE_COURSE.getCourse());
        return this;
    }

    public BuyCoursesPage pressMachineCourse(){
        elementActions.press(machineLearningCourse);
    //    machineLearningCourse.sendKeys(Keys.ENTER);
        return this;
    }

    public BuyCoursesPage pressReturnLinkBtn(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,500)");
        returnLinkBtn.sendKeys(Keys.ENTER);
        return this;
    }


    public BuyCoursesPage clickSearchInputField(String courseName){
        elementActions.input(searchCourseInputField, courseName);
        return this;
    }

    public BuyCoursesPage myAssertEquals(WebElement element, String courseName){
        Assert.assertEquals(element.getText(), courseName);
        return this;
    }

    public BuyCoursesPage buildingCareerByAssert(){
          Assert.assertEquals(buildingCareerText.getText(), Courses.BUILDING_COURSE.getCourse());
          return this;
    }

    //////////////////////////////////////////////////////////
    // Other Course Provider methods;

    public BuyCoursesPage clickOtherCourseProv(){
        otherCourseProv.click();
        return this;
    }

    public BuyCoursesPage findBuildingOtherCourse(String courseName){
        elementActions.input(inputBuildingCareerCrse, courseName);
        return this;
    }


}
