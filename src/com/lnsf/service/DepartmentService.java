package com.lnsf.service;

import java.util.List;

import com.lnsf.entity.Department;

public interface DepartmentService {
	public Department getDepartmentById(int deptNo);
	public List<Department> getAllDepartments();
}
