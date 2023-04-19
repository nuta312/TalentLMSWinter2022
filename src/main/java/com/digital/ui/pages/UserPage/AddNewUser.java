package com.digital.ui.pages.UserPage;

import com.digital.ui.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewUser extends BasePage {

    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement inputFieldName;

    @FindBy(xpath = "(//span[@class='add-on'])[1]")
    public WebElement counterFieldName;

    @FindBy(xpath = "//input[@name='surname']")
    public WebElement inputLastName;






}
