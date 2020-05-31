package Pages;


import Actions.UiActions;
import org.openqa.selenium.By;


public class sendmessgepage {

	UiActions action = new UiActions();



	By messagebutton = By.xpath("//div[@class='actions _70j']//a[@role='button' and contains(text(),'Message')]");
	By sendmessagecontent = By.xpath("//div[@role=\"presentation\"]//div[@class=\"_5rpb\"]//div[@role=\"combobox\"]");


	    

    public void PressOnMessageButton( ){


 action.waitfunction(40);
        action.findelement(messagebutton).actiononelement("opennewtab");

	    }
    
    public void SendMultipleMessages(String messageContent){

        action.waitfunction(40);
        for (int i = 0; i <100 ; i++) {

           action.findelement(sendmessagecontent).sendkeytoelement(messageContent)
           .actiononelement("enter");

        }

    }

}
