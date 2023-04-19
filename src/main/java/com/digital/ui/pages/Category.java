package com.digital.ui.pages;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.List;

public class Category extends BasePage{

    @FindBy(xpath = "//a[text()='Add category']")
    public WebElement addCategoryBtn;

    @FindBy(xpath = "//input[@placeholder='e.g. Accounting']")
    public WebElement nameInput;

    @FindBy(xpath = "//div[@class=\"select2-container tl-select2\"]/a")
    public WebElement parentCategoryInput;

    @FindBy(xpath = "//a[@id='show-price']")
    public WebElement showPriceBtn;

    @FindBy(xpath = "//input[@id='category-price']")
    public WebElement priceInput;

    @FindBy(xpath = "//div[@class='btn-group']/input")
    public WebElement getAddCategoryBtn2;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement inputLoginUser;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement submit;
    WebDriver driver;

    public Category login(){

        inputLoginUser.sendKeys("dastankgb7@gmail.com");
        password.sendKeys("");
        submit.click();

        return this;
    }
    public Category openPage(){
        Driver.getDriver().get("https://suleimansultan312.talentlms.com/category/index");
return this;

    }

    public Category addCategory(String name, String price, String parentCategory){

        driver = Driver.getDriver();

        Actions action = new Actions(Driver.getDriver());
        action.click(addCategoryBtn).perform();

        action.sendKeys(name).perform();


        nameInput.sendKeys(name);
        parentCategoryInput.click();

        List<WebElement> parentCategoryList = driver.findElements(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable']/div]"));

        for (WebElement pc:parentCategoryList
             ) {
            if(pc.getText().equals(parentCategory)){
                pc.click();
            }
        }

        showPriceBtn.click();
        priceInput.sendKeys(price);

        getAddCategoryBtn2.click();

        return this;
    }
}
