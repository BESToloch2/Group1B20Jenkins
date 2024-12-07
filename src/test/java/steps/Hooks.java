
package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void setup() {
        openBrowserAndLaunchApplication();
    }

    @After
    public void teardown(Scenario scenario) {
        byte[] pic;
        if(scenario.isFailed()){
            pic = takeScreenshot("failed/"+scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }
        scenario.attach(pic,"image/png",scenario.getName());
        closeBrowser();
    }
}

