<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
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

<title>test页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<h1 align="center">分类添加页面</h1>
	<form action="bclassAddAction.action" method="post">
		<table align="center" height="100" border="0" bordercolor="">
			<tr>
				<td align="right">分类id</td>
				<td align="left"><input name="bclassfy.bclassId">
				</td>
			</tr>

			<tr>
				<td align="right">分类名称</td>
				<td align="left"><input name="bclassfy.bclassName">
				</td>
			</tr>
			
			<tr>
				<td align="center" colspan="2">
					<button type="submit">添加分类</button>
					<button type="reset">重置</button></td>
			</tr>

		</table>
	</form>

</body>
</html>
