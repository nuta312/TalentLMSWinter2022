package com.digital.ui.pages;
import com.digital.ui.driver.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
}

