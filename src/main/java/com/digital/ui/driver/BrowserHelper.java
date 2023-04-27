package com.digital.ui.driver;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {
    WebDriver driver = Driver.getDriver();

    public void open(final String URL){
        driver.navigate().to(URL);
    }

    public void goBack(){
        driver.navigate().forward();
    }

    public  void goForward(){
        driver.navigate().refresh();
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    public void switchToWindow(int index){
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




}
