package com.digital.ui.pages;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.support.PageFactory;

public class PracticeFormPage {

    public PracticeFormPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
