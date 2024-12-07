package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class MembershipPage extends CommonMethods {

    @FindBy(id = "btnAddMembershipDetail")
    public WebElement addButton;

    @FindBy(id = "membership_membership")
    public WebElement membershipDropdown;

    @FindBy(id = "membership_subscription")
    public WebElement subscriptionDropdown;

    @FindBy(id = "membership_subscriptionAmount")
    public WebElement subscriptionAmount;

    @FindBy(id = "membership_currency")
    public WebElement currencyDropdown;

    @FindBy(id = "membership_subscriptionCommenceDate")
    public WebElement subscriptionCommenceDate;

    @FindBy(id = "membership_subscriptionRenewalDate")
    public WebElement subscriptionRenewalDate;

    @FindBy(id = "btnSaveMembership")
    public WebElement saveButton;

    public MembershipPage() {
        PageFactory.initElements(driver, this);
    }
}


