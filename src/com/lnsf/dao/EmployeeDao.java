package com.lnsf.dao;

import java.util.List;
import com.lnsf.entity.Employee;

public interface EmployeeDao {
	/*
	
	@Select("select * from emp where ename like #{ename} and sal >= #{minSal} and sal <= #{maxSal}")
	public List<Employee> getEmployeesByCondition(EmployeeCondition empCondition);
	
	@Select("select * from emp where ename like #{ename} and sal >= #{minSal} and sal <= #{maxSal}")
	public List<Employee> getEmployeeByConditionMap(Map<String, Object> maps);

	@SelectProvider(type=com.lnsf.dao.EmployeeSqlProvider.class, method="getEmployeeByConditionClassSql")
	public List<Employee> getEmployeesByCondition1(EmployeeCondition empCondition);
	*/
	
	public int addEmployee(Employee emp);
	public int updateEmployee(Employee emp);
	public int delEmployeeById(int empNo);
	public Employee getEmployeeById(int empNo);
	public List<Employee> getAllEmployees();
	public int getMaxEmpNo();
}
