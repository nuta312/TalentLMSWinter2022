package com.digital.ui.pages;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks extends BasePage{

    WebDriver driver = Driver.getDriver();

    String frame = "div[contains(@class,'col-12 mt-4 col-md-6')]/div[2]";




    public List<String> getLinks() {
        List<WebElement> lo = driver.findElements(By.xpath("//"+frame+"//a"));
        List<String> urlList = new ArrayList<>();
            for (WebElement e : lo) {
                String url = e.getAttribute("href");
                if(url != null) {
                    urlList.add(url);
                }
            }
        System.out.println("Total links " + urlList.size());
            return urlList;
    }

    public void getImg() {
        List<WebElement> lo = driver.findElements(By.xpath("//"+frame+"//img"));
        for (WebElement e : lo) {
            if(e.getAttribute("naturalWidth").equals("0")) {
                System.out.println("Image " + e.getAttribute("src") + "   broken IMG");
            }else{
                System.out.println("Image " + e.getAttribute("src") + "   visible");
            }
        }
    }

    public void checkLinks() {
    try{
        List<String> lu = getLinks();
            for (String ur: lu) {
                URL url = new URL(ur);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() >= 400) {
                    System.out.println(ur + "  " + httpURLConnection.getResponseMessage() + " is broken link");
                        } else {
                        System.out.println((ur + " valid link"));
                    }
                }
            }catch (IOException e){
        }
    }
}

