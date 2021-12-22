package com.jaho.cucumber.course.dao;

import com.jaho.cucumber.course.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
