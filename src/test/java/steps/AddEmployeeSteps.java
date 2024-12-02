package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        sendText("John", addEmployeePage.firstnameLocator);
        sendText("Doe", addEmployeePage.lastnameLocator);
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        WebElement addedSuccessfully= driver.findElement(By.xpath("//*[@id='pdMainContainer']/div[1]/h1"));
        String personalDetails= addedSuccessfully.getText();
        Assert.assertEquals(personalDetails,"Personal Details");
    }
    @When("user clears id field")
    public void user_clears_id_field() {
        addEmployeePage.employeeId.clear();
    }
    @When("user enters id")
    public void user_enters_id() {
        sendText("7483274382493839", addEmployeePage.employeeId);
    }
    @When("user enters firstname")
    public void user_enters_firstname() {
        sendText("John", addEmployeePage.firstnameLocator);
    }
    @Then("user can see lastname error message")
    public void user_can_see_lastname_error_message() {
        addEmployeePage.errorMessage.isDisplayed();
    }
}
