package com.digital.ui.pages;

import com.digital.ui.driver.Driver;
<<<<<<< HEAD
=======
import com.digital.ui.driver.DriverActions;
>>>>>>> master
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

<<<<<<< HEAD
    public WebElementActions elementActions = new WebElementActions();

    public BasePage() {
=======
public abstract class BasePage implements DriverActions {

    WebElementActions elementActions = new WebElementActions();
    public BasePage(){
>>>>>>> master
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
