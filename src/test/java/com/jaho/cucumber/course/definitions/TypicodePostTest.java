package com.jaho.cucumber.course.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TypicodePostTest extends TestIntegrationCore {

    @Value("classpath:json/post_test.json")
    Resource jsonPost;

    @Value("classpath:json/put_test.json")
    Resource jsonPut;

    private ResponseEntity<String> responseEntity;
    private static final Integer MILLISECOND = 1000;
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private static final String SLASH="/";

    @Given("^The following post_test.json file at (.+) URI$")
    public void getPosts(String route) {
        this.responseEntity = post(new RequestInformation(BASE_URL + route, getHeaders(), jsonPost.toString()));
    }

    @Then("^It should receive a (\\d+) status code$")
    public void validateNumberOfResults(int expectedValue) {
        assertEquals("Got: " + this.responseEntity.getStatusCode().value() + ", expected: " + expectedValue,
                expectedValue,
                this.responseEntity.getStatusCode().value());
    }

    @And("^I sleep for (\\d+) second$")
    public void doWaiting(int seconds) throws InterruptedException {
        Thread.sleep(seconds * MILLISECOND);
    }

    @And("^I update the post at (.+) URI$")
    public void doUpdate(String route) {
        put(new RequestInformation(BASE_URL + route, getHeaders(), jsonPut.toString()));
    }

    @Then("^In (.+) with id (\\d+) I should see the following title: (.+)$")
    public void getUpdatedElement(String route, int id, String title) {
        this.responseEntity = get(new RequestInformation(BASE_URL + route + SLASH + id, getHeaders()));
        assertTrue("The record does not have the title: " + title, responseEntity.getBody().contains(title));
    }

    @When("^I delete the user (\\d+) at (.+) URI$")
    public void deleteElement(int id, String route) {
        delete(new RequestInformation(BASE_URL + route + SLASH + id, getHeaders()));
    }

    @Then("^I should get a (\\d+) status if I try to obtain the (\\d+) in (.+) again")
    public void verifyDeletion(int status, int id, String route) {
        this.responseEntity = get(new RequestInformation(BASE_URL + route + SLASH + id, getHeaders()));
        assertEquals("The record does not have the element: " + id, status, this.responseEntity.getStatusCode().value());
    }
}
