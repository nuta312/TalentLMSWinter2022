package com.digital.ui.pages.UserPage;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FilesPage extends BasePage {

    WebElementActions elementActions = new WebElementActions();
    Actions actions = new Actions(Driver.getDriver());


   @FindBy(xpath = "//input[contains(@name,'files[]')]")
   public WebElement files;

   @FindBy(id = "tl-confirm-submit")
   public WebElement confirmDelete;

   @FindBy(id = "tl-confirm")
   public WebElement confirmDialog;

   @FindBy(id = "tl-rename-file-modal")
   public WebElement EditDialog;

   @FindBy(id = "renameFileName")
   public WebElement renameFileInDialog;

   @FindBy(id = "show-tags")
   public WebElement showTags;

   @FindBy(xpath = "//input[contains(@class,'select2-input')]")
   public WebElement inputTags;

   @FindBy(id = "counter-renameFileName")
   public WebElement counterRenameFile;

   @FindBy(id = "select2-drop")
   public WebElement selectTagForm;

   @FindBy(xpath = "//input[contains(@value,'Update')]")
   public WebElement updateFileOptinos;

   @FindBy(id = "#tl-hide-rename-file-modal")
   public WebElement cancelFileOptions;

   public FilesPage uploadFile(String path) throws InterruptedException {
       files.sendKeys(path);
       Thread.sleep(5000);
       return this;
   }

   public FilesPage userViewChangeNotView(String fileName) throws InterruptedException {
       WebElement userCanView = Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]//a[contains(text(),'User can view that file')]"));
        elementActions.press(userCanView);
        WebElement changeView = Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]//div[contains(@class,'tl-user-file-visibility-type')]"));
        elementActions.press(changeView);
       return this;
   }

    public FilesPage userNotViewChangeView(String fileName) throws InterruptedException {
        WebElement userCanView = Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]//a[contains(text(),'User cannot view that file')]"));
        elementActions.press(userCanView);
        WebElement changeView = Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]//div[contains(@class,'tl-user-file-visibility-type')]"));
        elementActions.press(changeView);
        return this;
    }


    public FilesPage previewFile(String fileName){
       try{
           actions.moveToElement(Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]"))).moveToElement(Driver.getDriver().findElement(By.xpath("//a[contains(@class,'icon-doc-alt-1 icon-grid modal-preview none-decoration')]"))).click().perform();
           return this;
       } catch (NoSuchElementException e){
           System.out.println("Тип файла не позволяет выполнить предпросмотр");
           return null;
       }
    }

    public FilesPage downloadFile(String fileName){
       try {
           actions.moveToElement(Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]"))).perform();
           actions.moveToElement(Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]//a[contains(@title,'Download')]"))).click().perform();
           return this;
       } catch (NoSuchElementException e){
           System.out.println("Загрузка не выполнена");
           return null;
       }
    }

    public FilesPage deleteFile(String fileName){
       try {
           actions.moveToElement(Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]"))).perform();
           WebElement deleteBtn = Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]//i[contains(@title,'Delete')]"));
           actions.moveToElement(deleteBtn).click().perform();

           new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5))
                   .until(ExpectedConditions.visibilityOf(confirmDialog));

           actions.moveToElement(confirmDelete).click().perform();
           Thread.sleep(3000);
           return this;
       } catch (NoSuchElementException e){
           System.out.println("Такого файла нету");
           return null;
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
    }

    public FilesPage editFile(String fileName,String tags){
       try {
           actions.moveToElement(Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]"))).perform();
           WebElement deleteBtn = Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]//i[contains(@alt,'Edit file')]"));
           actions.moveToElement(deleteBtn).click().perform();
           renameFile("Digital");
           inputTags(tags);
           elementActions.press(updateFileOptinos);


           return this;
       } catch (NoSuchElementException e){
           System.out.println("Такого файла нету");
           return null;
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }

    }

    public FilesPage renameFile (String fileRename){
       elementActions.input(this.renameFileInDialog,fileRename);
       return this;
    }

    public FilesPage inputTags (String tags) throws InterruptedException {
       showTags.click();
       String [] tagsArr = tags.split(",");

       for(String tag: tagsArr) {
           elementActions.input(inputTags, tag);
           List<WebElement> divs = selectTagForm.findElements(By.tagName("div"));
           for (WebElement div: divs) {
               if(div.getText().substring(0,tag.length()).equalsIgnoreCase(tag)){
                   div.click();
                   break;
               }
           }
       }
       Thread.sleep(5000);
       return this;
    }










}
