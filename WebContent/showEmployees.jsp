<%@ page language="java" import="java.util.*, com.lnsf.entity.Employee" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${!empty requestScope.emps}">
		<table border="1px">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>工作</th>
				<th>部门</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.emps}" var="employee">
				<tr>
					<td><c:out value="${employee.empNo}"></c:out></td>
					<td><c:out value="${employee.ename}"></c:out></td>
					<td><c:out value="${employee.job}"></c:out></td>
					<td><c:out value="${employee.hireDate}"></c:out></td>
					<td><a href="updateEmployee?empNo=${employee.empNo}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="">删除</a></td>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty requestScope.emps}==null">
		没有一个雇员
	</c:if>
	<a href="addEmployee">添加</a>
</body>
</html>