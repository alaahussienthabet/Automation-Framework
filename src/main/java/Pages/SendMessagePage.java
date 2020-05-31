package Pages;


import UI.UiActions;
import org.openqa.selenium.By;


public class SendMessagePage {

    UiActions action = new UiActions();


    By messagebutton = By.xpath("//div[@class='actions _70j']//a[@role='button' and contains(text(),'Message')]");
    By sendmessagecontent = By.xpath("//div[@role=\"presentation\"]//div[@class=\"_5rpb\"]//div[@role=\"combobox\"]");


    public void pressOnMessageButton() {


        action.waitFunction(40);
        //press message button
        action.findElement(messagebutton).actionOnElement("opennewtab");

    }
        // send multiple message to friend
    public void sendMultipleMessages(String messageContent) {

        action.waitFunction(40);
        for (int i = 0; i < 50; i++) {

            action.findElement(sendmessagecontent).sendKeyToElement(messageContent)
                    .actionOnElement("enter");

        }

    }

}
