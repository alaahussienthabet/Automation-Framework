package FacebookTests;


import Moduls.ScreenShotModul.ScreenShots;
import Pages.HomePages;
import Pages.LoginPages;
import Pages.SendMessagePage;

import Moduls.FilesReaders.ExcelFileReader;
import UI.UiActions;
import io.qameta.allure.*;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;


public class TestFileReaderExcel extends BaseClass {


    LoginPages log = new LoginPages();
    HomePages home = new HomePages();
    SendMessagePage send = new SendMessagePage();
    ScreenShots screenShots = new ScreenShots();


    /**
     * data provider to reade credentials from excel file
     *
     * @return
     */

    @DataProvider(name = "credentials")
    public Object[][] getCredentialsFromExcel() {
        return ExcelFileReader.excelReader("src//test//resources//DataDriven//credentials.xlsx");
    }

    /**
     * data provider to reade test data from excel file
     *
     * @return
     */
    @DataProvider(name = "testData")
    public Object[][] getDataFromExcel() {
        return ExcelFileReader.excelReader("src//test//resources//DataDriven//testData.xlsx");
    }

    @Test(dataProvider = "credentials", priority = 1, description = "verifying login page title test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify login page title test on Login Page")
    @Story("Story Name: To check login page title")
    @Attachment(value = "Page screenshot", type = "image/png")

    @Link(name = "screenshot", url = "https://eyes.applitools.com/app/test-results")

    /**
     * login with username and password
     */
    public void openFacebookAndLoginByFileExcel(String username, String password) {

        Allure.addAttachment("Page Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));

        log.login(username, password);

    }

    @Test(dataProvider = "testData")

    @Severity(SeverityLevel.TRIVIAL)
    /**
     * write your friend name and massage to send
     */
    public void searchForUser(String friendName, String massage, int numberOfMassages) {


        home.navigateToVictimProfile(friendName);//Friend_name
        send.pressOnMessageButton();


        send.sendMultipleMessages(massage, numberOfMassages);//your_massage
        //taking screenshot using applitool
        screenShots.initialEyes();
        screenShots.WindowScreenShot();


    }
}
