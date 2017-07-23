package com.lnsf.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	private int empNo;
	private String ename;
	private String job;
	private Employee mgr;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	private float sal;
	private float comm;
	private Department dept;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Employee getMgr() {
		return mgr;
	}
	public void setMgr(Employee mgr) {
		this.mgr = mgr;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public float getComm() {
		return comm;
	}
	public void setComm(float comm) {
		this.comm = comm;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Employee(int empNo, String ename, String job, Employee mgr, Date hireDate, float sal, float comm,
			Department dept) {
		super();
		this.empNo = empNo;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.dept = dept;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hireDate="
				+ hireDate + ", sal=" + sal + ", comm=" + comm + ", dept=" + dept + "]";
	}
	
	
}
