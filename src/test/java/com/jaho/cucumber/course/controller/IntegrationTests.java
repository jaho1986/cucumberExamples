package com.jaho.cucumber.course.controller;

import com.jaho.cucumber.course.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ValidationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IntegrationTests {

    @Autowired
    EmployeeController employeeController;

    @Test
    public void testCreateReadDelete() {
        Employee employee = new Employee("Lokesh", "Gupta");

        Employee employeeResult = employeeController.create(employee);

        Iterable<Employee> employees = employeeController.read();
        assertThat(employees).first().hasFieldOrPropertyWithValue("firstName", "Lokesh");

        employeeController.delete(employeeResult.getId());
        assertThat(employeeController.read()).isEmpty();
    }

    @Test
    public void errorHandlingValidationExceptionThrown() {
        assertThatExceptionOfType(ValidationException.class)
                .isThrownBy(() -> employeeController.somethingIsWrong());
    }
}