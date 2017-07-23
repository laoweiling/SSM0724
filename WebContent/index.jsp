<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#ajax").click(function(){
			$.ajax({
				type: "GET",
				url:"showEmployees1",
				async:true ,
				//data: param,
				contentType:"json",
				success:function(data){
					var $table=$("<table border='1px'><tr><th>姓名</th><th>经理</th><th>日期</th></table>");
					for(var i=0;i<data.length;i++){
						var $tr=$("<tr></tr>");
						var $td0=$("<td></td>");
						var $td1=$("<td></td>");
						var $td2=$("<td></td>");
						$tr.append($td0);
						$tr.append($td1);
						$tr.append($td2);
						$table.append($tr);
						$td0.html(data[i].ename);
						$td1.html(data[i].mgr);
						$td2.html(data[i].hireDate)
					};
					$("#A3").append($table);				
					
				},
				error:function(data){
					alert("错误");
				}
			});
			return false;
		});
	})
</script>
</head>
<body>
	欢迎您来到湛江师范
	<br/>
	<a href="showEmployees">显示雇员人员名单</a>
	<a href="showEmployees1" onclick="return showEmployee();" >显示雇员人员名单</a><br/>
	<a href="showEmployees1" id="ajax">JQuery ajax显示雇员名单 </a><br />
	<a href="addEmployee2.jsp" >JQuery ajax操作 </a><br/>
	<a href="getOrgById?orgNo=520" >JQuery ajax操作 </a><br/>
	<a href="showOrg_ajax.jsp" >JQuery ajax操作 </a><br/>
	<p id="A1"></p>
	<p id="A2"></p>
	<p id="A3"></p>
</body>
<script type="text/javascript">
Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
		//生成ajax
		var xmlhttp;
		function loadXMLDoc(url)
		{
			xmlhttp=null;
			if (window.XMLHttpRequest){
				// code for IE7, Firefox, Opera, etc.
			  	xmlhttp=new XMLHttpRequest();
			}else if (window.ActiveXObject){
				// code for IE6, IE5
			  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			if (xmlhttp!=null){
			  xmlhttp.onreadystatechange=state_Change;
			  xmlhttp.open("GET",url,true);
			  xmlhttp.send(null);
			}else{
			  alert("Your browser does not support XMLHTTP.");
			}
		}
		//状态发变化时的回调函数
		function state_Change(){
			if (xmlhttp.readyState==4){// 4 = "loaded"
				if (xmlhttp.status==200){// 200 = "OK"
					//document.getElementById('A1').innerHTML=xmlhttp.status;
					//document.getElementById('A2').innerHTML=xmlhttp.statusText;
					//document.getElementById('A3').innerHTML=xmlhttp.responseText;
					var str="<table border='1px'><tr><th>姓名</th><th>经理</th><th>日期</th></tr>";
					var data=JSON.parse(xmlhttp.responseText);
					alert(data.length);
					for(var i=0;i<data.length;i++){
						str+="<tr><td>"+data[i].ename+"</td><td>"+(data[i].mgr==null?'':data[i].mgr.ename)+"</td><td>" +new Date(data[i].hireDate).Format('yyyy-MM-dd')+"</td></tr>"
						
					}
					document.getElementById("A3").innerHTML=str+"</table>";
				}else{
					alert("Problem retrieving XML data:" + xmlhttp.statusText);
				}
			}
		}
		function showEmployee(){
			loadXMLDoc("showEmployees1");
			return false;
		}
</script>
</html>