package com.jaho.cucumber.course.tests;

import com.jaho.cucumber.course.definitions.TestIntegrationCore;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;

@Log4j2
public class JunitTests extends TestIntegrationCore {

    @BeforeAll
    static void setup(){
        log.info("JAHO - @BeforeAll executed");
    }

    @BeforeEach
    void setupThis(){
        log.info("JAHO - @BeforeEach executed");
    }

    @Tag("JUnitTag")
    @Test
    void testCalcOne() {
        log.info("======TEST ONE EXECUTED=======");
        Assertions.assertEquals( 4 , 4);
    }

    @Tag("JUnitTag")
    @Test
    void testCalcTwo() {
        log.info("======TEST TWO EXECUTED=======");
        Assertions.assertEquals( 5 , 5);
    }

    @AfterEach
    void tearThis(){
        log.info("JAHO - @AfterEach executed");
    }

    @AfterAll
    static void tear(){
        log.info("JAHO - @AfterAll executed");
    }
}
