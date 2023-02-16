package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.repository.service.EmployeeService;
@RestController
@RequestMapping("/employee")
public class EmployeeController
{
	@Autowired
	public EmployeeService employeeService;

	@PostMapping("/save")
	public  Company saveEmployee(@RequestBody Company company)
	{
		return employeeService.saveEmployee(company);
	}

	@GetMapping("/fetchAll")
	public List<Employee> fetchAllEmps()
	{
		return employeeService.getAllEmps();
	}


	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
	{
		employee.setEmpid(Math.toIntExact(id));
		return employeeService.save(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteById(id);
	}

}
