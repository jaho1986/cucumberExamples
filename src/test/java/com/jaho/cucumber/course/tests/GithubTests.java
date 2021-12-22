package com.jaho.cucumber.course.tests;

import com.jaho.cucumber.course.definitions.RequestInformation;
import com.jaho.cucumber.course.definitions.TestIntegrationCore;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.JSONArray;
import org.json.JSONException;

import static org.junit.Assert.assertEquals;

public class GithubTests extends TestIntegrationCore {

    private static final String BASE_URL = "https://api.github.com";

    @Given("^I send a GET request to the endpoint$")
    public void sendGETRequest(){
        RequestInformation ri = new RequestInformation();
        ri.setUrl(BASE_URL + "/users/TheFreeRangeTester/repos");
        ri.setHeaders(getHeaders());
        response = get(ri);
    }

    @Then("^I get a (\\d+) status code$")
    public void expectedStatusCode(int expectedStatusCode){
        assertEquals("Got: " + response.getStatusCode() + ", expected: " + expectedStatusCode,
                expectedStatusCode,
                response.getStatusCode().value());
    }

    @Given("^I send a GET request to the (.+) URI$")
    public void sendGETRequest(String baseURI) {
        RequestInformation ri = new RequestInformation();
        ri.setUrl(baseURI + "/users");
        ri.setHeaders(getHeaders());
        this.response = get(ri);
    }

    @Then("^I am going to validate that there are (\\d+) items on (.+) endpoint$")
    public void validateNumberOfItems(int expectedSize, String endpoint) throws JSONException {
        JSONArray array = new JSONArray(response.getBody());
        assertEquals(expectedSize, array.length());
    }
}
