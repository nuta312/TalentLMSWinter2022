package ui.users;
import com.digital.ui.driver.Driver;

import com.digital.ui.driver.Driver;
import com.digital.ui.users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Users {
    @Test
    public void fillformtest() {

        inputFields inputfield = new inputFields();
        inputfield.openPage()
                .inputName(users.NAME.getUserInfo())
                .inputSurname(users.SURNAME.getUserInfo())
                .inputEmail(users.EMAIL.getUserInfo())
                .inputUsername(users.USERNAME.getUserInfo())

        ;
    }
}
