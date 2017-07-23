package com.lnsf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnsf.dao.EmployeeDao;
import com.lnsf.entity.Employee;
import com.lnsf.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees=employeeDao.getAllEmployees();
		return employees;
	}
	
	public int getCurrentEmpNo() {
		// TODO Auto-generated method stub
		return employeeDao.getMaxEmpNo()+1;
	}
	
	public int saveEmployee(Employee emp){
		return employeeDao.addEmployee(emp);
	}
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public Employee getEmployeeByEmpNo(int empNo) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeById(empNo);
	}

	public int updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(emp);
	}	

}
