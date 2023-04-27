package com.digital.ui.pages.users;

import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilesPage extends BasePage {

    private WebElementActions elementActions = new WebElementActions();
    @FindBy(xpath = "//a[text()='Files']")
    public WebElement files;

    @FindBy(xpath = "//a[text()='Choose files to upload or drag-and-drop here']")
    public WebElement uploadFile;


}
