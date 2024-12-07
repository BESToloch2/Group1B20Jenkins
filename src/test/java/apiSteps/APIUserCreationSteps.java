package apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APICommonMethods;
import utils.APIConstants;
import utils.APIPayloadConstans;
import utils.CommonMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIUserCreationSteps extends APICommonMethods {
    @Given("a request is prepared for creating user with all correct required fields")
    public void a_request_is_prepared_for_creating_user_with_all_correct_required_fields() {
        request=given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                body(APIPayloadConstans.createUserPayload(
                        "Ol",
                        "1@gmail.com","1"
        ));
    }
    @When("I send a POST request with the user data")
    public void i_send_a_post_request_with_the_user_data() {
        request.when().post(APIConstants.CREATE_USER);
    }
    @Then("the API should respond with a status created code {int}")
    public void the_api_should_respond_with_a_status_created_code(Integer statusCode) {
        request.then().statusCode(statusCode);
    }
    @Then("the response should include success {string} {string}")
    public void the_response_should_include_success(String path, String expectedMessage) {
        String message =response.jsonPath().getString(path);
        Assert.assertEquals(expectedMessage,message);
    }

    @Then("the API should respond with a status success code {int}")
    public void the_api_should_respond_with_a_status_success_code(Integer statusCode) {
        request.then().statusCode(statusCode);
    }
    @Then("the response should include {string} {string}")
    public void the_response_should_include(String path, String expected) {
        String message =response.jsonPath().getString(path);
        Assert.assertEquals(message,expected);
    }

    @Given("a request is prepared for creating user with an empty password field")
    public void a_request_is_prepared_for_creating_user_with_an_empty_password_field() {
        request=given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                body(APIPayloadConstans.createUserPayload("oo","2@gmail.com",""));
    }
    @Then("the API should respond with a status bad request code {int}")
    public void the_api_should_respond_with_a_status_bad_request_code(Integer statusCode) {
        response.then().statusCode(statusCode);
    }
    @Then("the response should include {string} {string} , {string} {string}")
    public void the_response_should_include(String conditionPath, String expectedCondition, String dataPath, String expectedData) {
        String condition=response.jsonPath().getString(conditionPath);
        Assert.assertEquals(expectedCondition,condition);
        String data=response.jsonPath().getString(dataPath);
        Assert.assertEquals(expectedData,data);
    }

    @Given("a request is prepared for creating user with an empty name field")
    public void a_request_is_prepared_for_creating_user_with_an_empty_name_field() {
        request=given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                body(APIPayloadConstans.createUserPayload("","3@gmail.com","3"));
    }

}
