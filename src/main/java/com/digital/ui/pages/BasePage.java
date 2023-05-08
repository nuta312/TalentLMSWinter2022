package com.digital.ui.pages;

import com.digital.ui.data;
import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public abstract class BasePage {

    protected WebDriver driver;
    public WebElementActions we=new WebElementActions();

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static class Users {

        public void fillformtest() {
            Driver.getDriver().navigate().to(data.URL.getUserInfo());
            String title = Driver.getDriver().getTitle();
            Assert.assertEquals(title, "TalentLMS: Cloud LMS Software - #1 Online Learning Platform");
        }
            public static void adduser(){
            inputFields inputfield = new inputFields();
            String name=data.NAME.getUserInfo(),surname=data.SURNAME.getUserInfo();//email=data.EMAIL.getUserInfo();
            inputfield
                    .inputName(name)
                    .inputSurname(surname)
                    .inputEmail(data.EMAIL.getUserInfo())
                    .inputPassword(data.PASSWORD.getUserInfo())
                    .inputBio(data.BIO.getUserInfo())
                    .inputLearnerType(data.LEARNERTYPE.getUserInfo())
                    .inputTimezone(data.TIMEZONE.getUserInfo())
                    .inputLanguage(data.LANGUAGE.getUserInfo())
                    .inputCheckBox(data.CHECKBOXSTATUS.getUserInfo())
                    .inputCheckBoxDeactive(data.CHECKBOXDEACTIVE.getUserInfo())
                    .inputCalendar("10 May 2025")
                    .uploadPic("C:\\Users\\user\\IdeaProjects\\TalentLMSWinter2022\\src\\test\\java\\ui\\users\\11.png")
                    .inputSubmitUser()
                    .inputSubmitUser()


            ;
        }
    }

    public static class inputFields {
        WebElementActions we=new WebElementActions();
        public inputFields(){
        PageFactory.initElements(Driver.getDriver(),this); }
        @FindBy(xpath = "//input[@name='name']") public WebElement firstname;
        @FindBy(xpath = "//input[@name='surname']")public WebElement surname;
        @FindBy(xpath = "//input[@name='email']")public WebElement email;
        @FindBy(xpath = "//input[@name='password']") public WebElement password;
        @FindBy(xpath = "//textarea[@name='description']") public WebElement bio;
        @FindBy(xpath = "//select[@name='acl_user_type_id']")public WebElement learnerType;
        @FindBy(xpath = "//select[@name='timezone']") public WebElement timeZone;
        @FindBy(xpath = "//select[@name='language']") public WebElement language;
        @FindBy(xpath = "//input[@ name='status']") public WebElement checkBoxStatus;
        @FindBy(xpath = "//input[@name='deactivate_user']")WebElement checkBoxDeactive;
        @FindBy(xpath = "//input[@name = 'submit_personal_details']")public WebElement submitUser;
        @FindBy(xpath = "//input[@name='avatar[]']") public WebElement upload;
        @FindBy(xpath = "//a [@href='https://nna.talentlms.com/user/index']") public WebElement cancelbtn;
        @FindBy(xpath = "/html/body/div[12]/div[1]/table/thead/tr[1]/th[2]") public WebElement calendar1;
        @FindBy(xpath = "/html/body/div[12]/div[2]/table/thead/tr/th[3]") public  WebElement goRight;
        @FindBy(xpath = "/html/body/div[12]/div[2]/table/thead/tr/th[2]") public WebElement year;
        @FindBy(xpath = "//button [text()='Apply']") public WebElement fileapply;
        public inputFields openPage(){
            Driver.getDriver().navigate().to("https://www.talentlms.com/index");
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
        public inputFields inputPassword(String password){
            we.input(this.password,password);
            return this;
        }
        public inputFields inputBio(String bio){
            we.input(this.bio,bio);
            return this;
        }
        public inputFields inputLearnerType(String txt){
            Select select=new Select(learnerType);
            select.selectByVisibleText(txt);
            return this;
        }
        public inputFields inputTimezone(String txt){
            Select select=new Select(timeZone);
            select.selectByValue(txt);
            return this;
        }
        public inputFields inputLanguage(String txt){
            Select select=new Select(language);
            select.selectByValue(txt);
            return this;
        }
        public inputFields inputCheckBox(String txt){
            if(!checkBoxStatus.isSelected()) {
                if (txt.equalsIgnoreCase("Active")) we.press(checkBoxStatus);

            }
            return this;
        }
        public inputFields inputCheckBoxDeactive(String txt){
            if(!checkBoxDeactive.isSelected()){
                if(txt.equalsIgnoreCase("deactivate_user"))we.press(checkBoxDeactive);
            }
            return  this;
        }
        public inputFields inputCalendar(String txt){
            String[] arr =txt.split(" ");
            calendar1.click();
            while(!year.getText().contains(arr[2])){
                goRight.click();
            }
            Driver.getDriver().findElement(By.xpath("//span[text()='"+arr[1]+"']")).click();
            Driver.getDriver().findElement(By.xpath("//td[text()='"+arr[0]+"'] [@class='day '] "));
            return this;}
        public inputFields inputSubmitUser(){
            we.press(submitUser);
            return this;
        }
        public inputFields uploadPic(String txt){
            we.fileupload(upload,txt);
            we.press(fileapply);
            return this;
        }
        public inputFields cancel(){
            we.press(cancelbtn);
            Driver.getDriver().navigate().to("https://nna.talentlms.com/user/index");
            return this;
        }


    }
}
