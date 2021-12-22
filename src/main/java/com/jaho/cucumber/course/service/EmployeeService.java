package com.jaho.cucumber.course.service;

import com.jaho.cucumber.course.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);
    public List<Employee> findAll();
    public void deleteById(Integer id);
    public void deleteAll();
}
