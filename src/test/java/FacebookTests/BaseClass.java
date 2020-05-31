package facebooktests;

import Actions.UiActions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass extends AbstractTestNGCucumberTests {


    @BeforeClass
    public void beforclass() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        UiActions.driver = new ChromeDriver(options);


        UiActions.driver.manage().window().maximize();

        UiActions.driver.navigate().to("https://www.facebook.com/");
        UiActions.wait = new WebDriverWait(UiActions.driver, 100);
    }

    @AfterClass(enabled = false)

    public void afterclass() {

        UiActions.driver.close();
    }

}
