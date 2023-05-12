


package com.digital.ui.pages;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    WebElementActions elementActions = new WebElementActions();
    public void BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}