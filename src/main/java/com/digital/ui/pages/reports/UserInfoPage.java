package com.digital.ui.pages.reports;

import com.digital.ui.pages.BasePage;
import com.digital.ui.pages.ExpediaHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
Created by Rustam Karimov
UserInfoPage (https://treemnt.talentlms.com/reports/userinfo/id:1)
'Progress' tab:
Overview Courses Certificates Badges Timeline
 */
public class UserInfoPage extends BasePage {

    @FindBy(xpath = "//a[@class=\"btn\" and contains(text(), \"Progress\")]")
    public WebElement progressBtn;

    @FindBy(xpath = "//a[text()='Timeline']")
    public WebElement userTimeline;

    @FindBy(xpath = "//a[@id='badges-tab']")
    public WebElement userBadges;

    @FindBy(xpath = "//a[@id='certifications-tab']")
    public WebElement userCertificates;

    @FindBy(xpath = "//a[@id='courses-tab']")
    public WebElement userCourses;

    @FindBy(xpath = "//a[@id='overview-tab']")
    public WebElement userOverview;

    @FindBy(xpath = "//div[@class='item-value'][@title='20']")
    public WebElement userPoints;

    @FindBy(xpath = "//div[text()=\"Courses in progress\"]")
    public WebElement userCoursesInProgress;

    @FindBy(xpath = "//div[text()=\"Completed courses\"]")
    public WebElement userCompletedCourses;

    @FindBy(xpath = "//div[text()=\"Courses not started\"]")
    public WebElement userCoursesNotStarted;

    @FindBy(xpath = "//div[text()=\"Training time\"]")
    public WebElement userTrainingTime;

    @FindBy(xpath = "//a[text()=\"Today\"]")
    public WebElement todayBtn;

    @FindBy(xpath = "//a[text()=\"Yesterday\"]")
    public WebElement yesterdayBtn;

    @FindBy(xpath = "//a[text()=\"Week\"]")
    public WebElement weekBtn;

    @FindBy(xpath = "//a[text()=\"Month\"]")
    public WebElement monthBtn;

    @FindBy(xpath = "//a[text()=\"Year\"]")
    public WebElement yearBtb;

    @FindBy(xpath = "//a[text()=\"Period\"]")
    public WebElement periodBtn;

    @FindBy(xpath = "//div[@class='bar bar-points gamification-ranking-item tl-cursor-pointer']")
    public WebElement pointsBtn;

    @FindBy(xpath = "//div[@class='bar bar-badges gamification-ranking-item tl-cursor-pointer']")
    public WebElement badgesBtn;

    @FindBy(xpath = "//div[@class='bar bar-levels gamification-ranking-item tl-cursor-pointer']")
    public WebElement levelBtn;

    @FindBy(xpath = "//li[@id='points-row']/a")
    public WebElement userPointsLeaderboard;

    @FindBy(xpath = "//li[@id='levels-row']/a")
    public WebElement userLevelsLeaderboard;

    @FindBy(xpath = "//li[@id='badges-row']/a")
    public WebElement userBadgesLeaderboard;

    @FindBy(xpath = "//i[@class='icon-pencil ml-1 quickEditPoints']")
    public WebElement pencilPointsBtn;

    @FindBy(xpath = "//input[@id='quick-edit-points']")
    public WebElement quickEditPoints;

    @FindBy(xpath = "//a[@id='icon-save-points']")
    public WebElement savePointsBtn;

    @FindBy(xpath = "//a[@id='icon-remove-points']")
    public WebElement removePointsBtn;

    @FindBy(xpath = "//a[@id='tl-howto-collect-points']/text()")
    public WebElement pointsCollectBtn;




//    public UserInfoPage openProgressTab(){
//        elementActions.click(progressBtn);
//        return this;


}
