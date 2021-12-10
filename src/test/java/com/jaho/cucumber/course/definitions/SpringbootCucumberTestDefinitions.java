package com.jaho.cucumber.course.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@CucumberContextConfiguration
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootCucumberTestDefinitions {

/*
    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given("^I send a GET request to the endpoint$")
    public void sendGETRequest(){
        request = given()
                    .baseUri("https://api.github.com")
                    .contentType(ContentType.JSON);
    }

    @Then("^I get a (\\d+) status code$")
    public void expectedStatusCode(int expectedStatusCode){
        response = request
                    .when()
                    .get("/users/TheFreeRangeTester/repos");
        json = response.then().statusCode(expectedStatusCode);
    }

    @Given("^I send a GET request to the (.+) URI$")
    public void sendGETRequest(String baseURI) {
        request = given()
                    .baseUri(baseURI)
                    .contentType(ContentType.JSON);
    }
    
    @Then("^I am going to validate that there are (\\d+) items on (.+) endpoint$")
    public void validateNumberOfItems(int expectedSize, String endpoint) {
    	response = request
    			.when()
    			.get(endpoint);
    	List<String> jsonResponse = response.jsonPath().getList("$");
        assertEquals(expectedSize, jsonResponse.size());

    }
    
    @Then("^I validate (.+) in the response at (.+) endpoint$")
    public void validateValueInsideResponse(String expectedValue, String endpoint) {
    	response = request
    			.when()
    			.get(endpoint);
    	List<String> jsonResponse = response.jsonPath().getList("username");
    	assertTrue("The value: " + expectedValue + " is not in the response. ",jsonResponse.contains(expectedValue));
    }
    
    @Then("^I can validate the nested value: (.+) in the response at (.+) endpoint")
    public void validateJSONElement(String expectedStreet, String endpoint) {
    	response = request
    			.when()
    			.get(endpoint);
    	String jsonResponse = response.jsonPath().getString("address.street");
    	assertTrue("The value: " + expectedStreet + " is not in the response. ",jsonResponse.contains(expectedStreet));
    }

*/
}