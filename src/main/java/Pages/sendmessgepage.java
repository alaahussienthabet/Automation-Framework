package Pages;


import java.util.concurrent.TimeUnit;
import Actions.UiActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class sendmessgepage {

	UiActions action = new UiActions();



	By messagebutton = By.xpath("//div[@class='actions _70j']//a[@role='button' and contains(text(),'Message')]");
	By sendmessagecontent = By.xpath("//div[@role=\"presentation\"]//div[@class=\"_5rpb\"]//div[@role=\"combobox\"]");


	    

    public void PressOnMessageButton( ){


 action.waitfunction(40);
        action.findelemnt(messagebutton).actiononelement("opennewtab");

	    }
    
    public void SendMultipleMessages(String messageContent){

        action.waitfunction(40);
        for (int i = 0; i <100 ; i++) {

           action.findelemnt(sendmessagecontent).sendkeytoelement(messageContent)
           .actiononelement("enter");

        }

    }

}
