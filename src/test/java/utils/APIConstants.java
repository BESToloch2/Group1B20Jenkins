package utils;

import io.restassured.RestAssured;

public class APIConstants extends APICommonMethods {

    public static final String CREATE_EMPLOYEE = baseURI+"/createEmployee.php";
    public static final String HEADER_CONTENT_TYPE_KEY = "Content-Type";
    public static final String HEADER_CONTENT_TYPE_VALUE = "application/json";
    public static final String CREATE_USER = baseURI+"/createUser.php";

}
