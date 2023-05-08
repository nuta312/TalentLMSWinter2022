package com.digital.ui.pages;

import com.digital.ui.data;
import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends LoginPage {
    public void users() {
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        loginPage.Loginpress();
        loginPage.Loginentering();
        loginPage.Loginchoice();
        Driver.getDriver().navigate().to(data.URLUSER.getUserInfo());
        WebElement table = (WebElement) Driver.getDriver().findElement(By.id("tl-users-grid"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        ArrayList listOfUsers = new ArrayList();
        Object[][] l = new Object[listOfUsers.size() / 7][7];
        Actions action = new Actions(Driver.getDriver());
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.println(cell.getText());
            }
        }
        String usernameForLink = data.NAME.getUserInfo() + "." + data.SURNAME.getUserInfo();
        WebElement userlink = Driver.getDriver().findElement(By.xpath("//a [@data-original-title='Username: " + usernameForLink + "']"));
        userlink.click();
    }

    public static void main(String[] args) {
        UsersPage usersPage=new UsersPage();
        usersPage.users();
    }
}
