package com.jaho.cucumber.course.service;

import com.jaho.cucumber.course.dao.EmployeeRepository;
import com.jaho.cucumber.course.entity.Employee;
import com.jaho.cucumber.course.service.impl.EmployeeServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Log4j2
@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @InjectMocks
    EmployeeServiceImpl service;

    @Mock
    EmployeeRepository dao;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAllEmployees() {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("John", "John"));
        list.add(new Employee("Alex", "kolenchiski"));
        list.add(new Employee("Steve", "Waugh"));

        when(dao.findAll()).thenReturn(list);
        List<Employee> empList = service.findAll();

        assertEquals(3, empList.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    void testCreateOrSaveEmployee() {
        Employee employee = new Employee("Lokesh","Gupta");
        service.save(employee);
        verify(dao, times(1)).save(employee);
    }
}