package com.digital.ui.pages;

import com.digital.ui.driver.Driver;

import com.digital.ui.driver.DriverActions;

import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;


public abstract class BasePage implements DriverActions {

    WebElementActions elementActions = new WebElementActions();
    public BasePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


}
