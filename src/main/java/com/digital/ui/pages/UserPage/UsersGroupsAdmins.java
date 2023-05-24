package com.digital.ui.pages.UserPage;

import com.digital.ui.pages.BasePage;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.util.*;

import static com.digital.ui.driver.DriverActions.driver;

public class UsersGroupsAdmins extends BasePage {


        public UsersGroupsAdmins openRandomGroup(){
        List<WebElement> groupLinks = driver.findElements(By.xpath("//tbody/tr/td/span/a"));
        int groupCount = groupLinks.size();
        int randomIndex = new Random().nextInt(groupCount);
        WebElement randomGroupLink = groupLinks.get(randomIndex).findElement(By.xpath("./.."));
        randomGroupLink.click();
        return this;
    }
        public UsersGroupsAdmins selectcourses(){
        for(int i =0;i<3;i++ ){
            List<WebElement> coursesLinks = driver.findElements(By.xpath("//tbody/tr/td[3]/div/i"));
            int couersesCount = coursesLinks.size();
            int randomIndex = new Random().nextInt(couersesCount);
            WebElement randomCoursesLink = coursesLinks.get(randomIndex).findElement(By.xpath("./.."));
            randomCoursesLink.click();
        }
        return this;
    }

        public UsersGroupsAdmins openCourses(){
        WebElement goToLink = Driver.getDriver().findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/ul/li[3]/a"));
        goToLink.click();
        return this;
    }
        public UsersGroupsAdmins optionsGRoup(int times){
        for (int i = 0; i < times; i++) {
            List<WebElement> coursesLinks = driver.findElements(By.xpath("//tbody/tr/td[3]/div/i"));
            int coursesCount = coursesLinks.size();
            int randomIndex = new Random().nextInt(coursesCount);
            WebElement randomCoursesLink = coursesLinks.get(randomIndex).findElement(By.xpath("./.."));
            randomCoursesLink.click();
        }
        return this;
    }

        public UsersGroupsAdmins getMinusToPlusGroups() {
        List<WebElement> groupMinusButtons = driver.findElements(By.xpath("//i[@class='icon-minus icon-grid tl-toggle-user']"));
        for(WebElement minusButton:groupMinusButtons){
            WebElement parentElement = minusButton.findElement(By.xpath("./.."));
            parentElement.click();
        }

        return this;
    }
        public UsersGroupsAdmins getMinusToPlusCourses() {
        List<WebElement> groupMinusButtons = driver.findElements(By.xpath("//i[@class='icon-minus icon-grid tl-toggle-course']"));
        for(WebElement minusButton:groupMinusButtons){
            WebElement parentElement = minusButton.findElement(By.xpath("./.."));
            parentElement.click();
        }

        return this;
    }
        public boolean  isFileDownload(String filePath,String fileName){
//        String filePath = "C:\\Users\\DELL\\Downloads";
        File dir = new File(filePath);
        File[] files = dir.listFiles();
        for(File file: files){
            if(file.getName().equals(fileName)){
                System.out.println("File downloaded successfully.");
                return true;
            }else {
                System.out.println("File not found or was not downloaded.");
            }
        }
        return false;
    }

        public UsersGroupsAdmins DownloadDocument(){
        WebElement GoDownloa = driver.findElement(By.xpath("//i[@class='icon-download tl-icon19']"));
        GoDownloa.click();
        return this;
    }

        public UsersGroupsAdmins SearchFiled(){
        List<WebElement> nameElements = driver.findElements(By.xpath("//tbody/tr/td/span"));
        for(WebElement NameElement: nameElements){
            String name = NameElement.getText();
            WebElement searchField = driver.findElement(By.xpath("//input[@aria-controls='tl-group-courses']"));
            searchField.clear();
            searchField.sendKeys(name);
            searchField.sendKeys(Keys.ENTER);
            Assert.assertFalse(nameElements.isEmpty(),"Нет элементов с именами на странице");
        }
        return this;
    }


        public UsersGroupsAdmins refresh(){
        driver.navigate().refresh();
        return this;
    }

    }

