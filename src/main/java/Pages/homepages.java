package Pages;

import Actions.UiActions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

import org.openqa.selenium.WebElement;


public class homepages {
	

	UiActions action = new UiActions();

    String userpath = "//div[@class='_6rbb']//a[contains(.,'%s')]";

	
	 By searchbar = By.xpath("//input[@type='search']");


  

  public void NavigateToVictimProfile(String usernametext){
      By victim = By.xpath(String.format(userpath,usernametext));

      try {


          action.waitfunction(searchbar,"waitvisavlity");
           action.findelemnt(searchbar).sendkeytoelement(usernametext)
          .actiononelement("submit");

          action.waitfunction(victim,"waitvisavlity");
          action.findelemnt(victim).actiononelement("click");


      }
      catch (ElementNotInteractableException e)
      {
          System.out.println("Unable to locate element searchbar");
      }
      
    
  }
	

}
