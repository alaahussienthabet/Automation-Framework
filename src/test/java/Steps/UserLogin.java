package Steps;

import Pages.HomePages;
import Pages.LoginPages;
import Pages.SendMessagePage;

import Moduls.FilesReaders.ExcelFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLogin {




    LoginPages log = new LoginPages();
    HomePages home =new HomePages();
    SendMessagePage send = new SendMessagePage();

    @Given("The User In The Home Page")
    public void the_User_In_the_Home_Page() {
        String [][] data =  ExcelFileReader.excelReader("src//test//resources//DataDriven//credentials.xlsx");
        log.login(data[0][0],data[0][1]);



    }
    String [][] testData =  ExcelFileReader.excelReader("src//test//resources//DataDriven//testData.xlsx");

    @When("Enter User Name and Password")
    public void enter_User_Name_And_Password() {
        home.navigateToVictimProfile(testData[0][0]);
    }


    @Then("The User Login Successfully and send message")
    public void the_User_Login_Successfully_And_Send_Message() {
        send.pressOnMessageButton();
        send.sendMultipleMessages(testData[0][1],20);
    }
}
