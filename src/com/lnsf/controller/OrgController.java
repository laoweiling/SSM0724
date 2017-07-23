package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnsf.entity.Org;
import com.lnsf.entity.TreeNode;

import com.lnsf.service.OrgService;

@Controller
public class OrgController {
	@Autowired
	private OrgService orgService;
	
	@RequestMapping("getOrgById")
	@ResponseBody
	public Org getOrgById(String orgNo){
		return orgService.getOrgById1(orgNo);
	}
	@RequestMapping("getOrgByIdToNode")
	@ResponseBody
	public List<TreeNode> getOrgByIdToNode(String orgNo){
		Org org = orgService.getOrgById1(orgNo);
		TreeNode rootNode = orgToTreeNode(org);
		List<TreeNode> nodes=new ArrayList<TreeNode>();
		nodes.add(rootNode);
		return nodes;
	}

	public List<TreeNode> getChildren(TreeNode treeNode){
		if(treeNode != null){
			return treeNode.getChildren();
		}else{
			return null;
		}
	}
	public List<Org> getOrgChildren(Org org){
		if(org.getChildren()!= null){
			return org.getChildren();
		}else{
			return null;
		}
	}
	
	public TreeNode orgToTreeNode(Org org){
		TreeNode treeNode = null;
		if(org != null){
			treeNode = new TreeNode();
			treeNode.setId(org.getOrgNo());
			treeNode.setText(org.getOrgName());
			treeNode.setState("closed");
			List<Org> orgcs = org.getChildren();
			if(orgcs != null&&orgcs.size()>0){
				List<TreeNode> nodecs = new ArrayList<TreeNode>();
				for(Org orgc:orgcs){
					TreeNode nodec=orgToTreeNode(orgc);
					nodecs.add(nodec);
				}
				treeNode.setChildren(nodecs);
			}else{
				treeNode.setState("opend");
				treeNode.setChildren(null);
				
			}
		}
		return treeNode;	
	}
}

