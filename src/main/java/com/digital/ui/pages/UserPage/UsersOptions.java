package com.digital.ui.pages.UserPage;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersOptions {

    @FindBy(xpath = "//a[contains(text(),'Groups')]")
    public WebElement Groups;

    public UsersOptions openGroups() throws InterruptedException {
        Driver.getDriver().get("https://dmc312.talentlms.com/user/groups/id:1");
        return this;
    }

    public UsersOptions openFiles() throws InterruptedException {
        Driver.getDriver().navigate().to("https://dmc312.talentlms.com/user/files/id:1");
        Thread.sleep(2000);
        return this;
    }


}
