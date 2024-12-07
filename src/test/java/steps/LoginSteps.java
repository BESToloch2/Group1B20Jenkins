package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import static utils.PageInitializer.loginPage;

public class LoginSteps extends CommonMethods {

   /* @Given("user is able to access to hrms app")
    public void user_is_able_to_access_to_hrms_app() {
        openBrowserAndLaunchApplication();
    }*/
    @When("user enter valid credentials")
    public void user_enter_valid_credentials() {
    sendText(ConfigReader.read("userName"), loginPage.userNameField);
    sendText(ConfigReader.read("password"),loginPage.passwordField);
    }

    @When("click on login button")
    public void click_on_login_button() {
        click(loginPage.loginButton);
    }

    @Then("user navigate to dashboard page")
    public void user_navigate_to_dashboard_page() {
        Assert.assertTrue(dashboardPage.welcomeSigne.isDisplayed());
    }

}
