package com.lnsf.entity;

public class Department {
	private int deptNo;
	private String dname;
	private String loc;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Department(int deptNo, String dname, String loc) {
		super();
		this.deptNo = deptNo;
		this.dname = dname;
		this.loc = loc;
	}
	public Department() {
		super();
	}
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
}
