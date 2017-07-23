<%@ page language="java" contentType="text/html; charset=utf-8" import="com.lnsf.util.*,com.lnsf.entity.Employee"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="saveEmployee" method="post">
		编号:<input type="text" name="empNo" readonly="readonly" value="${requestScope.emp.empNo}"> <br/>
		姓名:<input type="text" name="ename" value="${requestScope.emp.ename}"/><br/>
		工作:<input type="text" name="job" value="${requestScope.emp.job}"/><br/>
		入职日期:<input type="text" name="hireDate" value="<%=DateUtil.getStringFromDate(((Employee)request.getAttribute("emp")).getHireDate())%>"  /><br/>
		工资:<input type="text" name="sal" value="${requestScope.emp.sal}"/><br />
		薪金:<input type="text" name="comm" value="${requestScope.emp.comm}"/><br />
		<input type="submit" value="保存"/><input type="reset" value="重置"/>		
	</form>
</body>
</html>