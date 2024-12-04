package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditContactInfoPage {
    WebDriver driver;

    @FindBy(id = "contact_street1")
    public WebElement addressField;

    @FindBy(id = "contact_city")
    public WebElement cityField;

    @FindBy(id = "contact_province")
    public WebElement stateField;

    @FindBy(id = "contact_emp_zipcode")
    public WebElement zipField;

    @FindBy(id = "contact_country")
    public WebElement countryDropdown;

    @FindBy(id = "contact_emp_hm_telephone")
    public WebElement homePhoneField;

    @FindBy(id = "contact_emp_mobile")
    public WebElement mobilePhoneField;

    @FindBy(id = "contact_emp_work_telephone")
    public WebElement workPhoneField;

    @FindBy(id = "contact_emp_work_email")
    public WebElement workEmailField;

    @FindBy(id = "contact_emp_oth_email")
    public WebElement otherEmailField;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    // Constructor
    public EditContactInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void editContactInfo(String address, String city, String state, String zip, String country,
                                String homePhone, String mobilePhone, String workPhone,
                                String workEmail, String otherEmail) {
        addressField.clear();
        addressField.sendKeys(address);

        cityField.clear();
        cityField.sendKeys(city);

        stateField.clear();
        stateField.sendKeys(state);

        zipField.clear();
        zipField.sendKeys(zip);

        countryDropdown.sendKeys(country);

        homePhoneField.clear();
        homePhoneField.sendKeys(homePhone);

        mobilePhoneField.clear();
        mobilePhoneField.sendKeys(mobilePhone);

        workPhoneField.clear();
        workPhoneField.sendKeys(workPhone);

        workEmailField.clear();
        workEmailField.sendKeys(workEmail);

        otherEmailField.clear();
        otherEmailField.sendKeys(otherEmail);

        saveButton.click();
    }
}
