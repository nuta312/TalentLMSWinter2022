package com.digital.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.digital.ui.driver.Driver.getDriver;

public class LoginPage extends BasePage {
    String url="https://www.talentlms.com/";
    public void login() {
        getDriver().navigate().to(url);
    }
    public void Loginpress(){
        WebElement element= getDriver().findElement(By.xpath("/html/body/header/nav/div/div/div[2]/ul/li[1]/a"));
        we.press(element);
    }
    public void Loginentering(){
        WebElement domenfield= getDriver().findElement(By.xpath("//input[@name='domain']"));
        we.input(domenfield,"nna");
        WebElement login= getDriver().findElement(By.xpath("//input[@name='login']"));
        we.input(login,"samatelikbaev");
        WebElement password= getDriver().findElement(By.xpath("//input[@name='password']"));
        we.input(password,"36654299");
        WebElement log= getDriver().findElement(By.xpath("//*//input[@name='submit']"));
        we.press(log);
    }
    public void Loginchoice(){
        WebElement ch= getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/div[2]/div[4]/a"));
        we.press(ch);
    }

    public static void main(String[] args) {
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        loginPage.Loginpress();
        loginPage.Loginentering();
        loginPage.Loginchoice();

    }
}
