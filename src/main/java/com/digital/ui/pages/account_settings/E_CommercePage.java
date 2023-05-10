package com.digital.ui.pages.account_settings;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;


public class E_CommercePage {
    private WebElementActions elementActions = new WebElementActions();

    public E_CommercePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    Faker faker = new Faker();

    Actions actions = new Actions(Driver.getDriver());


    @FindBy(xpath = "//a[text()='E-commerce']")
    public WebElement e_commerce;
    @FindBy(xpath = "//select[@id='tl-payment-processor']")
    public WebElement processor;
    @FindBy(xpath = "//option[@value='paypal']")
    public WebElement paypal;
    @FindBy(xpath = "//option[@value='stripe']")
    public WebElement stripe;
    @FindBy(xpath = "//input[@name= 'paypal_address']")
    public WebElement paypalEmail;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[1]")
    public WebElement paypalIcon;
    @FindBy(xpath = "//*[@id=\"43946996329065bf6cd5e6c43a3a79ef\"]/fieldset[1]/div[3]/div/a/img")
    public WebElement stripeLink;


    @FindBy(id = "show-subscription")
    public WebElement subscription;

    @FindBy(id = "show-discount")
    public WebElement discount;
    @FindBy(xpath = "(//label[@class='checkbox'])[3]")
    public WebElement discountCheckBox;
    @FindBy(id = "global_discount_percentage")
    public WebElement percentageOfDiscount;

    @FindBy(css = "[name='issue_invoices']")
    public WebElement invoiceCheckBox;
    @FindBy(id = "invoice-preview")
    public WebElement invoicePreview;
    @FindBy(id = "invoices_message")
    public WebElement invoiceMessage;

    @FindBy(xpath = "//div[@class='span5 business-info']")
    public WebElement messageInPreview;

    @FindBy(xpath = "//a[text()='Close']")
    public WebElement invoiceCloseBtn;
    @FindBy(id = "show-invoices")
    public WebElement invoices;

    @FindBy(id = "show-coupons")
    public WebElement coupons;
    @FindBy(xpath = "//a[@id='add-coupon-button']")
    public WebElement couponAddBtnMain;
    @FindBy(xpath = "(//a[@class='close'])[1]")
    public WebElement couponCloseBtn;
    @FindBy(xpath = "//input[@name='code']")
    public WebElement couponCode;
    @FindBy(xpath = "//input[@id='valid_from']")
    public WebElement couponFrom;

    @FindBy(xpath = "(//th[@class='switch'])[1]")
    public WebElement year;

    @FindBy(xpath = "/html/body/div[13]/div[2]/table/tbody")
    public WebElement month;
    @FindBy(xpath = "/html/body/div[13]/div[1]/table/tbody")
    public WebElement days;
    @FindBy(xpath = "(//div[@class='dtpicker dropdown-menu'])[1]")
    public WebElement datePicker;
    @FindBy(xpath = "(//div[@class='dtpicker-days'])[1]")
    public WebElement datePickerDay;
    @FindBy(xpath = "(//div[@class='dtpicker-month'])[1]")
    public WebElement datePickerMonth;
    @FindBy(xpath = "(//div[@class='dtpicker-year'])[1]")
    public WebElement datePickerYear;
    @FindBy(xpath = "//input[@id='valid_to']")
    public WebElement couponTo;
    @FindBy(xpath = "(//div[@class='dtpicker dropdown-menu'])[2]")
    public WebElement datePickerTo;
    @FindBy(xpath = "//input[@name='percentage_discount']")
    public WebElement couponPercentage;
    @FindBy(xpath = "//input[@name='max_redemptions']")
    public WebElement couponRedemptions;
    @FindBy(xpath = "//i[@id='tl-redemptions-info-icon']")
    public WebElement redemptionsIcon;
    @FindBy(xpath = "(//ul[@class='select2-choices'])[2]")
    public WebElement inputValidCourses;

    @FindBy(xpath = "//select[@id='tl-coupons-courses-filter']")
    public WebElement couponValidForCourse;
    @FindBy(xpath = "//select[@id='tl-coupons-groups-filter']")
    public WebElement couponValidForGroups;

    @FindBy(xpath = "(//ul[@class='select2-choices'])[3]")
    public WebElement inputValidGroupBtn;

    @FindBy(xpath = "//select[@id='tl-coupons-categories-filter']")
    public WebElement couponValidForCategories;
    @FindBy(xpath = "(//ul[@class='select2-choices'])[4]")
    public WebElement inputValidForCategories;
    @FindBy(xpath = "//input[@name='submit_coupon']")
    public WebElement addCouponBtn;
    @FindBy(xpath = "//a[@href='javascript:hideCouponModal()']")
    public WebElement couponCancelLink;
    @FindBy(xpath = "//i[@title='Edit']")
    public WebElement couponEditBtn;
    @FindBy(xpath = "//i[@title='Delete']")
    public WebElement couponDeleteBtn;
    @FindBy(xpath = "//a[@aria-controls='tl-list-coupons']")
    public WebElement couponSaveBtn;
    @FindBy(xpath = "//input[@name='ecommerce_credits']")
    public WebElement couponCreditsBtn;
    @FindBy(xpath = "(//div[@class='tl-tooltip-content'])[4]")
    public WebElement couponCreditsIcon;

