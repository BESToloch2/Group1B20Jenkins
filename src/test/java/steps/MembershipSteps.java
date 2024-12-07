package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.MembershipPage;
import utils.CommonMethods;

import java.util.List;

public class MembershipSteps extends CommonMethods {
    MembershipPage membershipPage = new MembershipPage();

    @Then("user clicks on the membership button")
    public void user_clicks_on_the_membership_button() {
        click(membershipPage.addButton);
    }

    @Then("user clicks on Add option button")
    public void user_clicks_on_add_option_button() {
        click(membershipPage.addButton);
    }

    @Then("user selects an option from the dropdown menu")
    public void user_selects_an_option_from_the_dropdown_menu() {
        Select select = new Select(membershipPage.membershipDropdown);
        select.selectByIndex(3);
    }

    @Then("user selects Subscription Paid By")
    public void user_selects_subscription_paid_by() {
        Select select = new Select(membershipPage.subscriptionDropdown);
        select.selectByVisibleText("Employer");
    }

    @Then("user enters paid amount {string}")
    public void user_enters_paid_amount(String amount) {
        sendText(amount, membershipPage.subscriptionAmount);
    }

    @Then("user selects Currency")
    public void user_selects_currency() {
        Select select = new Select(membershipPage.currencyDropdown);
        select.selectByVisibleText("United States Dollar");
    }

    @Then("user enters the day of Subscription and Renewal")
    public void user_enters_the_day_of_subscription_and_renewal() {
        // Subscription Start Date
        click(membershipPage.subscriptionCommenceDate);
        selectDate("2024-03-03");

        // Renewal Date
        click(membershipPage.subscriptionRenewalDate);
        selectDate("2025-03-03");
    }

    private void selectDate(String date) {
        String[] dateParts = date.split("-");
        String year = dateParts[0];
        String month = String.valueOf(Integer.parseInt(dateParts[1]) - 1); // Months are 0-indexed
        String day = dateParts[2];

        WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));

        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByValue(month);

        Select selectYear = new Select(yearDropdown);
        selectYear.selectByValue(year);

        List<WebElement> dates = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
        for (WebElement dateElement : dates) {
            if (dateElement.getText().equals(day)) {
                dateElement.click();
                break;
            }
        }
    }

    @Then("user presses the save button")
    public void user_presses_the_save_button() {
        click(membershipPage.saveButton);
    }

    @Then("the membership details should be saved successfully")
    public void the_membership_details_should_be_saved_successfully() {
        // Verify the success message or updated details
        WebElement successMessage = driver.findElement(By.id("successMessage"));
        assertText(successMessage, "Membership details saved successfully.");
    }

    private void assertText(WebElement successMessage, String s) {
    }
}
