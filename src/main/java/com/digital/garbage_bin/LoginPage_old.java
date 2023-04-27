package com.digital.garbage_bin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
Template by Rustam Karimov
Target - open and login into the TalentLMS main-page (https://www.talentlms.com/)
Cannot get login in due to protection - "You do not have such privileges" - guess the site has some security options against QA
 */
import java.time.Duration;
public class LoginPage_old {
    WebDriver driver;
    @Test
    public void loginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.talentlms.com/");
        WebElement loginBtn1 = driver.findElement(By.linkText("Login")); // login button - 1 (https://www.talentlms.com/)
        loginBtn1.click(); // go to login page (https://app.talentlms.com/login)
        Thread.sleep(5000);
        WebElement domain = driver.findElement(By.name("domain"));
        domain.sendKeys("treemnt");
        WebElement userName = driver.findElement(By.name("login"));
        userName.sendKeys("rustam_karimov2@outlook.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Rustam-558173370");
        Thread.sleep(3000);
        WebElement loginBtn2 = driver.findElement(By.name("submit")); // login button - 1 (https://app.talentlms.com/login)
        loginBtn2.click();

    }
}
