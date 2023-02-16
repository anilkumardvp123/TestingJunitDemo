package com.example.demo.repository.service;

import java.util.List;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;

public interface EmployeeService {
    public Company saveEmployee(Company companny);
    public List<Employee> getAllEmps();

    Employee save(Employee employee);

    void deleteById(int id);
}
