package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;

import java.time.Duration;
import java.util.List;

public class SearchEmployeeSteps extends CommonMethods {

    @When("user enters full name")
    public void user_enters_full_name() throws InterruptedException {
        Thread.sleep(3000);
        WebElement empNameField= driver.findElement(By.id("empsearch_employee_name_empName"));
        sendText("John Doe", empNameField);
        WebElement clickOut= driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[1]/label"));
        click(clickOut);
    }

    @When("clicks search button")
    public void clicks_search_button() throws InterruptedException {
        Thread.sleep(3000);
        WebElement searchBtn= driver.findElement(By.id("searchBtn"));
        click(searchBtn);
    }
    @Then("all matching employees should be returned")
    public void all_matching_employees_should_be_returned() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> returnedEmp= driver.findElements(By.id("frmList_ohrmListComponent"));
        boolean foundEmp= false;
        for(WebElement employee:returnedEmp){
            if(employee.getText().contains("john")){
                foundEmp= true;
                System.out.println("Passed");
                break;
            }
        }
    }
    @When("user enters partial name")
    public void user_enters_partial_name() throws InterruptedException {
        Thread.sleep(3000);
        WebElement empNameField= driver.findElement(By.id("empsearch_employee_name_empName"));
        sendText("Joh", empNameField);
        WebElement clickOut= driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[1]/label"));
        click(clickOut);
    }
    @Then("all matching employees should be returned partial")
    public void all_matching_employees_should_be_returned_partial() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> returnedEmp= driver.findElements(By.id("frmList_ohrmListComponent"));
        boolean foundEmp= false;
        for(WebElement employee:returnedEmp){
            if(employee.getText().contains("joh")){
                foundEmp= true;
                System.out.println("Passed");
                break;
            }
        }
    }
    @When("user enters valid id")
    public void user_enters_valid_id() {
        WebElement idField= driver.findElement(By.id("empsearch_id"));
        sendText("40651780", idField);
        WebElement clickOut= driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[1]/label"));
        click(clickOut);

    }
    @Then("all matching employees should be returned id")
    public void all_matching_employees_should_be_returned_id() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> returnedEmp= driver.findElements(By.id("frmList_ohrmListComponent"));
        boolean foundEmp= false;
        for(WebElement employee:returnedEmp){
            if(employee.getText().contains("40651780")){
                foundEmp= true;
                System.out.println("Passed");
                break;
            }
        }
    }

    @When("user enters invalid id")
    public void userEntersInvalidId() {
        WebElement idField= driver.findElement(By.id("empsearch_id"));
        sendText("2",idField);
    }

    @Then("{string} is displayed")
    public void isDisplayed(String expectedMsg) throws InterruptedException {
        Thread.sleep(3000);
        WebElement message= driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr/td"));
        String actualMsg=message.getText();
        expectedMsg= "No Records Found";
        Assert.assertEquals(expectedMsg,actualMsg);
    }
}
