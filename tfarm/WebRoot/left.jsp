<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'left.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<body>
	<h1 align="center" style="background-color: #339966">导航栏</h1>
	<table align="center" cellpadding="6">
		<tr>
			<td align="center" style="font-size: 24;background-color: #aabbcc">大分类管理</td>
		</tr>
		<tr>
			<td align="center" style="font-size: 16"><a
				href="bigclassfy/add.j
				sp" target="main">分类添加</a></td>
		</tr>
		<tr>
			<td align="center" style="font-size: 16"><a
				href="bclassfyAll.action" target="main">分类列表</a></td>
		</tr>

		<tr>
			<td align="center" style="font-size: 24;background-color: #aabbcc">小分类管理</td>
		</tr>
		<tr>
			<td align="center" style="font-size: 16"><a
				href="sclassfindBigClassAction.action" target="main">分类添加</a></td>
		</tr>
		<tr>
			<td align="center" style="font-size: 16"><a
				href="sclassfyAll.action" target="main">分类列表</a></td>
		</tr>



		<tr>
			<td align="center" style="font-size: 24;background-color: #aabbcc">擁有者管理</td>
		</tr>
		<tr>
			<td align="center" style="font-size: 16"><a
				href="owner/add.jsp" target="main">擁有者添加</a></td>
		</tr>
		<tr>
			<td align="center" style="font-size: 16"><a
				href="ownerFindAll.action" target="main">擁有者列表</a></td>
		</tr>
		
		
		
		<tr>
			<td align="center" style="font-size: 24;background-color: #aabbcc">部门管理</td>
		</tr>
		<tr>
			<td align="center" style="font-size: 16"><a
				href="department/add.jsp" target="main">部门添加</a></td>
		</tr>
		<tr>
			<td align="center" style="font-size: 16"><a
				href="departFindAll.action" target="main">部门列表</a></td>
		</tr>
		
		<tr>
			<td align="center" style="font-size: 24;background-color: #aabbcc">员工管理</td>
		</tr>
		<tr>
			<td align="center" style="font-size: 16"><a
				href="empFindDepart.action" target="main">员工添加</a></td>
		</tr>
		<tr>
			<td align="center" style="font-size: 16"><a
				href="empFindAll.action" target="main">员工列表</a></td>
		</tr>
		
		
		
	</table>

</body>
</html>
