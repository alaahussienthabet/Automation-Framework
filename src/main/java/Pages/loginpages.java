package Pages;



import Actions.UiActions;
import org.openqa.selenium.By;


public class loginpages {

	UiActions action = new UiActions();
	String click;
	By userfield = By.xpath("//input[@class='inputtext login_form_input_box' and @data-testid=\"royal_email\"]");
	By passwordfield = By.xpath("//input[@class='inputtext login_form_input_box' and @data-testid=\"royal_pass\"]");
	By loginbutton= By.xpath("//input[ @data-testid=\"royal_login_button\"]");
	



	public void login(String user,String pass)
	{


		 action.findelemnt(userfield).sendkeytoelement(user).findelemnt(passwordfield)
				 .sendkeytoelement(pass).findelemnt(loginbutton).actiononelement("click");
	
}}
