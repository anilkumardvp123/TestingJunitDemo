package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="emps")
public class Employee
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empid;
	private String empdept;
	private String emplocation;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn( name = "company_info_id")
	@JsonIgnore
	private Company comapanyInfo;

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpdept() {
		return empdept;
	}

	public void setEmpdept(String empdept) {
		this.empdept = empdept;
	}

	public String getEmplocation() {
		return emplocation;
	}

	public void setEmplocation(String emplocation) {
		this.emplocation = emplocation;
	}

	public Company getComapanyInfo() {
		return comapanyInfo;
	}

	public void setComapanyInfo(Company comapanyInfo) {
		this.comapanyInfo = comapanyInfo;
	}
}
