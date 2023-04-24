package ui.smoke;

import com.digital.annotations.TestCase;
import com.digital.ui.pages.NaziraHomework;
import io.qameta.allure.*;
import org.testng.annotations.Test;
@Epic("")
@Feature("")
public class NaziraHomeworkTest {
    NaziraHomework nz= new NaziraHomework();
    @Test(description = "Проверка функций Homepage")
    @TestCase(id = 559)
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Nazira")
    @Story("o;udfuhv;osd")
    @Link(name = ";ogjgjh;idfidg",url = "https://www.google.com/")
    public void Test1() throws InterruptedException {
        nz.openSite().authorization();
        nz.TestPage().closeSite();

    }

}
