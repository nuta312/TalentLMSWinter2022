package com.digital.ui.driver;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {
<<<<<<< HEAD

    WebDriver driver = Driver.getDriver();


=======
    WebDriver driver = Driver.getDriver();

>>>>>>> origin/AigerimDzh
    public void open(final String URL){
        driver.navigate().to(URL);
    }

    public void goBack(){
<<<<<<< HEAD
        driver.navigate().back();
    }

    public void goForward(){
        driver.navigate().forward();
=======
        driver.navigate().forward();
    }

    public  void goForward(){
        driver.navigate().refresh();
>>>>>>> origin/AigerimDzh
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    public void switchToWindow(int index){
<<<<<<< HEAD
        LinkedList<String> windowId = new LinkedList<>(getWindowHandles());

        if (index < 0 || index > windowId.size())
            throw new IllegalArgumentException("Invalid index: " + index);

        driver.switchTo().window(windowId.get(index));

    }


    public void switchToParentWindow(){

        LinkedList<String> windowId = new LinkedList<>(getWindowHandles());

        driver.switchTo().window(windowId.get(0));
    }

=======
        LinkedList<String> windowID = new LinkedList<>(getWindowHandles());

        if(index < 0 || index > windowID.size()){
            throw new IllegalArgumentException("invalid index" + index);
        }

        driver.switchTo().window(windowID.get(index));
    }

    public void switchToParentWindow(){
        LinkedList<String> windowID = new LinkedList<>(getWindowHandles());
        driver.switchTo().window(windowID.get(0));
    }




>>>>>>> origin/AigerimDzh
}
