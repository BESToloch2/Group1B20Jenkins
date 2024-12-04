package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.EditContactInfoPage;
import utils.Hooks;

public class EditContactInfoSteps {
    EditContactInfoPage contactInfoPage = new EditContactInfoPage(Hooks.driver);

    @When("user updates contact information with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void userUpdatesContactInformation(String address, String city, String state, String zip, String country,
                                              String homePhone, String mobilePhone, String workPhone,
                                              String workEmail, String otherEmail) {
        contactInfoPage.editContactInfo(address, city, state, zip, country, homePhone, mobilePhone, workPhone, workEmail, otherEmail);
    }

    @Then("the contact information is updated successfully")
    public void theContactInformationIsUpdatedSuccessfully() {
        Assert.assertTrue(contactInfoPage.saveButton.isDisplayed());
    }
}
