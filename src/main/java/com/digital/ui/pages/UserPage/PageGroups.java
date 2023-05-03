package com.digital.ui.pages.UserPage;

import com.digital.ui.BasePage;
import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class PageGroups extends BasePage {

    @FindBy(xpath = "//span[contains(@title,'Top')]")
    public WebElement groupTop;

    @FindBy(xpath = "//span[contains(@title,'Mid')]")
    public WebElement groupMid;


    @FindBy(xpath = "//span[contains(text(),'group member')]")
    public WebElement GroupMember;


//    public PageGroups deleteOrAddGroup(String groupName) throws InterruptedException {
//        try {
//            WebElement groupNum = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + groupName + "')]//div[contains(@class,'tl-user-group-courses-noinfo-wrapper')]"));
//            String styleAttributeValue = groupNum.getAttribute("style");
//
//            if (styleAttributeValue.contains("display: none")) {
//                WebElement addGroupBtn = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + groupName + "')]//i[contains(@alt,'Remove from group')]"));
//                removeGroupBtn.click();
//            } else {
//                WebElement removeGroupBtn = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + groupName + "')]//i[contains(@alt,'Add to group')]"));
//                addGroupBtn.click();
//            }
//            Thread.sleep(2000);
//            return this;
//        } catch (NoSuchElementException e) {
//            System.out.println("Такой группы нету");
//            return null;
//        }
//    }


    public PageGroups addGroup (String groupName) {
        try {
            WebElement groupNum = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + groupName + "')]//div[contains(@class,'tl-user-group-courses-noinfo-wrapper')]"));
            String styleAttributeValue = groupNum.getAttribute("style");

            if (styleAttributeValue.contains("display: none")) {
                WebElement removeGroupBtn = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + groupName + "')]//i[contains(@alt,'Remove from group')]"));
                removeGroupBtn.click();
                return this;
            }
            return this;
        } catch (NoSuchElementException e) {
            System.out.println("Такой группы нету");
            return null;
        }
    }





    public  PageGroups deleteOrAddCourses(String groupName) throws InterruptedException {
        try {
            WebElement groupNum = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + groupName + "')]//div[contains(@class,'tl-user-group-courses-noinfo-wrapper')]"));
            String styleAttributeValue = groupNum.getAttribute("style");

            if (styleAttributeValue.contains("display: none")) {
                WebElement coursesAddOrDel = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + groupName + "')]//span[contains(@class,'tl-user-group-courses')]"));
                String getCourse = coursesAddOrDel.getText().split("/")[0];

                if (!(getCourse.trim().equalsIgnoreCase("0"))) {
                    WebElement removeCourse = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + groupName + "')]//i[contains(@alt,'Remove all group courses from user')]"));
                    removeCourse.click();
                } else {
                    WebElement addCourse = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + groupName + "')]//i[contains(@alt,'Add the remaining group courses to user')]"));
                    addCourse.click();
                }
            }
            Thread.sleep(2000);
            return this;
        } catch (NoSuchElementException e) {
            System.out.println("Такой группы не существует");
            return null;
        }
    }
}
