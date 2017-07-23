package com.lnsf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnsf.dao.DepartmentDao;
import com.lnsf.entity.Department;
import com.lnsf.service.DepartmentService;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	public Department getDepartmentById(int deptNo) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartmentById(deptNo);
	}

	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentDao.getAllDepartments();
	}

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}	
}
