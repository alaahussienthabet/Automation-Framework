package FacebookTests;



import Pages.HomePages;
import Pages.LoginPages;
import Pages.SendMessagePage;
import Moduls.FilesReaders.PropertyFileReader;


import org.testng.annotations.Test;


public class TestFileReaderProperties extends BaseClass{


    LoginPages log = new LoginPages();
    HomePages home = new HomePages();
    SendMessagePage send = new SendMessagePage();
    String username;
    String password;




    // data reader from properties file
    @Test
    public void openFacebookAndLoginByFileProperty() {

        String[] filedata = PropertyFileReader.propertiesFileReader(new String[]{username, password});
        log.login(filedata[0], filedata[1]);


    }



    @Test
    public void searchForUser() {


        home.navigateToVictimProfile("Friend_name");
        send.pressOnMessageButton();
        send.sendMultipleMessages("your_massage");

    }






}