    @FindBy(id = "show-credits")
    public WebElement credits;
    @FindBy(xpath = "//input[@id='tl-ecommerce-credits']")
    public WebElement creditsCheckBox;
    @FindBy(xpath = "(//i[@class='icon-info-circle tl-info-icon'])[4]")
    public WebElement creditsInfoIcon;
    @FindBy(xpath = "//select[@name='credits_operation']")
    public WebElement addCreditsSelect;
    @FindBy(xpath = "//option[text()='Add credits']")
    public WebElement optionAddCredits;
    @FindBy(xpath = "//option[text()='Reset credits']")
    public WebElement optionResetCredits;
    @FindBy(xpath = "//input[@name='credits_to_add'] ")
    public WebElement creditsAmount;
    @FindBy(xpath = "(//label[@class='radio inline'])[1]")
    public WebElement allUsersBtn;
    @FindBy(xpath = "(//label[@class='radio inline'])[2]")
    public WebElement groupBtn;
    @FindBy(xpath = "//select[@name='add_reset_group']")
    public WebElement selectGroup;
    @FindBy(xpath = "(//option[@value='1'])[3]")
    public WebElement chooseStartUp;

    @FindBy(xpath = "(//option[@value='2'])[2]")
    public WebElement chooseEconomics;

    @FindBy(xpath = "(//label[@class='radio inline'])[3]")
    public WebElement specificUserBtn;
    @FindBy(xpath = "//input[@id='s2id_autogen5']")
    public WebElement specificUserType;
    @FindBy(xpath = "//div[@class='select2-result-label']")
    public WebElement userName;


    @FindBy(id = "950426390")
    public WebElement saveBtn;
    @FindBy(xpath = "//a[@href='https://aiperiqa.talentlms.com/dashboard/index']")
    public WebElement cancelLink;


    @FindBy(xpath = "//a[@href='https://aiperiqa.talentlms.com/reports/timeline/mode:ecommerce']")
    public WebElement eCommerceTimelineBtn;


    public E_CommercePage clickCheckBox(WebElement element) {
        element.click();
        element.sendKeys("");
        return this;
    }

    public E_CommercePage scrollDown() throws InterruptedException {
        E_CommercePage set = null;
        set.scrollDown();
        Thread.sleep(3000);
        return this;
    }

    public E_CommercePage addCoupons(String code, String dateFrom, String dateTo, String percentageOff, String redemptions,
                                     String validForCourses, String validForGroups, String validForCategories) throws InterruptedException {

        elementActions.press(coupons);
        elementActions.press(couponAddBtnMain);
        elementActions.input(couponCode, code);
        elementActions.input(couponPercentage, percentageOff);
        elementActions.input(couponRedemptions, redemptions);
        elementActions.press(inputValidCourses);
        Select select1 = new Select(couponValidForCourse);
        List<WebElement> options1 = select1.getOptions();
        for (WebElement e : options1) {
            if (e.getText().equals(validForCourses)) {
                e.click();
            }
        }
        elementActions.press(inputValidGroupBtn);
        Select select2 = new Select(couponValidForGroups);
        List<WebElement> options2 = select2.getOptions();
        for (WebElement e : options2) {
            if (e.getText().equals(validForGroups)) {
                e.click();
            }
        }
        elementActions.waitElementToBeDisplayed(inputValidGroupBtn);
        elementActions.press(inputValidForCategories);
        Select select3 = new Select(couponValidForCategories);
        List<WebElement> options3 = select3.getOptions();
        for (WebElement e : options3) {
            if (e.getText().equals(validForCategories)) {
                e.click();
            }
        }
        elementActions.press(couponCancelLink);
        return this;
    }
    public Object addCoupons() {
        return this;
    }
    public E_CommercePage addCredits(String enterAction, String amountOfCredits, String applyCreditsTo, String groupTo, String userSpecify) throws InterruptedException {

        elementActions.press(credits);
        elementActions.waitElementToBeClickAble(creditsCheckBox);
        elementActions.press(creditsCheckBox);
        elementActions.waitElementToBeDisplayed(addCreditsSelect);
        elementActions.pressDownAndEnter(addCreditsSelect);
        elementActions.waitElementToBeDisplayed(addCreditsSelect);
        Select select = new Select(addCreditsSelect);
        List<WebElement> options = select.getOptions();
        for (WebElement e : options) {
            if (e.getText().equalsIgnoreCase("Add credits")) {
                optionAddCredits.click();
                elementActions.input(creditsAmount, amountOfCredits);
            } else {
                optionResetCredits.click();
            }
        }
        if (applyCreditsTo.equalsIgnoreCase("Group")) {
            elementActions.press(groupBtn);
            elementActions.press(selectGroup);
            Select select2 = new Select(selectGroup);
            List<WebElement> options2 = select2.getOptions();
            for (WebElement e2 : options2) {
                if (e2.getText().equalsIgnoreCase(groupTo)) {
                    e2.click();
                }
            }
        } else if (applyCreditsTo.equalsIgnoreCase("Specific user")) {
            elementActions.press(specificUserBtn);
            elementActions.input(specificUserType, userSpecify);
            elementActions.press(this.userName);
        } else {
            elementActions.waitElementToBeDisplayed(allUsersBtn);
            elementActions.press(allUsersBtn);
        }
        return this;
    }


}





