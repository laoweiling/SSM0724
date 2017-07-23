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
			showEmps();
			return false;
		});		
	});
	function showEmps(){
		var $table=$("#showEmps");
		$.ajax({
			type:"GET",
			url:"showEmployees1",
			success:function(data){
				/*
				for(var i=0;i<length;i++){
					
				} */
				//data.each(function(){
				for(var i=0;i<data.length;i++){
					var $tr=$("<tr></tr>");
					var $td0=$("<td></td>");
					var $td1=$("<td></td>");
					var $td2=$("<td></td>");
					var $td3=$("<td></td>");
					$tr.append($td0).append($td1).append($td2).append($td3);
					$td0.html(data[i].ename);
					$td1.html(data[i].job);
					$td2.html(data[i].hireDate);
					$table.append($tr);
				}
			},
			error:function(data){
				alert("获得雇员信息失败")
			}
		});
	}
	window.onload=showEmps;
</script>
</head>
<body>
	<div style="margin:0px auto;width:400px;">
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
		<span style="background-color:red;size:10px;" id="msg" ></span>
	</div>
	<hr/>
	<div style="margin:0px auto;text-align:center;width:400px;">
	<table id="showEmps">
		<tr>
			<th>姓名</th>
			<th>工作</th>
			<th>入职日期</th>
			<th>操作</th>
		</tr>
	</table>
	</div>
		
</body>
</html>