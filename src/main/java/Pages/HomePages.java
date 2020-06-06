package Pages;

import UI.UiActions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;


public class HomePages {
	

	UiActions action = new UiActions();

    String userpath = "//div[@class='_6rbb']//a[contains(.,'%s')]";

	
	 By searchbar = By.xpath("//input[@type='text' and @name='q']");
////input[@type='search']

  

  public void navigateToVictimProfile(String usernametext){
      // find friend name
      By victim = By.xpath(String.format(userpath,usernametext));

      try {

        // write friend name and find friend's account
          action.waitFunction(searchbar,"waitvisibility");
           action.findElement(searchbar).sendKeyToElement(usernametext)
          .actionOnElement("submit");

          action.waitFunction(victim,"waitvisibility");
          action.findElement(victim).actionOnElement("click");


      }
      catch (ElementNotInteractableException e)
      {
          System.out.println("Unable to locate element searchbar");
      }
      
    
  }
	

}
