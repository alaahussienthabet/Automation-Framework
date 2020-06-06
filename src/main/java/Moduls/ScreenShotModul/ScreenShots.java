package Moduls.ScreenShotModul;

import UI.UiActions;
import com.applitools.eyes.selenium.Eyes;
import Moduls.FilesReaders.PropertyFileReader;


public class ScreenShots {

    public Eyes eyes;



    public void initialEyes() {
        eyes=new Eyes();

        String[] filedata=(PropertyFileReader.propertiesFileReader(new String[]{"applitoolAPIkey"}));
        eyes.setApiKey(filedata[1]);
    }
    public  void WindowScreenShot() {
        eyes.open(UiActions.driver, "Facebook",
                Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();

    }
}
