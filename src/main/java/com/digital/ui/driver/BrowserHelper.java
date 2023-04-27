package com.digital.ui.driver;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {
    WebDriver driver = Driver.getDriver();


    public void open(final String url){
        driver.navigate().to(url);
    }

    public void back(){
        driver.navigate().back();
    }

    public void forward(){
        driver.navigate().forward();
    }
    public void refresh(){
        driver.navigate().refresh();
    }

    public Set<String> getWindowHandles(){
       return driver.getWindowHandles();
    }


   public void switchToWindow(int index){
        LinkedList<String> windowId = new LinkedList<>(getWindowHandles());
        if(index < 0 || index > windowId.size())
            throw new IllegalArgumentException("Invalid index " + index);
        driver.switchTo().window(windowId.get(index));
   }

    public void switchToParentWindow() {
        LinkedList<String> windowId = new LinkedList<>(
                getWindowHandles());
        driver.switchTo().window(windowId.get(0));
    }
}
