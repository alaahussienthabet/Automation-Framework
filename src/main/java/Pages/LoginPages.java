package Pages;


import UI.UiActions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

/**
 * login in facebook with username and password
 */
public class LoginPages {

    UiActions action = new UiActions();

    By userfield = By.xpath("//input[@class='inputtext login_form_input_box' and @data-testid=\"royal_email\"]");
    By passwordfield = By.xpath("//input[@class='inputtext login_form_input_box' and @data-testid=\"royal_pass\"]");
    By loginbutton = By.xpath("//input[ @data-testid=\"royal_login_button\"]");




    /**
     * login with username and password
     * @param username
     * @param password
     */
    public void login(String username, String password) {

        try {


            action.findElement(userfield).sendKeyToElement(username).findElement(passwordfield)
                    .sendKeyToElement(password).findElement(loginbutton).actionOnElement("click");
        } catch (ElementNotInteractableException e) {//nehal
            System.out.println("Unable to locate elements");
        }
    }
}
