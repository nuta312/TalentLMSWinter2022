package com.digital.ui.pages;

<<<<<<< HEAD
=======

>>>>>>> db3f167 (New commit)
import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
<<<<<<< HEAD

import static org.testng.AssertJUnit.assertTrue;


public class AddAndUpdateGroupPage extends LoginPage {
=======
import static org.testng.AssertJUnit.assertTrue;

public class AddAndUpdateGroupPage extends BasePage{

>>>>>>> db3f167 (New commit)

    public WebElementActions elementActions = new WebElementActions();

    public WebDriver driver = Driver.getDriver();

    @FindBy(xpath = "//div[@id='tl-admin-dashboard']/div[4]/div/div[2]/a")
    public WebElement addGroupBtn;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement inputNameField;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//a[@id='show-key']")
    public WebElement groupKey;

    @FindBy(xpath = "//input[@name='group_key']")
    public WebElement keyInputField;

    @FindBy(xpath = "//a[@id='show-price']")
    public WebElement priceField;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement priceInputField;


    @FindBy(xpath = "//input[@name='submit_group']")
    public WebElement submitBtn;


    @FindBy(xpath = "//div[@id='tl-admin-dashboard']/div[4]/div/div[1]/a")
    public WebElement groupsBtn;


    @FindBy(xpath = "(//td[@class=' tl-align-left hidden-phone'])[1]")
    public WebElement textLine;

    @FindBy (xpath = "(//i[@title='Edit'])[1]")
    public WebElement editPencil;

    @FindBy (xpath = "//table[@id='tl-groups-grid']/tbody/tr/td[1]/a/span")
    public WebElement expectedName;

    @FindBy (xpath = "//td[@class=' tl-align-left hidden-phone']")
    public WebElement expectedDescription;

    @FindBy (xpath = "//span[@class='label label-default']")
    public WebElement expectedPrice;

    @FindBy (xpath = " (//span[@class='help-inline'])[1]")
    public WebElement nameRequired;

    @FindBy (xpath = "//a[@title='Groups']")
    public WebElement groupList;


<<<<<<< HEAD
    public AddAndUpdateGroupPage openPage(){
        driver.get("https://aigerim3110.talentlms.com/dashboard");
        return this;
    }

=======
>>>>>>> db3f167 (New commit)

    public AddAndUpdateGroupPage addNewGroup(){
        addGroupBtn.click();
        return this;
    }

    public AddAndUpdateGroupPage inputNameOfGroup(String groupName){
        elementActions.input(this.inputNameField, groupName);
        return this;
    }

    public AddAndUpdateGroupPage inputDescription(String txt){
        elementActions.input(this.descriptionField, txt);
        return this;
    }

    public AddAndUpdateGroupPage inputKey(String key){
        groupKey.click();
        elementActions.input(this.keyInputField, key);
        return this;
    }

    public AddAndUpdateGroupPage inputPrice(String price){
        priceField.click();
        elementActions.input(this.priceInputField, price);
        return this;
    }

    public AddAndUpdateGroupPage submitGroup(){
        submitBtn.click();
        return this;
    }

    public AddAndUpdateGroupPage displayGroupList(){
        groupsBtn.click();
        return this;
    }



    public AddAndUpdateGroupPage editGroup() {

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(textLine).perform();
<<<<<<< HEAD

=======
>>>>>>> db3f167 (New commit)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        editPencil = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@title='Edit'])[1]")));
        editPencil.click();

        return this;
    }

    public AddAndUpdateGroupPage backToGroupList(){
        groupList.click();
        return this;
    }

    public AddAndUpdateGroupPage assertCondition(boolean bool){
        assertTrue(bool);
        return this;
    }

<<<<<<< HEAD
=======


>>>>>>> db3f167 (New commit)
}
