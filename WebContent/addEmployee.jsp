<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#addEmpForm :submit").click(function(){
			var form=$("#addEmpForm").serialize();		//4.form表单:可以有get与post 
			var data={									//3.json
					ename:$("#ename").val(),
					job:$("#job").val(),
					comm:$("#comm").val(),
					sal:$("#sal").val(),
					empNo:"1001"
			};
			$.ajax({
				//1.字符拼接的方法//controller上也要用get的方法
				/*
				type:"GET",
				url:"saveEmployee1?ename=zhangsang&empNo=1001",
				success:function(data){
					//alert(data);
					if(data=="success"){
						$("#msg").html("保存用户成功!")
					}else{
						$("#msg").html("保存用户失败!")
					}
				},
				error:function(data){
					alert("error");
				}
				*/
				//2.json	//get
				/*
				type:"GET",
				url:"saveEmployee1",
				data:JSON.stringify(data),
				contentType:"json",
				success:function(data){
					//alert(data);
					if(data=="success"){
						$("#msg").html("保存用户成功!")
					}else{
						$("#msg").html("保存用户失败!")
					}
				},
				error:function(data){
					alert("error");
				}*/
				//3.json	//post
				/*
				type:"post",
				url:"saveEmployee1",
				data:data,
				//contentType:"application/json",
				success:function(data){
					//alert(data);
					if(data=="success"){
						$("#msg").html("保存用户成功!")
					}else{
						$("#msg").html("保存用户失败!")
					}
				},
				error:function(data){
					alert("error");
				}*/
				//4.是将form做serialize() 
				type:"post",
				url:"saveEmployee1",
				data:form,
				//contentType:"application/json;charset=utf-8",
				success:function(data){
					//alert(data);
					if(data=="success"){
						$("#msg").html("保存用户成功!")
					}else{
						$("#msg").html("保存用户失败!")
					}
				},
				error:function(data){
					alert("error");
				}
			});
			return false;
		});
	});
</script>
</head>
<body>
	<form action="saveEmployee" method="post" id="addEmpForm">
		姓名:<input type="text" name="ename" id="enam" /><br/>
		工作:<input type="text" name="job" id="job"/><br/>
		部门:<select name="dept.deptNo">
			<c:forEach items="${requestScope.depts}" var="dept">
				<option value="${dept.deptNo}">${dept.dname}</option>
			</c:forEach>
		</select><br/>
		入职日期:<input type="text" name="hireDate" /><br/>
		工资:<input type="text" name="sal" id="sal" /><br />
		薪金:<input type="text" name="comm" id="comm"/><br />
		<input type="submit" value="提交"/><input type="reset" value="重置"/>		
	</form>
		<span id="msg" ></span>
</body>
</html>