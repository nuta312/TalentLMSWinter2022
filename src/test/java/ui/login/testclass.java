
//package ui.login;

//import com.digital.ui.data;
//import com.digital.ui.driver.Driver;
//import com.digital.ui.element_helper.WebElementActions;
//import com.digital.ui.pages.BasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.digital.ui.driver.Driver.getDriver;
//
//public class testclass extends WebElementActions{
//
//    WebElementActions we=new WebElementActions();
//    @FindBy(xpath = "//input[@name='name']") public WebElement firstname;
//    @FindBy(xpath = "//input[@name = 'submit_personal_details']")public WebElement submitUser;
//    @Test
//    public void test(){
//        //WebElement element=(new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))).until(ExpectedConditions.presenceOfNestedElementLocatedBy();
//        //Driver.getDriver().findElement(By.xpath("//input[@name = 'submit_personal_details']"));
//        String name="SAMAT";
////        String longName="SAMATSAMATSAMATSAMATSAMATSAMATSAMATSAMATSAMATSAMATSAMATSAMATSAMATSAMATSAMAT";
////        String ecxeed="'First name' cannot exceed 50 characters";
////        String empty="'First name' is required";
//        PageFactory.initElements(getDriver(),this);
//        firstname.sendKeys(name);
//        inputSubmitUser();
//        Assert.assertTrue(firstname.isDisplayed());
//        //Assert.assertEquals(firstname.getText(),name);
//    }
//    @Test(description = "get access to USERS and check user name surname email")
//    public static void users()  throws IOException {
//        Driver.getDriver().navigate().to(data.URLUSER.getUserInfo());
//        WebElement table = (WebElement) Driver.getDriver().findElement(By.id("tl-users-grid"));
//        List<WebElement> rows = table.findElements(By.tagName("tr"));
//        ArrayList listOfUsers = new ArrayList();
//        Object [][] l=new Object[listOfUsers.size()/7][7];
//        Actions action =new Actions(Driver.getDriver());
//        for (WebElement row : rows) {
//            List<WebElement> cells = row.findElements(By.tagName("td"));
//            for (WebElement cell : cells) {
//                System.out.println(cell.getText());
//                }
//        }
//        String usernameForLink=data.NAME.getUserInfo()+"."+data.SURNAME.getUserInfo();
//     WebElement userlink=Driver.getDriver().findElement(By.xpath("//a [@data-original-title='Username: "+usernameForLink+"']"));
//     userlink.click();
//     WebElement username=Driver.getDriver().findElement(By.xpath("//input [@name='name']"));
//     WebElement usersurname=Driver.getDriver().findElement(By.xpath("//input [@name='surname']"));
//     WebElement useremail=Driver.getDriver().findElement(By.xpath("//input [@name='email']"));
//     Assert.assertEquals(data.NAME.getUserInfo(),username.getAttribute("value"));
//     Assert.assertEquals(data.SURNAME.getUserInfo(),usersurname.getAttribute("value"));
//     Assert.assertEquals(data.EMAIL.getUserInfo(),useremail.getAttribute("value"));
//
//    }
//    @DataProvider
//    public static Object[][]ss(){
//        return new Object[][]{
//                {}
//        };
//    }
////        Document doc = Jsoup.connect("file:///C:/Users/user/Downloads/%D0%9D%D0%BE%D0%B2%D0%B0%D1%8F%20%D0%BF%D0%B0%D0%BF%D0%BA%D0%B0%20(2)/nna%20_%20Users.html").get();
////        Element table = doc.select("table").first();
////        ArrayList<ArrayList<String>> masterList = new ArrayList<ArrayList<String>>();
////
////        for (Element row : table.select("tr")) {
////            ArrayList<String> rowData = new ArrayList<String>();
////            for (Element cell : row.select("td")) {
////                rowData.add(cell.text());
////            }
////            masterList.add(rowData);
////        }
////        System.out.println(masterList);
//
//
////        Element table=
////
////        //for (Element row :)
////        String html="<table id=\"tl-users-grid\" class=\"table grid-striped dataTable no-footer\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" role=\"grid\" aria-describedby=\"tl-users-grid_info\" style=\"width: 100%; visibility: visible;\">\n" +
////                "\t\t\t<thead>\n" +
////                "\t\t\t\t<tr role=\"row\"><th class=\"tl-align-center tl-grid-checkbox-wrapper hidden-phone sorting_disabled\" rowspan=\"1\" colspan=\"1\" aria-label=\"\" style=\"width: 13px;\"><input id=\"tl-grid-checkbox-all\" type=\"checkbox\"></th><th class=\"tl-align-left sorting\" tabindex=\"0\" aria-controls=\"tl-users-grid\" rowspan=\"1\" colspan=\"1\" aria-label=\"User\" style=\"width: 213px;\">User</th><th class=\"tl-align-left hidden-phone sorting\" tabindex=\"0\" aria-controls=\"tl-users-grid\" rowspan=\"1\" colspan=\"1\" aria-label=\"Email\" style=\"width: 283px;\">Email</th><th class=\"tl-align-left hidden-phone sorting\" tabindex=\"0\" aria-controls=\"tl-users-grid\" rowspan=\"1\" colspan=\"1\" aria-label=\"User type\" style=\"width: 179px;\">User type</th><th class=\"tl-align-center hidden-phone sorting\" tabindex=\"0\" aria-controls=\"tl-users-grid\" rowspan=\"1\" colspan=\"1\" aria-label=\"Registration\" style=\"width: 134px;\">Registration</th><th class=\"tl-align-center hidden-phone sorting\" tabindex=\"0\" aria-controls=\"tl-users-grid\" rowspan=\"1\" colspan=\"1\" aria-label=\"Last login\" style=\"width: 133px;\">Last login</th><th class=\"tl-align-center tl-table-operations-cell sorting_disabled\" rowspan=\"1\" colspan=\"1\" aria-label=\"Options\" style=\"\">Options</th></tr>\n" +
////                "\t\t\t</thead>\n" +
////                "\t\t\t<tbody>\n" +
////                "\t\t\t\t\n" +
////                "\t\t\t<tr role=\"row\" class=\"odd\"><td class=\" tl-align-center tl-grid-checkbox-wrapper hidden-phone\"><input type=\"checkbox\" aria-checked=\"unchecked\" aria-label=\"\" class=\"hidden-mobile tl-grid-checkbox\" id=\"\" value=\"on\" data-id=\"17\"></td><td class=\" tl-align-left\"><a class=\"tl-tool-tip\" rel=\"tooltip\" title=\"\" href=\"https://nna.talentlms.com/user/info/id:17\" data-original-title=\"Username: jaymie.goldner\"><span title=\"A. Ryan (jaymie.goldner)\">A. Ryan</span></a></td><td class=\" tl-align-left hidden-phone\"><span title=\"jaymie.goldner@gmail.com\">jaymie.goldner@gmail.com</span></td><td class=\" tl-align-left hidden-phone\"><span title=\"Trainer-Type\">Trainer-Type</span></td><td class=\" tl-align-center hidden-phone\">1 hour ago</td><td class=\" tl-align-center hidden-phone\">-</td><td class=\" tl-align-center tl-table-operations-cell\"><div class=\"tl-table-operations-trigger touchable\"><i class=\"icon-ellipsis-h tl-table-operations-icon\"></i><div class=\"tl-table-operations touchable\"><i class=\"icon-signal icon-grid\" alt=\"Reports\" title=\"Reports\" onclick=\"location='https://nna.talentlms.com/reports/userinfo/id:17'\"></i>&nbsp;<i class=\"icon-signin icon-grid tl-autologin-touser\" alt=\"Log into account\" title=\"Log into account\" data-id=\"17\"></i>&nbsp;<i class=\"icon-pencil icon-grid\" alt=\"Edit\" title=\"Edit\" onclick=\"location='https://nna.talentlms.com/user/info/id:17'\"></i>&nbsp;<i class=\"icon-remove icon-grid\" alt=\"Delete\" title=\"Delete\" onclick=\"myportal.app.confirm(decodeURIComponent('Delete%20User%3F'), decodeURIComponent('%3Cp%3EAre%20you%20sure%20you%20want%20to%20delete%20the%20user%20%3Cb%3E%3Cspan%20title%3D%27A.%20Ryan%27%3EA.%20Ryan%3C%2Fspan%3E%3C%2Fb%3E%3F%3C%2Fp%3E'), myportal.grid.deleteRow, this)\" data-action=\"https://nna.talentlms.com/user/delete/id:17\"></i></div></div></td></tr><tr role=\"row\" class=\"even\"><td class=\" tl-align-center tl-grid-checkbox-wrapper hidden-phone\"><input type=\"checkbox\" aria-checked=\"unchecked\" aria-label=\"\" class=\"hidden-mobile tl-grid-checkbox\" id=\"\" value=\"on\" data-id=\"16\"></td><td class=\" tl-align-left\"><a class=\"tl-tool-tip\" rel=\"tooltip\" title=\"\" href=\"https://nna.talentlms.com/user/info/id:16\" data-original-title=\"Username: bernardine.shields\"><span title=\"K. Price (bernardine.shields)\">K. Price</span></a></td><td class=\" tl-align-left hidden-phone\"><span title=\"bernardine.shields@yahoo.com\">bernardine.shields@yahoo.com</span></td><td class=\" tl-align-left hidden-phone\"><span title=\"Trainer-Type\">Trainer-Type</span></td><td class=\" tl-align-center hidden-phone\">Yesterday</td><td class=\" tl-align-center hidden-phone\">-</td><td class=\" tl-align-center tl-table-operations-cell\"><div class=\"tl-table-operations-trigger touchable\"><i class=\"icon-ellipsis-h tl-table-operations-icon\"></i><div class=\"tl-table-operations touchable\"><i class=\"icon-signal icon-grid\" alt=\"Reports\" title=\"Reports\" onclick=\"location='https://nna.talentlms.com/reports/userinfo/id:16'\"></i>&nbsp;<i class=\"icon-signin icon-grid tl-autologin-touser\" alt=\"Log into account\" title=\"Log into account\" data-id=\"16\"></i>&nbsp;<i class=\"icon-pencil icon-grid\" alt=\"Edit\" title=\"Edit\" onclick=\"location='https://nna.talentlms.com/user/info/id:16'\"></i>&nbsp;<i class=\"icon-remove icon-grid\" alt=\"Delete\" title=\"Delete\" onclick=\"myportal.app.confirm(decodeURIComponent('Delete%20User%3F'), decodeURIComponent('%3Cp%3EAre%20you%20sure%20you%20want%20to%20delete%20the%20user%20%3Cb%3E%3Cspan%20title%3D%27K.%20Price%27%3EK.%20Price%3C%2Fspan%3E%3C%2Fb%3E%3F%3C%2Fp%3E'), myportal.grid.deleteRow, this)\" data-action=\"https://nna.talentlms.com/user/delete/id:16\"></i></div></div></td></tr><tr role=\"row\" class=\"odd\"><td class=\" tl-align-center tl-grid-checkbox-wrapper hidden-phone\"><input type=\"checkbox\" aria-checked=\"unchecked\" aria-label=\"\" class=\"hidden-mobile tl-grid-checkbox\" id=\"\" value=\"on\" data-id=\"15\"></td><td class=\" tl-align-left\"><a class=\"tl-tool-tip\" rel=\"tooltip\" title=\"\" href=\"https://nna.talentlms.com/user/info/id:15\" data-original-title=\"Username: saul.heathcote\"><span title=\"K. Schiller (saul.heathcote)\">K. Schiller</span></a></td><td class=\" tl-align-left hidden-phone\"><span title=\"saul.heathcote@yahoo.com\">saul.heathcote@yahoo.com</span></td><td class=\" tl-align-left hidden-phone\"><span title=\"Trainer-Type\">Trainer-Type</span></td><td class=\" tl-align-center hidden-phone\">Yesterday</td><td class=\" tl-align-center hidden-phone\">-</td><td class=\" tl-align-center tl-table-operations-cell\"><div class=\"tl-table-operations-trigger touchable\"><i class=\"icon-ellipsis-h tl-table-operations-icon\"></i><div class=\"tl-table-operations touchable\"><i class=\"icon-signal icon-grid\" alt=\"Reports\" title=\"Reports\" onclick=\"location='https://nna.talentlms.com/reports/userinfo/id:15'\"></i>&nbsp;<i class=\"icon-signin icon-grid tl-autologin-touser\" alt=\"Log into account\" title=\"Log into account\" data-id=\"15\"></i>&nbsp;<i class=\"icon-pencil icon-grid\" alt=\"Edit\" title=\"Edit\" onclick=\"location='https://nna.talentlms.com/user/info/id:15'\"></i>&nbsp;<i class=\"icon-remove icon-grid\" alt=\"Delete\" title=\"Delete\" onclick=\"myportal.app.confirm(decodeURIComponent('Delete%20User%3F'), decodeURIComponent('%3Cp%3EAre%20you%20sure%20you%20want%20to%20delete%20the%20user%20%3Cb%3E%3Cspan%20title%3D%27K.%20Schiller%27%3EK.%20Schiller%3C%2Fspan%3E%3C%2Fb%3E%3F%3C%2Fp%3E'), myportal.grid.deleteRow, this)\" data-action=\"https://nna.talentlms.com/user/delete/id:15\"></i></div></div></td></tr><tr role=\"row\" class=\"even\"><td class=\" tl-align-center tl-grid-checkbox-wrapper hidden-phone\"><input type=\"checkbox\" aria-checked=\"unchecked\" aria-label=\"\" class=\"hidden-mobile tl-grid-checkbox\" id=\"\" value=\"on\" data-id=\"1\"></td><td class=\" tl-align-left\"><a class=\"tl-tool-tip\" rel=\"tooltip\" title=\"\" href=\"https://nna.talentlms.com/user/info/id:1\" data-original-title=\"Username: samatelikbaev\"><span title=\"S. Samat (samatelikbaev)\">S. Samat</span></a></td><td class=\" tl-align-left hidden-phone\"><span title=\"citizenkg@gmail.com\">citizenkg@gmail.com</span></td><td class=\" tl-align-left hidden-phone\"><span title=\"SuperAdmin\">SuperAdmin</span></td><td class=\" tl-align-center hidden-phone\">15/04/2023</td><td class=\" tl-align-center hidden-phone\">just now</td><td class=\" tl-align-center tl-table-operations-cell\"><div class=\"tl-table-operations-trigger touchable\"><i class=\"icon-ellipsis-h tl-table-operations-icon\"></i><div class=\"tl-table-operations touchable\"><i class=\"icon-signal icon-grid\" alt=\"Reports\" title=\"Reports\" onclick=\"location='https://nna.talentlms.com/reports/userinfo/id:1'\"></i>&nbsp;<i class=\"icon-pencil icon-grid\" alt=\"Edit\" title=\"Edit\" onclick=\"location='https://nna.talentlms.com/user/info/id:1'\"></i></div></div></td></tr></tbody>\n" +
////                "\t\t</table>";
////        //List<WebElement>list=Driver.getDriver().findElements(By.xpath(html));
////        //System.out.println("salam  "+list.toString());
////        Document document =Jsoup.parse(html);
//
//
////        try{
////
////            System.out.println("parse works");
////            Element row=document.select("tr").first();
////            System.out.println("element row first works");
////            List<String> rowData=new ArrayList<>();
////            if(row!=null){
////                Elements cells=row.select("td");
////                System.out.println(cells);
////                for (Element cell :cells){
////                    rowData.add(cell.text());
////                    System.out.println("rowdata add cell.text works");
////                }
////            }
////            System.out.println(rowData);
////        }
////        catch (Exception e){e.printStackTrace();}
//    @BeforeTest(description = "opens website, get access, enters till users")
//        public void starting() {
//            getDriver().navigate().to("https://www.talentlms.com/");
//            WebElement element= getDriver().findElement(By.xpath("/html/body/header/nav/div/div/div[2]/ul/li[1]/a"));
//            we.press(element);
//            WebElement domenfield= getDriver().findElement(By.xpath("//input[@name='domain']"));
//        we.input(domenfield,"nna");
//        WebElement login= getDriver().findElement(By.xpath("//input[@name='login']"));
//        we.input(login,"samatelikbaev");
//        WebElement password= getDriver().findElement(By.xpath("//input[@name='password']"));
//        we.input(password,"36654299");
//        WebElement log= getDriver().findElement(By.xpath("//*//input[@name='submit']"));
//        we.press(log);
//        WebElement ch= getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/div[2]/div[4]/a"));
//        we.press(ch);
//
//        }
//        @Test(description = "get access into addd user and fill fields and submit")
//        public void adduser(){
//            WebElement adduserbtn= getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/a"));
//            we.press(adduserbtn);
//            BasePage.Users.adduser();
//        }
//    public testclass inputSubmitUser(){
//        we.press(submitUser);
//        return this;
//    }
//
//}
