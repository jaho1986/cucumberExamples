package com.jaho.cucumber.course.dao;

import com.jaho.cucumber.course.entity.Employee;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testCreateReadDelete() {
        Employee employee = new Employee("Lokesh", "Gupta");

        employeeRepository.save(employee);

        Iterable<Employee> employees = employeeRepository.findAll();
        assertThat(employees).extracting(Employee::getFirstName).containsOnly("Lokesh");

        employeeRepository.deleteAll();
        assertThat(employeeRepository.findAll()).isEmpty();
    }
}
