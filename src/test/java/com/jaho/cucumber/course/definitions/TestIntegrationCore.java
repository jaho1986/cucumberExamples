package com.jaho.cucumber.course.definitions;

import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@Log4j2
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestIntegrationCore {

    public TestIntegrationCore() {

    }

    @Autowired
    protected TestRestTemplate restTemplate;
    protected ResponseEntity<String> response;

    protected ResponseEntity<String> post(RequestInformation requestInformation) {
        return restTemplate.postForEntity(requestInformation.getUrl(), requestInformation.getBody(), String.class, getHeaders());
    }

    protected void put(RequestInformation requestInformation) {
        restTemplate.put(requestInformation.getUrl(), requestInformation.getBody(), String.class, getHeaders());
    }

    protected ResponseEntity<String> get(RequestInformation requestInformation) {
        return restTemplate.getForEntity(requestInformation.getUrl(), String.class, getHeaders());
    }

    protected void delete(RequestInformation requestInformation) {
        restTemplate.delete(requestInformation.getUrl(), getHeaders());
    }

    HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }

    @Configuration
    static class ContextConfiguration {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }

        @Bean
        ServletWebServerFactory servletWebServerFactory(){
            return new TomcatServletWebServerFactory();
        }
    }
}
