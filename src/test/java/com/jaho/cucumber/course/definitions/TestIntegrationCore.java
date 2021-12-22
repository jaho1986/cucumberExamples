package com.jaho.cucumber.course.definitions;

import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;


@Log4j2
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class TestIntegrationCore {

    public TestIntegrationCore() {
    }

    @Autowired
    protected TestRestTemplate restTemplate;

    public ResponseEntity<String> response;

    public ResponseEntity<String> post(RequestInformation requestInformation) {
        return restTemplate.postForEntity(requestInformation.getUrl(), requestInformation.getBody(), String.class, getHeaders());
    }

    public void put(RequestInformation requestInformation) {
        restTemplate.put(requestInformation.getUrl(), requestInformation.getBody(), String.class, getHeaders());
    }

    public ResponseEntity<String> get(RequestInformation requestInformation) {
        return restTemplate.getForEntity(requestInformation.getUrl(), String.class, getHeaders());
    }

    public void delete(RequestInformation requestInformation) {
        restTemplate.delete(requestInformation.getUrl(), getHeaders());
    }

    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }
}
