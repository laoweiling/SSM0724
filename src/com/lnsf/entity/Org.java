package com.lnsf.entity;

import java.util.List;

public class Org {
	private String orgNo;
	private String orgName;
	private List<Org> children;
	public String getOrgNo() {
		return orgNo;
	}
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public List<Org> getChildren() {
		return children;
	}
	public void setChildren(List<Org> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Org [orgNo=" + orgNo + ", orgName=" + orgName + ", children=" + children + "]";
	}
	public Org(String orgNo, String orgName, List<Org> children) {
		super();
		this.orgNo = orgNo;
		this.orgName = orgName;
		this.children = children;
	}
	public Org() {
		super();
	}
	
	
}
