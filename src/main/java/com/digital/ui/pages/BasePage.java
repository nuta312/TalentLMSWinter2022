package com.digital.ui.pages;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public WebElementActions elementActions = new WebElementActions();
    public static Faker faker = new Faker();

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
