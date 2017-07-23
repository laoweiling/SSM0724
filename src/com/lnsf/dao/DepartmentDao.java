package com.lnsf.dao;

import java.util.List;

import com.lnsf.entity.Department;

public interface DepartmentDao {
	public List<Department> getAllDepartments();
	public Department getDepartmentById(int deptNo);
}
