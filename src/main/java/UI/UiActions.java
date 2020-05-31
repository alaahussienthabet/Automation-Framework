package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UiActions {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private  WebElement element;


//wait until function
public void waitFunction(By path , String typ){
       switch (typ){
           case "waitvisibility" :

               wait.until(ExpectedConditions.visibilityOfElementLocated(path));
           break;
           case "waitclick":
               wait.until(ExpectedConditions.elementToBeClickable(path));
               break;
       }
   }
    // wait by specific time
    public void waitFunction(int time){

       driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    // to find element and return it
    public UiActions findElement(By path){
        element = driver.findElement(path);
       return this;

    }
    // to write in fields
    public UiActions sendKeyToElement(String text){
       element.sendKeys(text);
       return this;

    }
    // to make actions on element
    public void actionOnElement(String action){
      switch (action)
{
    case "submit" :
        element.submit();
        break;
    case "click" :
        element.click();
        break;
    case "opennewtab":
        Actions builder = new Actions(driver);
        Action openLinkInNewTab = builder
                .sendKeys(element, Keys.CONTROL).clickAndHold().keyUp(element,Keys.CONTROL)
                .build();
        openLinkInNewTab.perform();
        builder.sendKeys(Keys.CONTROL+"\t").click(element).build().perform();
        break;
    case "enter" :
        element.sendKeys(Keys.ENTER);
    }}




}
