package FacebookTests;


import Moduls.ScreenShotModul.ScreenShots;
import Pages.HomePages;
import Pages.LoginPages;
import Pages.SendMessagePage;

import Moduls.FilesReaders.ExcelFileReader;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestFileReaderExcel extends BaseClass {


    LoginPages log = new LoginPages();
    HomePages home =new HomePages();
    SendMessagePage send = new SendMessagePage();
    ScreenShots screenShots = new ScreenShots();





    @DataProvider(name = "reader")
    public Object[][] getDataFromDataProvider() {
        return ExcelFileReader.excelReader();
    }

    @Test(dataProvider = "getDataFromDataProvider")

    @Severity(SeverityLevel.CRITICAL)

    @Link(name = "screenshot",url="https://eyes.applitools.com/app/test-results")

    public void openFacebookAndLoginByFileExcel(String username, String password) {
        //login with username and password

        log.login(username, password);

    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void searchForUser() {

        //write your friend name
        home.navigateToVictimProfile("Friend_name");
        send.pressOnMessageButton();
        //write your massage
        send.sendMultipleMessages("your_massage");
        //taking screenshot using applitool
        screenShots.initialEyes();
        screenShots.WindowScreenShot();






    }
}
