<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示部门</title>
	<script type="text/javascript" src="easyui/jquery.min.js" ></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js" ></script>
	<link rel="stylesheet" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="easyui/themes/icon.css" />
</head>
<body>
	<div id="container" style="width:800px;height:600px;margin:0px auto;" >
		<div id="c_left" style="width:200px;height:600px; background-color:pink; float:left;">
			<ul  id="tree" class="easyui-tree">
			</ul>
		</div>
		<div id="c_right" style="width:600px;height:600px; background-color:yellow;float:right;"></div>
	</div>
	<script type="text/javascript" >
	$(function(){
		$('#tree').tree({
			checkbox: false,
			url:"getOrgByIdToNode?orgNo=520",
			lines: true,
			/* onBeforeExpand: function(node,param){                         
		        alert("aaaaaa");                  
		    }, */
			onLoadSuccess : function (node, data) {
			alert(data);
				/* if (data) {
					$(data).each(function (index, value) {
						if (this.state == 'closed') {
							$('#tree').tree('expandAll');
						}
					});
				} */
			}
			
		});
	});
	</script>
</body>
</html>