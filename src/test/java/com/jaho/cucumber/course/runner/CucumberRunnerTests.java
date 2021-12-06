package com.jaho.cucumber.course.runner;

import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)

@CucumberOptions(plugin = "pretty", 
                 features = {"src/test/resources/features"}, 
                 glue = {"com.jaho.cucumber.course"})
public class CucumberRunnerTests {
}