package com.digital.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.digital.ui.driver.Driver.getDriver;

public class AddUserPage extends LoginPage{
    public void FindAddUser(){
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        loginPage.Loginpress();
        loginPage.Loginentering();
        loginPage.Loginchoice();
        WebElement adduserbtn= getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/a"));
        we.press(adduserbtn);
    }
    public void AddUserPage(){
        Users.adduser();
    }

    public static void main(String[] args) {
        AddUserPage addUserPage=new AddUserPage();
        addUserPage.FindAddUser();
        addUserPage.AddUserPage();
    }
}
