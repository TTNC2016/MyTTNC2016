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

<title>My JSP 'modify.jsp' starting page</title>

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
	<form action="bclassUpdateAction.action" method="post">
		<table align="center" height="100" border="0" bordercolor="">
			<tr>
				<td align="right">分类id</td>
				<td align="left"><input name="bclassfy.bclassId"
					value="${map.fbclass_id }" readonly="readonly">
				</td>
			</tr>

			<tr>
				<td align="right">分类名称</td>
				<td align="left"><input name="bclassfy.bclassName"
					value="${map.fbclass_name}">
				</td>
			</tr>

			<tr>
				<td align="center" colspan="2">
					<button type="submit">修改分类</button>
					<button type="reset">重置</button></td>
			</tr>

		</table>
	</form>
</body>
</html>
