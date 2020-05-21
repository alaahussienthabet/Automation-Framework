package Steps;

import Pages.homepages;
import Pages.loginpages;
import Pages.sendmessgepage;

import filesreaders.Excelfilereader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserLogin {




    loginpages log = new loginpages();
    homepages home =new homepages();
    sendmessgepage send = new sendmessgepage();

    @Given("The User In The Home Page")
    public void the_User_In_The_Home_Page() {
        String [][] data =  Excelfilereader.excelleader();
        log.login(data[0][0],data[0][1]);



    }
    @When("Enter User Name and Password")
    public void enter_User_Name_and_Password() {
        home.NavigateToVictimProfile("Friend_name");
    }


    @Then("The User Login Successfully and send message")
    public void the_User_Login_Successfully_and_send_message() {
        send.PressOnMessageButton();
        send.SendMultipleMessages("your_massage");
    }
}
