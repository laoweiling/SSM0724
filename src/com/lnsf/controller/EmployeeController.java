package com.lnsf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lnsf.entity.Department;
import com.lnsf.entity.Employee;
import com.lnsf.service.DepartmentService;
import com.lnsf.service.EmployeeService;

@Controller
//@RestController
public class EmployeeController {
	
	
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EmployeeService employeeService;
	
	@ModelAttribute("employee")
	public Employee getEmployee(Employee emp){
		if(emp.getDept()!=null&&emp.getDept().getDeptNo()>0){		
			Department dept=departmentService.getDepartmentById(emp.getDept().getDeptNo());
			emp.setDept(dept);
		}
		return emp;		
	}
	
	
	@RequestMapping("/showEmployees")
	public String showEmployees(HttpServletRequest request){
		//System.out.println("showEmployees");
		List<Employee> employees=employeeService.getAllEmployees();
		request.setAttribute("emps", employees);
		//System.out.println(employees);
		return "showEmployees";
	}
	@RequestMapping("/showEmployees1")
	@ResponseBody
	public List<Employee> getAllEmployees(){
		//System.out.println("showEmployees");
		List<Employee> employees=employeeService.getAllEmployees();
		return employees;
	}
	@RequestMapping(value="saveEmployee",method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee employee,HttpServletRequest request){
		//更新的方操作
		if(employee.getEmpNo()>0){
			employeeService.updateEmployee(employee);
		}else{		
			//添加的操作
			employee.setEmpNo(employeeService.getCurrentEmpNo());
			employeeService.saveEmployee(employee);
		}
		//重新调用显示的方法，重定向RequestMapping 
		return "redirect:/showEmployees";
	}
	
	@RequestMapping(value="saveEmployee1",method=RequestMethod.POST)
	@ResponseBody
	public String saveEmployee1(Employee employee,HttpServletRequest request){
		if(employee.getEname()!=null&&!employee.getEname().equals("")){
		//if(!ename.equals("")){
			employee.setEmpNo(employeeService.getCurrentEmpNo());
			employeeService.saveEmployee(employee);
			return "success";
		}else{
			return "error";
		}
		
	}
	@RequestMapping("updateEmployee")
	public String updateEmployee(int empNo,HttpServletRequest request){
		Employee employee=employeeService.getEmployeeByEmpNo(empNo);
		request.setAttribute("emp", employee);
		return "updateEmployee";
	}
	@RequestMapping("addEmployee")
	public String addEmployee(HttpServletRequest request){
		List<Department> depts=departmentService.getAllDepartments();
		request.setAttribute("depts", depts);
		return "addEmployee";
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
}
