package apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayloadConstans;
import utils.CommonMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIUserCreationSteps extends CommonMethods {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    RequestSpecification request;
    Response response;

    @Given("a request is prepared for creating the employee")
    public void a_request_is_prepared_for_creating_the_employee() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                body("{\n" +
                        "  \"name\": \"Olek\",\n" +
                        "  \"email\": \"befun@gmail.com\",\n" +
                        "  \"password\": \"12345\"\n" +
                        "}");
    }

    @When("I send a POST request with the user data")
    public void i_send_a_post_request_with_the_user_data() {
        response=request.when().post(APIConstants.CREATE_EMPLOYEE);
    }

    @Then("the API should respond with a status code {int}")
    public void the_api_should_respond_with_a_status_code(Integer int1) {
        response.then().assertThat().statusCode(int1);
    }

    @Then("the response should include {string}: {string}")
    public void the_response_should_include(String message, String text) {
        response.then().assertThat().
                body(message,equalTo("text"));
    }
}
