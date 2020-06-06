package FacebookTests;


import Moduls.ScreenShotModul.ScreenShots;
import Pages.HomePages;
import Pages.LoginPages;
import Pages.SendMessagePage;

import Moduls.FilesReaders.ExcelFileReader;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestFileReaderExcel extends BaseClass {


    LoginPages log = new LoginPages();
    HomePages home =new HomePages();
    SendMessagePage send = new SendMessagePage();
    ScreenShots screenShots = new ScreenShots();




    // data provider to reade credentials from excel file
    @DataProvider(name = "credentials")
    public Object[][] getCredentialsFromExcel() {
        return ExcelFileReader.excelReader("credentials.xlsx");
    }

    // data provider to reade test data from excel file
    @DataProvider(name = "testData")
    public Object[][] getDataFromExcel() {
        return ExcelFileReader.excelReader("testdata.xlsx");
    }

    @Test(dataProvider ="credentials")

    @Severity(SeverityLevel.CRITICAL)

    @Link(name = "screenshot",url="https://eyes.applitools.com/app/test-results")

    public void openFacebookAndLoginByFileExcel(String username, String password) {
        //login with username and password

        log.login(username, password);

    }

    @Test(dataProvider = "testData")
    @Severity(SeverityLevel.TRIVIAL)
    public void searchForUser( String friendName,String massage) {

        //write your friend name

        home.navigateToVictimProfile(friendName);//Friend_name
        send.pressOnMessageButton();
        //write your massage
        send.sendMultipleMessages(massage);//your_massage
        //taking screenshot using applitool
        screenShots.initialEyes();
        screenShots.WindowScreenShot();






    }
}
