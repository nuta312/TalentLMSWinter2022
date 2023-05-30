package com.digital.ui.pages;
import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage extends BasePage{

//    public void FindAddUser(){
//        LoginPage loginPage=new LoginPage();
//        loginPage.login();
//        loginPage.Loginpress();
//        loginPage.Loginentering();
//        loginPage.Loginchoice();
//        WebElement adduserbtn= getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/a"));
//        webElementActions.press(adduserbtn);
//    }
//    public void ForSkippingProblem(){LoginPage loginPage=new LoginPage();
//        loginPage.login();
//        loginPage.Loginpress();
//        loginPage.Loginentering();
//        WebElement adduserbtn= getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/a"));
//        webElementActions.press(adduserbtn);
//    }

    @FindBy(xpath = "//input[@name='name']") public static WebElement firstname;
    @FindBy(xpath = "//input[@name='surname']")public static WebElement surname;
    @FindBy(xpath = "//input[@name='email']")public static WebElement email;
    @FindBy(xpath = "//input[@name='password']") public static WebElement password;
    @FindBy(xpath = "//textarea[@name='description']") public static  WebElement bio;
    @FindBy(xpath = "//select[@name='acl_user_type_id']")public static WebElement learnerType;
    @FindBy(xpath = "//select[@name='timezone']") public static WebElement timeZone;
    @FindBy(xpath = "//select[@name='language']") public static WebElement language;
    @FindBy(xpath = "//input[@ name='status']") public static WebElement  checkBoxStatus;
    @FindBy(xpath = "//input[@name='deactivate_user']") public static WebElement checkBoxDeactive;
    @FindBy(xpath = "//input[@name = 'submit_personal_details']")public static WebElement submitUser;
    @FindBy(xpath = "//input[@name='avatar[]']") public static WebElement upload;
    @FindBy(xpath = "//a[text()='Upload profile pic']") public static WebElement uploadPicture;
    @FindBy(xpath = "//a[@title='Home']") public static WebElement homeBtn;
    @FindBy(xpath = "(//a[contains(text(),'Add user')])[1]") public static WebElement addUserBtn;
    @FindBy(xpath = "//a [@href='https://nna.talentlms.com/user/index']") public static WebElement cancelbtn;
    @FindBy(xpath = "/html/body/div[12]/div[1]/table/thead/tr[1]/th[2]") public static WebElement calendar1;
    @FindBy(xpath = "/html/body/div[12]/div[2]/table/thead/tr/th[3]") public static WebElement goRight;
    @FindBy(xpath = "/html/body/div[12]/div[2]/table/thead/tr/th[2]") public static WebElement year;
    @FindBy(xpath = "//button [text()='Apply']") public static WebElement  fileapply;
    @FindBy(xpath = "//input[@name='submit_personal_details']") public static WebElement submitAddUserBtn;
    @FindBy(xpath = "(//span[@class='add-on'])[1]")    public static WebElement FirstNameInputFieldCounter;
    @FindBy(xpath = "(//span[@class='add-on'])[2]") public static WebElement  lastNameInputFieldCounter;
    @FindBy(xpath = "(//span[@class='add-on'])[3]") public static WebElement emailAddressInputFieldCounter;
    @FindBy(xpath = "(//span[@class='add-on'])[4]") public static WebElement userNameInputFieldCounter;
    @FindBy(xpath = "(//span[@class='add-on'])[5]") public static WebElement passwordInputFieldCounter;
    @FindBy(xpath = "(//span[@class='help-inline'])[3]") public static WebElement emailErrorMess;
    @FindBy(xpath = "//input[@name='login']") public static WebElement usernameInput;

    @FindBy(xpath = "(//a [@href='https://nna.talentlms.com/user/index/gridPref:reset'])[2]") public static WebElement usersbtn;


    public AddUserPage clickHomeBtn(){
        webElementActions.press(homeBtn);
        return this;
    }
    public AddUserPage inputName(String name){
        webElementActions.input(firstname,name);
        return this;
    }
    public AddUserPage inputSurname(String surname){
        webElementActions.input(this.surname,surname);
        return this;
    }
    public AddUserPage inputEmail(String email){
        webElementActions.input(this.email,email);
        return this;
    }
    public AddUserPage inputPassword(String password){
        webElementActions.input(this.password,password);
        return this;
    }
    public AddUserPage inputBio(String bio){
        webElementActions.input(this.bio,bio);
        return this;
    }
    public AddUserPage inputLearnerType(String txt){
        Select select=new Select(this.learnerType);
        select.selectByVisibleText(txt);
        return this;
    }
    public AddUserPage inputTimezone(String txt){
        Select select=new Select(this.timeZone);
        select.selectByValue(txt);
        return this;
    }
    public AddUserPage inputLanguage(String txt){
        Select select=new Select(this.language);
        select.selectByValue(txt);
        return this;
    }
    public AddUserPage inputCheckBox(String txt){
        if(!this.checkBoxStatus.isSelected()) {
            if (txt.equalsIgnoreCase("Active")) webElementActions.press(this.checkBoxStatus);

        }
        return this;
    }
    public AddUserPage inputCheckBoxDeactive(String txt){
        if(!this.checkBoxDeactive.isSelected()){
            if(txt.equalsIgnoreCase("deactivate_user"))webElementActions.press(this.checkBoxDeactive);
        }
        return  this;
    }
    public AddUserPage inputCalendar(String txt){
        String[] arr =txt.split(" ");
        this.calendar1.click();
        while(!this.year.getText().contains(arr[2])){
            goRight.click();
        }
        Driver.getDriver().findElement(By.xpath("//span[text()='"+arr[1]+"']")).click();
        Driver.getDriver().findElement(By.xpath("//td[text()='"+arr[0]+"'] [@class='day '] "));
        return this;}
    public AddUserPage inputSubmitUser(){
        webElementActions.press(submitUser);
        return this;
    }
    public AddUserPage uploadPic(String txt){
        //webElementActions.fileupload(upload,txt);
        webElementActions.press(fileapply);
        return this;
    }
    public AddUserPage cancel(){
        webElementActions.press(cancelbtn);
        Driver.getDriver().navigate().to("https://nna.talentlms.com/user/index");
        return this;
    }


}
