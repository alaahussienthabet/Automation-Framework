package facebooktests;


import Modul.Screenshot.ScreenShots;
import Pages.homepages;
import Pages.loginpages;
import Pages.sendmessgepage;

import filesreaders.Excelfilereader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestFileReaderExcel extends BaseClass {


    loginpages log = new loginpages();
    homepages home =new homepages();
    sendmessgepage send = new sendmessgepage();
    ScreenShots screenShots = new ScreenShots();





    @DataProvider(name = "reader")
    public Object[][] getDataFromDataprovider() {
        return Excelfilereader.excelleader();
    }

    @Test(dataProvider = "reader")
    @Severity(SeverityLevel.CRITICAL)
   // @Link(name = "screenshot",url="localhost.//ScreenShot//")
            //"https://eyes.applitools.com/app/test-results")
    public void OpenFacebookAndLoginbyfileexcel(String username, String password) {

        log.login(username, password);
        screenShots.intialeyes();
        screenShots.windowscreenshot();


    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void SearchForUser() {


        home.NavigateToVictimProfile("Friend_name");
        send.PressOnMessageButton();
        send.SendMultipleMessages("your_massage");
        screenShots.intialeyes();
        screenShots.windowscreenshot();






    }
}
