package com.digital.ui.pages;
import com.digital.ui.driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UploadFilesVenera extends LoginVenera {
    WebDriver driver = Driver.getDriver();
    Actions action = new Actions(driver);

    @FindBy(xpath = "//*[@id=\"tl-admin-dashboard\"]/div[4]/div/div[1]/a")
    WebElement group;

    @FindBy(xpath = "//*[@id=\"tl-groups-grid\"]/tbody/tr/td[1]/a")
    WebElement clickCourse;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div/div[2]/div/div/ul/li[4]/a")
    WebElement files;

    @FindBy(xpath = "//input[contains(@name,'files[]')]")
    WebElement filesUpload;

    @FindBy(xpath = "//*[@id=\"tl-files-grid\"]/tbody/tr/td[2]/span/ul/li/a")
    WebElement visibilityBtn;

    @FindBy(xpath = "//*[@id=\"tl-files-grid\"]/tbody/tr/td[2]/span/ul/li/ul/div/span")
    WebElement vn;

    @FindBy(xpath = "//td[@class=' tl-align-left']")
    WebElement elementToHover;

    @FindBy(xpath = "//a[@title='Preview']")
    WebElement previewBtn;

    @FindBy(xpath = "(//a[@class='close'])[1]")
    WebElement closePic;

    @FindBy(xpath = "//i[@title='Edit']")
    WebElement editBtn;

    @FindBy(xpath = "//li[@class='select2-no-results']")
    WebElement editTag;

    @FindBy(xpath = "//a[text()='cancel']")
    WebElement cancelBtn;

    @FindBy(xpath = "//i[@class='icon-remove icon-grid']")
    WebElement deleteBtn;

    @FindBy(xpath = "//a[@id='tl-confirm-submit']")
    WebElement deleteFile;

    @FindBy(xpath = "(//a[@class='btn'])[2]")
    WebElement cancelDeleting;


    public UploadFilesVenera enterGroup() {
        group.click();
        return this;
    }

    public UploadFilesVenera enterCourse() {
        clickCourse.click();
        return this;
    }

    public UploadFilesVenera enterFiles() {
        files.click();
        return this;
    }


    public UploadFilesVenera uploadFile(String path) throws InterruptedException {
        filesUpload.sendKeys(path);
        Thread.sleep(5000);
        return this;
    }

    public UploadFilesVenera visible() throws InterruptedException {
        visibilityBtn.click();
        Thread.sleep(1000);
        vn.click();
        Thread.sleep(1000);
        return this;
    }

    public UploadFilesVenera  previewTest() throws InterruptedException {
        action.moveToElement(elementToHover).perform();
        Thread.sleep(1000);
        previewBtn.click();
        Thread.sleep(3000);
        closePic.click();
        return this;
    }

    public UploadFilesVenera editMethod(String name) throws InterruptedException {
        Thread.sleep(1000);
        action.moveToElement(elementToHover).perform();
        Thread.sleep(1000);
        editBtn.click();
        WebElement inputName = driver.findElement(By.xpath("//input[@name='renameFileName']"));
        inputName.clear();
        Thread.sleep(1000);
        inputName.sendKeys(name);
        Thread.sleep(1000);
        WebElement updateBtn = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        updateBtn.click();
        return this;
    }

    public UploadFilesVenera cancelUpdate(String name1) throws InterruptedException {
        Thread.sleep(1000);
        action.moveToElement(elementToHover).perform();
        Thread.sleep(1000);
        action.click(editBtn).perform();
        WebElement inputName2 = driver.findElement(By.xpath("//input[@name='renameFileName']"));
        inputName2.clear();
        Thread.sleep(1000);
        inputName2.sendKeys(name1);
        Thread.sleep(1000);
        cancelBtn.click();
        return this;
    }

    public UploadFilesVenera deleteFile() throws InterruptedException {
        action.moveToElement(elementToHover).perform();
        Thread.sleep(1000);
        deleteBtn.click();
        Thread.sleep(1000);
        cancelDeleting.click();
        Thread.sleep(1000);
        action.moveToElement(elementToHover).perform();
        deleteBtn.click();
        Thread.sleep(1000);
        deleteFile.click();
        Thread.sleep(1000);
        return this;
    }
}