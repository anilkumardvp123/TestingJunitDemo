package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CompanyRepo;
import com.example.demo.repository.EmployeeRepository;

import java.util.List;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class Employee2ApplicationTest
{

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void Create2() {
        Employee employee = new Employee();
        employee.setEmpid(1);
        employee.setEmpdept("Demostic");
        employee.setEmplocation("chennai");
        employeeRepository.save(employee);
        assertNotNull(employeeRepository.findById(1).get());

    }

    @Test
    public void ReadAll2(){
        List<Employee> list = employeeRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    public void SingleEmployee(){
        Employee employee = employeeRepository.findById(1).get();
        assertEquals("banglore",employee.getEmplocation());

    }

    @Test
    public void employeDelete(){
        employeeRepository.deleteById(1);
        assertThat(employeeRepository.existsById(2)).isFalse();
    }

    @Test
    public void employeUpdate(){
        Employee employee = employeeRepository.findById(1).get();
        employee.setEmpdept("digital");
        employeeRepository.save(employee);
        assertNotEquals("recruitment",employeeRepository.findById(1).get().getEmpdept());
    }


    @Autowired
    CompanyRepo companyRepo;
    @Test
    public void Create()
    {
        Company company = new Company();
        company.setId(1);
        company.setCompanyName("Wipro");
        company.setCompanyBranch("banglore");
        companyRepo.save(company);
        assertNotNull(companyRepo.findById(1).get());

    }

    @Test
    public void ReadAll()
    {
        List<Company> list = companyRepo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }



    @Test
    public void SingleCompany()
    {
        Company company = companyRepo.findById(1).get();
        assertEquals("Banglore",company.getCompanyBranch());

    }


    @Test
    public void CompanyUpdate()
    {
        Company company = companyRepo.findById(1).get();
        company.setCompanyBranch("Hyderbad");
        companyRepo.save(company);
        assertNotEquals("Banglore",companyRepo.findById(1).get().getCompanyBranch());
    }
    @Test
    public void CompanyDelete()
    {
        companyRepo.deleteById(1);
        assertThat(companyRepo.existsById(2)).isFalse();
    }
}