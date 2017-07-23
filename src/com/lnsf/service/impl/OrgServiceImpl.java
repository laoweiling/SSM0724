package com.lnsf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnsf.dao.OrgDao;
import com.lnsf.entity.Org;
import com.lnsf.service.OrgService;
@Service("orgService")
public class OrgServiceImpl implements OrgService {

	@Autowired
	private OrgDao orgDao;
	
	public Org getOrgByNo(String orgNo) {
		// TODO Auto-generated method stub
		return orgDao.getOrgByNo(orgNo);
	}

	public Org getOrgById(String orgNo) {
		// TODO Auto-generated method stub
		return orgDao.getOrgById(orgNo);
	}

	public Org getOrgById1(String orgNo) {
		// TODO Auto-generated method stub
		return orgDao.getOrgById1(orgNo);
	}

}
