package facebooktests;



import Pages.homepages;
import Pages.loginpages;
import Pages.sendmessgepage;
import filesreaders.Propertyfilereader;


import org.testng.annotations.Test;


public class TestFileReaderProperties extends BaseClass{


    loginpages log = new loginpages();
    homepages home = new homepages();
    sendmessgepage send = new sendmessgepage();
    String username;
    String password;




    // data reader from properties file
    @Test
    public void OpenFacebookAndLoginbyfileproperty() {

        String[] filedata = Propertyfilereader.properitesfilereader(new String[]{username, password});
        log.login(filedata[0], filedata[1]);


    }


    @Test
    public void SearchForUser() {


        home.NavigateToVictimProfile("Friend_name");
        send.PressOnMessageButton();
        send.SendMultipleMessages("your_massage");

    }






}
