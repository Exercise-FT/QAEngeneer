package step_definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){

        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @After
    public static void closeBrowser() throws InterruptedException {
        Driver.get().quit();
    }

}
