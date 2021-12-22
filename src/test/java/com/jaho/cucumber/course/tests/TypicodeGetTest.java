package com.jaho.cucumber.course.tests;

import com.jaho.cucumber.course.definitions.RequestInformation;
import com.jaho.cucumber.course.definitions.TestIntegrationCore;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TypicodeGetTest extends TestIntegrationCore {

    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private ResponseEntity<String> responseEntity;

    @Given("^The list of posts in the route (.+)$")
    public void getPosts(String route) {
        this.responseEntity = get(new RequestInformation(BASE_URL + route, getHeaders()));
    }

    @Then("^I am going to get (\\d+) results$")
    public void validateNumberOfResults(int expectedSize) throws JSONException {
        JSONArray array = new JSONArray(this.responseEntity.getBody());
        assertEquals(expectedSize, array.length());
    }

    @Then("^It should contains the following title: (.+)$")
    public void validateTitle(String title) {
        assertTrue("The title: '" + title + "' was not there.", this.responseEntity.getBody().contains(title));
    }

    @Given("^The following Posts (\\d+) to the endpoint (.+)$")
    public void getOkPosts(int postId, String route) {
        this.responseEntity = get(new RequestInformation(BASE_URL + route + "/" + postId, getHeaders()));
    }

    @Then("^I should get a (\\d+) status$")
    public void validateOkStatus(int expectedValue) {
        assertEquals("ExpectedValue: '" + expectedValue + "', got: " + this.responseEntity.getStatusCode().value(),
                expectedValue,
                this.responseEntity.getStatusCode().value());
    }

    @But("^If I try to get this (\\d+) Id in (.+) I should get (\\d+)$")
    public void validatePostNotFound(int postId, String route, int expectedValue) {
        this.responseEntity = get(new RequestInformation(BASE_URL + route + "/" + postId, getHeaders()));
        assertEquals("ExpectedValue: '" + expectedValue + "', got: " + this.responseEntity.getStatusCode().value(),
                expectedValue,
                this.responseEntity.getStatusCode().value());
    }

    @Given("^These (\\d+) post ids$")
    public void getNotOkPosts(int postId) {
        this.responseEntity = get(new RequestInformation(BASE_URL + "/posts/" + postId, getHeaders()));
    }

    @Then("^All of them should response (\\d+)$")
    public void validateNotOkStatus(int expectedValue) {
        assertEquals("ExpectedValue: '" + expectedValue + "', got: " + this.responseEntity.getStatusCode().value(),
                expectedValue,
                this.responseEntity.getStatusCode().value());
    }
}
