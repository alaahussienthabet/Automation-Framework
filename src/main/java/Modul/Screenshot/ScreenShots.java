package Modul.Screenshot;

import Actions.UiActions;
import com.applitools.eyes.selenium.Eyes;
import filesreaders.Propertyfilereader;


public class ScreenShots {

    public Eyes eyes;



    public void intialeyes() {
        eyes=new Eyes();

        String[] filedata=(Propertyfilereader.properitesfilereader(new String[]{"applitoolAPIkey"}));
        eyes.setApiKey(filedata[2]);
    }
    public  void windowscreenshot() {
        eyes.open(UiActions.driver, "Facebook",
                Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();

    }
}
