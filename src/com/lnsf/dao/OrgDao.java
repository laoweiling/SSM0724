package com.lnsf.dao;

import java.util.List;

import com.lnsf.entity.Org;

public interface OrgDao {
	//public List<Org> getAllOrgs();
	public Org getOrgById(String orgNo);
	public Org getOrgByNo(String orgNo);
	public Org getOrgById1(String orgNo);
}
