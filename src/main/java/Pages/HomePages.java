package Pages;

import Moduls.Utilities.HandleExceptions;
import UI.UiActions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

/**
 * navigate in facebook home page and search about friend in search bar in the top of page
 */
public class HomePages {
	

	UiActions action = new UiActions();

    String userPath = "//div[@class='_6rbb']//a[contains(.,'%s')]";

	
	 By searchBar = By.xpath("//input[@type='text' and @name='q']");


    /**
     *  write friend name and find friend's account
     * @param userNameText
     */
  public void navigateToVictimProfile(String userNameText) {
      /**
       * find friend name
       */
      By victim = By.xpath(String.format(userPath, userNameText));

      try {


          action.waitFunction(searchBar, "waitVisibility");
          action.findElement(searchBar).sendKeyToElement(userNameText)
                  .actionOnElement("submit");

          action.waitFunction(victim, "waitVisibility");
          action.findElement(victim).actionOnElement("click");


      } catch (ElementNotInteractableException e) {
          HandleExceptions.ElementNotInteractableExceptionHandling(e);
      }


  }
	

}
