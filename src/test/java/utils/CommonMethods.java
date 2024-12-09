package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import static utils.PageInitializer.initializePageObject;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;
    public  void openBrowserAndLaunchApplication(){
        switch (ConfigReader.read("browser")){
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless"); // Enable headless mode
                driver = new ChromeDriver(options);
                break;
            case "FireFox":
                driver=new FirefoxDriver();
                break;
            case "Edge":
                driver=new EdgeDriver();
                break;
            case "Safari":
                driver=new SafariDriver();
                break;
            default:
                System.out.println("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(ConfigReader.read("url"));
        initializePageObject();
    }

    public void closeBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }

    public void sendText(String text, WebElement element){
        element.clear();
        element.sendKeys(text);
    }

    public void selectFromDropDown(WebElement dropDown, String visibleText){
        Select sel=new Select(dropDown);
        sel.selectByVisibleText(visibleText);
    }

    public void selectFromDropDown(String value,WebElement dropDown){
        Select sel=new Select(dropDown);
        sel.deselectByValue(value);
    }

    public void selectFromDropDown(WebElement dropDown, int index){
        Select sel=new Select(dropDown);
        sel.selectByIndex(index);
    }

    public WebDriverWait getWait(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }
    public void waitForElementToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    public JavascriptExecutor getJSExecuter(){
        JavascriptExecutor js=(JavascriptExecutor)  driver;
        return js;
    }

    public void jsClick(WebElement element){
        getJSExecuter().executeScript("arguments[0].click();",element);
    }

    public static String getTimeStamp(String pattern){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static byte[] takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
        File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            String filePath = Constants.SCREENSHOT_FILEPATH + filename + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png";
            FileUtils.copyFile(screenshotFile, new File(filePath));
        } catch (IOException e) {
            System.err.println("Error saving screenshot: " + e.getMessage());
        }

        return screenshotBytes;
    }


}
