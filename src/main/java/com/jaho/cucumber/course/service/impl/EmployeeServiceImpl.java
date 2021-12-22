package com.jaho.cucumber.course.service.impl;

import com.jaho.cucumber.course.dao.EmployeeRepository;
import com.jaho.cucumber.course.entity.Employee;
import com.jaho.cucumber.course.handlers.RecordNotFoundException;
import com.jaho.cucumber.course.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee = employeeRepository.save(employee);
            return employee;
        } else {
            Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

            if (employeeOptional.isPresent()) {
                Employee newEntity = employeeOptional.get();
                newEntity.setFirstName(employee.getFirstName());
                newEntity.setLastName(employee.getLastName());

                newEntity = employeeRepository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("No employee record exist for given id");
            }
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> result = (List<Employee>) employeeRepository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Employee>();
        }
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
