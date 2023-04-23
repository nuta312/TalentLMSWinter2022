package com.digital.ui.pages.UserPage;

import com.digital.ui.driver.Driver;
import com.digital.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage {

    @FindBy(xpath = "//a[@data-original-title='Username: dmc_nora']")
    public WebElement Echadaev;

    public UsersPage openEchadaev() throws InterruptedException {
        Echadaev.click();
        Thread.sleep(2000);
        return this;
    }

    

    public UsersPage openUser(String login){
        WebElement userPick = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'"+login+"')]"));
        return this;
    }


}
