package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="tbl")
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String companyName;
    private String companyBranch;


	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getCompanyBranch()
	{
		return companyBranch;
	}

	public void setCompanyBranch(String companyBranch)
	{
		this.companyBranch = companyBranch;
	}

	public void setEmployeelist(List<Employee> employeelist)
	{
		this.employeelist = employeelist;
	}

	@Getter
	@OneToMany(fetch=FetchType.LAZY,mappedBy="comapanyInfo",cascade=CascadeType.ALL)
	private List<Employee>employeelist;

	public List<Employee> getEmployeelist() {
		return employeelist;
	}
}
