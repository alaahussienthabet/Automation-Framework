package Pages;


import UI.UiActions;
import org.openqa.selenium.By;

/**
 * go to the friend profile and send massage from the popup screen massage
 */
public class SendMessagePage {

    UiActions action = new UiActions();


    By messagebutton = By.xpath("//div[@class='actions _70j']//a[@role='button' and contains(text(),'Message')]");
    By sendmessagecontent = By.xpath("//div[@role=\"presentation\"]//div[@class=\"_5rpb\"]//div[@role=\"combobox\"]");

    /**
     * to press in massage button under the profile photo of friend
     */
    public void pressOnMessageButton() {


        action.waitFunction(40);
        //press message button
        action.findElement(messagebutton).actionOnElement("openNewTab");

    }

    /**
     * send any number of massage to friend
     * @param messageContent
     */

    public void sendMultipleMessages(String messageContent, int numberOfMassages ) {

        action.waitFunction(40);
        for (int i = 0; i < numberOfMassages; i++) {

            action.findElement(sendmessagecontent).sendKeyToElement(messageContent)
                    .actionOnElement("enter");

        }

    }

}
