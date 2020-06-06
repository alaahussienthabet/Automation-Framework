package FacebookTests;

import Moduls.FilesReaders.PropertyFileReader;
import Moduls.ScreenShotModul.ScreenShotFromSelenium;
import UI.UiActions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;


public class BaseClass extends AbstractTestNGCucumberTests {


    @BeforeClass
    @Parameters({"Browser"}) // To run test from suite
    public void beforeClass(@Optional("chrome") String Browser) { // @optional to run tests by default value = (chrome)


        switch (Browser) {

            case "chrome": // run tests by chrome
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                WebDriverManager.chromedriver().setup();
                UiActions.driver = new ChromeDriver(options);
                break;
            case "firefox": //run tests by firefox
                WebDriverManager.firefoxdriver().setup();

                UiActions.driver = new FirefoxDriver();
                break;
            case "internet explorer": //run tests by internet explore
                WebDriverManager.iedriver().setup();
                UiActions.driver = new InternetExplorerDriver();
                break;
            case "opera": //run tests by opera
                WebDriverManager.operadriver().setup();
                UiActions.driver = new OperaDriver();
                break;
        }

        UiActions.driver.manage().window().maximize();
        //navigate to specific URL
        String[] filedata=(PropertyFileReader.propertiesFileReader(new String[]{"URL"}));
        UiActions.driver.navigate().to(filedata[0]);

        UiActions.wait = new WebDriverWait(UiActions.driver, 100);
    }

    @AfterMethod
    public void takeScreenShots(ITestResult result) throws IOException {

        if (ITestResult.FAILURE == result.getStatus()) {

            System.out.println("Failure Test");
            ScreenShotFromSelenium.takeScreenShots(result.getName());


        }

    }

    @AfterClass(enabled = true)

    public void afterClass() {

        UiActions.driver.close();
    }

}
