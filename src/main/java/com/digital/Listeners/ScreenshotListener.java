package com.digital.Listeners;


import com.digital.ui.driver.Driver;
import com.digital.ui.driver.FirefoxWebDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class ScreenshotListener extends TestListenerAdapter {

//    private boolean createFile(File screenshot) {
//        boolean fileCreated = false;
//
//        if (screenshot.exists()) {
//            fileCreated = true;
//        } else {
//            File parentDirectory = new File(screenshot.getParent());
//            if (parentDirectory.exists() || parentDirectory.mkdirs()) {
//                try {
//                    fileCreated = screenshot.createNewFile();
//                } catch (IOException errorCreatingScreenshot) {
//
//                }
//            }
//        }
//
//        return fileCreated;
//    }
//
//    private void writeScreenshotToFile(WebDriver driver, File screenshot) {
//        try {
//            FileOutputStream screenshotStream = new FileOutputStream(screenshot);
//            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
//            screenshotStream.close();
//        } catch (IOException unableToWriteScreenshot) {
//
//        }
//    }
//
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] saveScreenshot(byte[] screenShot) {
//        return screenShot;
//    }
//
//    @Attachment(value = "Text file attachment", type = "text/plain")
//    public byte[] attachTextFile() {
//        // Здесь производится чтение файла и возврат его содержимого в виде массива байт
//        String filePath = "path/to/text/file.txt";
//        try {
//            return Files.readAllBytes(Paths.get(filePath));
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public void onTestFailure(ITestResult failingTest) {
//        try {
//            WebDriver driver = Driver.getDriver();
//            String screenshotDirectory = System.getProperty("screenshotDirectory", "target/allure-results");
//            String screenshotAbsolutePath = screenshotDirectory + File.separator + System.currentTimeMillis() + "_" + failingTest.getName() + ".png";
//            File screenshot = new File(screenshotAbsolutePath);
//            if (createFile(screenshot)) {
//                try {
//                    writeScreenshotToFile(driver, screenshot);
//                    attachTextFile();
//                } catch (ClassCastException weNeedToAugmentOurDriverObject) {
//                    writeScreenshotToFile(new Augmenter().augment(driver), screenshot);
//
//                }
//
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
// Text attachments for Allure
@Attachment(value = "{0}", type = "text/plain")
public static String saveTextLog(String message) {
    return message;
}

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void onTestFailure(ITestResult Result) {
        saveScreenshotPNG();
        saveTextLog(Result.getMethod().getConstructorOrMethod().getName() + "Screenshot Saved.");
    }
}