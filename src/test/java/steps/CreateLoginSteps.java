package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class CreateLoginSteps extends CommonMethods {

    @When("user enters firstname middlename lastname")
    public void userEntersFirstnameMiddlenameLastname() {
        WebElement fnField= driver.findElement(By.id("firstName"));
        sendText("John",fnField);
        WebElement mnField= driver.findElement(By.id("middleName"));
        sendText("",mnField);
        WebElement lnField= driver.findElement(By.id("lastName"));
        sendText("Doe",lnField);
    }
    @When("clicks on create login details checkbox")
    public void clicks_on_create_login_details_checkbox() {
        WebElement createDetails= driver.findElement(By.id("chkLogin"));
        click(createDetails);
    }
    @When("user enters username")
    public void user_enters_username() {
        WebElement usernameField = driver.findElement(By.name("user_name"));
        sendText("johndoe12534", usernameField);

    }
    @When("user enters password")
    public void user_enters_password() {
        WebElement passwordField = driver.findElement(By.id("user_password"));
        sendText("Hum@nhrm123", passwordField);
    }
    @When("user confirms password")
    public void user_confirms_password() {
        WebElement confirmField = driver.findElement(By.id("re_password"));
        sendText("Hum@nhrm123", confirmField);
    }
    @When("user clicks save button")
    public void user_clicks_save_button() {
        WebElement saveBtn = driver.findElement(By.id("btnSave"));
        click(saveBtn);
    }
    @Then("employee created successfully")
    public void employee_created_successfully() {
        WebElement createdSuccessfully= driver.findElement(By.xpath("//*[@id='pdMainContainer']/div[1]/h1"));
        String personalDetails= createdSuccessfully.getText();
        Assert.assertEquals(personalDetails,"Personal Details");
    }


    @When("user enters username and password")
    public void userEntersUsernameAndPassword() {
        sendText("johndoe12534", loginPage.userNameField);
        sendText("Hum@nhrm123", loginPage.passwordField);
    }
}
