package com.digital.ui.pages.courses_page;

import com.digital.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCoursesCatalogPage extends BasePage {

//    @FindBy (xpath = "//a[text()='View course catalog']")
//    public WebElement viewCoursesCatalogBtn;


//    @FindBy(xpath = "//a[text()='View course catalog']")
//    public WebElement viewCourseCatalogBtn;
//
//    @FindBy(xpath = "//input [@placeholder='Search courses']")
//    public WebElement searchCourses;
//
//    @FindBy(xpath = "//span [text() ='Introduction to TalentLMS ']")
//    public WebElement inputCourses;
//
//    @FindBy(xpath = "//a [@class ='pull-left tl-return-to-catalog-from-course-info']")
//    public WebElement backBtn;
//
//    @FindBy(xpath = "//a [@class ='dropdown-toggle tl-catalog-sorting pull-right btn']")
//    public WebElement dropDownBtn;
//
//    @FindBy(xpath = "//a [@data-sortingtype ='name']")
//    public WebElement orderBtnName;
//
//    @FindBy(xpath = "//a [@data-sortingtype ='lastupdate_date']")
//    public WebElement orderBtnDate;
//
//    @FindBy(xpath = "//a [@data-sortingtype ='price']")
//    public WebElement orderBtnPrice;
//
//    @FindBy(xpath = "// i [@class ='catalog-mode-list']")
//    public WebElement viewModeList;
//
//    @FindBy(xpath = "// button [@id ='catalog-mode-grid']")
//    public WebElement viewModeGrid;
//
//
//    public ViewCoursesCatalogPage viewCoursesCatalogMethod() {
//        elementActions.press(viewCourseCatalogBtn);
//        return this;
//    }


    @FindBy(xpath = "//a[text()='View course catalog']")
    public WebElement viewCourseCatalogBtn;

    @FindBy(xpath = "//input [@placeholder='Search courses']")
    public WebElement searchCourses;

    @FindBy(xpath = "//span[text()='For a Breath I Tarry (clone)']")
    public WebElement inputCourses;

    @FindBy(xpath = "//a [@class ='pull-left tl-return-to-catalog-from-course-info']")
    public WebElement backBtn;

    @FindBy(xpath = "//a [@class ='dropdown-toggle tl-catalog-sorting pull-right btn']")
    public WebElement dropDownBtn;

    @FindBy(xpath = "//a [@data-sortingtype ='name']")
    public WebElement orderBtnName;

    @FindBy(xpath = "//a [@data-sortingtype ='lastupdate_date']")
    public WebElement orderBtnDate;

    @FindBy(xpath = "//a [@data-sortingtype ='price']")
    public WebElement orderBtnPrice;

    @FindBy(xpath = "// i [@class ='catalog-mode-list']")
    public WebElement viewModeList;

    @FindBy(xpath = "// button [@id ='catalog-mode-grid']")
    public WebElement viewModeGrid;



    public ViewCoursesCatalogPage catalogBtn() {
        elementActions.press(viewCourseCatalogBtn);
        return this;
    }

    public ViewCoursesCatalogPage inputCourses() {
        elementActions.input(searchCourses, "For a Breath I Tarry (clone)");
        elementActions.press(inputCourses);
        return this;
    }

    public ViewCoursesCatalogPage backBtn() {
        elementActions.press(backBtn);
        return this;
    }

    public ViewCoursesCatalogPage dropDownBtn(){
        elementActions.press(dropDownBtn);
        return this;
        //TODO надо как нажать паузу или как по очереди выбрать name or date or price
    }

    public ViewCoursesCatalogPage orderBtnName() {
        elementActions.press(orderBtnName);
        return this;
    }
    public ViewCoursesCatalogPage orderBtnDate() {
        elementActions.press(orderBtnDate);
        return this;
    }
    public ViewCoursesCatalogPage orderBtnPrice() {
        elementActions.press(orderBtnPrice);
        return this;
    }
    public ViewCoursesCatalogPage viewModeList() {
        elementActions.press(viewModeList);
        return this;
    }
    public ViewCoursesCatalogPage viewModeGrid() {
        elementActions.press(viewModeGrid);
        return this;
    }



}

