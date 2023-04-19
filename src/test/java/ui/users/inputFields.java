package ui.users;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.users;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class inputFields {
    WebElementActions we=new WebElementActions();
    public inputFields(){
    PageFactory.initElements(Driver.getDriver(),this); }
    @FindBy(xpath = "//input[@name='name']") public WebElement firstname;
    @FindBy(xpath = "//input[@name='surname']")public WebElement surname;
    @FindBy(xpath = "//input[@name='email']")public WebElement email;
    @FindBy(xpath = "//input[@name='login']")public WebElement username;
    public inputFields openPage(){
        Driver.getDriver().navigate().to("https://www.talentlms.com/");
        WebElement element=Driver.getDriver().findElement(By.xpath("/html/body/header/nav/div/div/div[2]/ul/li[1]/a"));
        WebElementActions we=new WebElementActions();
        we.press(element);
        WebElement domenfield=Driver.getDriver().findElement(By.xpath("//input[@name='domain']"));
        we.input(domenfield,"nna");
        WebElement login=Driver.getDriver().findElement(By.xpath("//input[@name='login']"));
        we.input(login,"samatelikbaev");
        WebElement password=Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        we.input(password,"36654299");
        WebElement log=Driver.getDriver().findElement(By.xpath("//*//input[@name='submit']"));
        we.press(log);
        WebElement ch=Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/div[2]/div[4]/a"));
        we.press(ch);
        WebElement adduserbtn=Driver.getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/a"));
        we.press(adduserbtn);
        return this;
    }
    public inputFields inputName(String name){
        we.input(this.firstname,name);
        return this;
    }
    public inputFields inputSurname(String surname){
        we.input(this.surname,surname);
        return this;
    }
    public inputFields inputEmail(String email){
       we.input(this.email,email);
       return this;
    }
    public inputFields inputUsername(String username){
        we.input(this.username,username);
        return this;
    }

}
