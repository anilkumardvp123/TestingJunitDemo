package com.example.demo.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CompanyRepo;
import com.example.demo.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;
	@Autowired
	private CompanyRepo compnaypre;

	public Company saveEmployee(Company company) {
//company.getEmployeelist().forEach(emp->{
//	emp.setComapanyInfo(company);
//});
	
		return compnaypre.save(company);
	}
	

	public List<Employee> getAllEmps() {
		return emprepo.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		return null;
	}

	@Override
	public void deleteById(int id) {

	}
}
