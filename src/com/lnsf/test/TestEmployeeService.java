package com.lnsf.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lnsf.entity.Employee;
import com.lnsf.entity.Org;
import com.lnsf.service.EmployeeService;
import com.lnsf.service.OrgService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestEmployeeService {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	OrgService orgService;
	
	@Test
	public void test() {
		
		try{
			/*List<Employee> employees=employeeService.getAllEmployees();
			System.out.println(employees);*/
			Org org=orgService.getOrgById1("520");
			System.out.println(org);
			System.out.println("nihao");
		}catch(Exception e){
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	

}
