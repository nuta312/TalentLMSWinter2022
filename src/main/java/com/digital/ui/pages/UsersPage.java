package com.digital.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.digital.ui.pages.AddUserPage.addUserBtn;

public class UsersPage extends BasePage{





    @FindBy(xpath = "(//a [@href='https://nna.talentlms.com/user/index/gridPref:reset'])[2]")
    public WebElement userslink;

    public UsersPage clickAddUserBtn() {
        webElementActions.press(addUserBtn);
        return this;
    }


    //    WebElementActions we = new WebElementActions();
//    @FindBy(xpath = "//input[@name='name']")
//    public static WebElement firstname;
//    @FindBy(xpath = "//input[@name='surname']")
//    public static WebElement surname;
//    @FindBy(xpath = "//input[@name='email']")
//    public static WebElement email;
//    @FindBy(xpath = "//input[@name='password']")
//    public static WebElement password;
//    @FindBy(xpath = "//textarea[@name='description']")
//    public static WebElement bio;
//    @FindBy(xpath = "//select[@name='acl_user_type_id']")
//    public static WebElement learnerType;
//    @FindBy(xpath = "//select[@name='timezone']")
//    public static WebElement timeZone;
//    @FindBy(xpath = "//select[@name='language']")
//    public static WebElement language;
//    @FindBy(xpath = "//input[@ name='status']")
//    public static WebElement checkBoxStatus;
//    @FindBy(xpath = "//input[@name='deactivate_user']")
//    public static WebElement checkBoxDeactive;
//    @FindBy(xpath = "//input[@name = 'submit_personal_details']")
//    public static WebElement submitUser;
//    @FindBy(xpath = "//input[@name='avatar[]']")
//    public static WebElement upload;
//    @FindBy(xpath = "//a[text()='Upload profile pic']")
//    public static WebElement uploadPicture;
//    @FindBy(xpath = "//a[@title='Home']")
//    public static WebElement homeBtn;
//    @FindBy(xpath = "(//a[contains(text(),'Add user')])[1]")
//    public static WebElement addUserBtn;
//    @FindBy(xpath = "//a [@href='https://nna.talentlms.com/user/index']")
//    public static WebElement cancelbtn;
//    @FindBy(xpath = "/html/body/div[12]/div[1]/table/thead/tr[1]/th[2]")
//    public static WebElement calendar1;
//    @FindBy(xpath = "/html/body/div[12]/div[2]/table/thead/tr/th[3]")
//    public static WebElement goRight;
//    @FindBy(xpath = "/html/body/div[12]/div[2]/table/thead/tr/th[2]")
//    public static WebElement year;
//    @FindBy(xpath = "//button [text()='Apply']")
//    public static WebElement fileapply;
//    @FindBy(xpath = "//input[@name='submit_personal_details']")
//    public static WebElement submitAddUserBtn;
//    @FindBy(xpath = "(//span[@class='add-on'])[1]")
//    public static WebElement FirstNameInputFieldCounter;
//    @FindBy(xpath = "(//span[@class='add-on'])[2]")
//    public static WebElement lastNameInputFieldCounter;
//    @FindBy(xpath = "(//span[@class='add-on'])[3]")
//    public static WebElement emailAddressInputFieldCounter;
//    @FindBy(xpath = "(//span[@class='add-on'])[4]")
//    public static WebElement userNameInputFieldCounter;
//    @FindBy(xpath = "(//span[@class='add-on'])[5]")
//    public static WebElement passwordInputFieldCounter;
//    @FindBy(xpath = "(//span[@class='help-inline'])[3]")
//    public static WebElement emailErrorMess;
//    @FindBy(xpath = "//input[@name='login']")
//    public static WebElement usernameInput;
//    @FindBy(xpath = "(//a [@href='https://nna.talentlms.com/user/index/gridPref:reset'])[2]")
//    public static WebElement usersbtn;
//
//    public void users() {
////        LoginPage loginPage=new LoginPage();
////        loginPage.login();
////        loginPage.Loginpress();
////        loginPage.Loginentering();
////        loginPage.Loginchoice();
////        Driver.getDriver().navigate().to(data.URLUSER.getUserInfo());
//        WebElement table = (WebElement) Driver.getDriver().findElement(By.id("tl-users-grid"));
//        List<WebElement> rows = table.findElements(By.tagName("tr"));
//        ArrayList listOfUsers = new ArrayList();
//        Object[][] l = new Object[listOfUsers.size() / 7][7];
//        Actions action = new Actions(Driver.getDriver());
//        for (WebElement row : rows) {
//            List<WebElement> cells = row.findElements(By.tagName("td"));
//            for (WebElement cell : cells) {
//                //System.out.println(cell.getText());
//            }
//        }
//        String usernameForLink = data.NAME.getUserInfo() + "." + data.SURNAME.getUserInfo();
//        WebElement userlink = Driver.getDriver().findElement(By.xpath("//a [@data-original-title='Username: " + usernameForLink + "']"));
//        userlink.click();
//    }
//
//
//    public static class Users {
//
//        public void fillformtest() {
//            Driver.getDriver().navigate().to(data.URL.getUserInfo());
//            String title = Driver.getDriver().getTitle();
//            Assert.assertEquals(title, "TalentLMS: Cloud LMS Software - #1 Online Learning Platform");
//        }
//
//        public static void adduser() {
//            inputFields inputfield = new inputFields();
//            String name = data.NAME.getUserInfo(), surname = data.SURNAME.getUserInfo();//email=data.EMAIL.getUserInfo();
//            inputfield
//                    .inputName(name)
//                    .inputSurname(surname)
//                    .inputEmail(data.EMAIL.getUserInfo())
//                    .inputPassword(data.PASSWORD.getUserInfo())
//                    .inputBio(data.BIO.getUserInfo())
//                    .inputLearnerType(data.LEARNERTYPE.getUserInfo())
//                    .inputTimezone(data.TIMEZONE.getUserInfo())
//                    .inputLanguage(data.LANGUAGE.getUserInfo())
//                    .inputCheckBox(data.CHECKBOXSTATUS.getUserInfo())
//                    .inputCheckBoxDeactive(data.CHECKBOXDEACTIVE.getUserInfo())
//                    .inputCalendar("10 May 2025")
//                    .uploadPic("C:\\Users\\user\\IdeaProjects\\TalentLMSWinter2022\\src\\test\\java\\ui\\users\\11.png")
//                    .inputSubmitUser()
//                    .inputSubmitUser()
//
//
//            ;
//        }
//    }
//
//    public static class inputFields {
//
//
//        public inputFields() {
//            PageFactory.initElements(Driver.getDriver(), this);
//        }
//
//        WebElementActions we = new WebElementActions();
//
//        public inputFields openPage() {
//            Driver.getDriver().navigate().to("https://www.talentlms.com/index");
//            WebElement element = Driver.getDriver().findElement(By.xpath("/html/body/header/nav/div/div/div[2]/ul/li[1]/a"));
//            WebElementActions we = new WebElementActions();
//            we.press(element);
//            WebElement domenfield = Driver.getDriver().findElement(By.xpath("//input[@name='domain']"));
//            we.input(domenfield, "nna");
//            WebElement login = Driver.getDriver().findElement(By.xpath("//input[@name='login']"));
//            we.input(login, "samatelikbaev");
//            WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
//            we.input(password, "36654299");
//            WebElement log = Driver.getDriver().findElement(By.xpath("//*//input[@name='submit']"));
//            we.press(log);
//            WebElement ch = Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/div[2]/div[4]/a"));
//            we.press(ch);
//            WebElement adduserbtn = Driver.getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/a"));
//            we.press(adduserbtn);
//            return this;
//        }
//
//        public inputFields inputName(String name) {
//            we.input(firstname, name);
//            return this;
//        }
//
//        public inputFields inputSurname(String surname) {
//            we.input(UsersPage.surname, surname);
//            return this;
//        }
//
//        public inputFields inputEmail(String email) {
//            we.input(UsersPage.email, email);
//            return this;
//        }
//
//        public inputFields inputPassword(String password) {
//            we.input(UsersPage.password, password);
//            return this;
//        }
//
//        public inputFields inputBio(String bio) {
//            we.input(UsersPage.bio, bio);
//            return this;
//        }
//
//        public inputFields inputLearnerType(String txt) {
//            Select select = new Select(UsersPage.learnerType);
//            select.selectByVisibleText(txt);
//            return this;
//        }
//
//        public inputFields inputTimezone(String txt) {
//            Select select = new Select(UsersPage.timeZone);
//            select.selectByValue(txt);
//            return this;
//        }
//
//        public inputFields inputLanguage(String txt) {
//            Select select = new Select(UsersPage.language);
//            select.selectByValue(txt);
//            return this;
//        }
//
//        public inputFields inputCheckBox(String txt) {
//            if (!UsersPage.checkBoxStatus.isSelected()) {
//                if (txt.equalsIgnoreCase("Active")) we.press(UsersPage.checkBoxStatus);
//
//            }
//            return this;
//        }
//
//        public inputFields inputCheckBoxDeactive(String txt) {
//            if (!UsersPage.checkBoxDeactive.isSelected()) {
//                if (txt.equalsIgnoreCase("deactivate_user")) we.press(UsersPage.checkBoxDeactive);
//            }
//            return this;
//        }
//
//        public inputFields inputCalendar(String txt) {
//            String[] arr = txt.split(" ");
//            UsersPage.calendar1.click();
//            while (!UsersPage.year.getText().contains(arr[2])) {
//                goRight.click();
//            }
//            Driver.getDriver().findElement(By.xpath("//span[text()='" + arr[1] + "']")).click();
//            Driver.getDriver().findElement(By.xpath("//td[text()='" + arr[0] + "'] [@class='day '] "));
//            return this;
//        }
//
//        public inputFields inputSubmitUser() {
//            we.press(submitUser);
//            return this;
//        }
//
//        public inputFields uploadPic(String txt) {
//            we.fileupload(upload, txt);
//            we.press(fileapply);
//            return this;
//        }
//
//        public inputFields cancel() {
//            we.press(cancelbtn);
//            Driver.getDriver().navigate().to("https://nna.talentlms.com/user/index");
//            return this;
//        }
//
//
//    }
}

