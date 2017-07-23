package com.lnsf.service;

import java.util.List;

import com.lnsf.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public int getCurrentEmpNo();
	public int saveEmployee(Employee emp);
	public Employee getEmployeeByEmpNo(int empNo);
	public int updateEmployee(Employee emp);
}
