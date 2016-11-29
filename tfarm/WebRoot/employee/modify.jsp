<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form action="ownerUpdateAction.action" method="post">
		<table align="center" height="100" border="0" bordercolor="">
			<tr>
				<td align="right">编号</td>
				<td align="left"><input name="owner.ownerId"
					value="${map.fowner_id}" readonly="readonly">
				</td>
			</tr>

		<tr>
				<td align="right">姓名</td>
				<td align="left"><input name="owner.ownerName" value="${map.fowner_name }">
				</td>
			</tr>
			<tr>
			<td align="right">性别</td>
				<td align="left">
				
				<input type="radio" <c:if test="${map.fowner_sex=='男' }">checked="checked"</c:if>  name="owner.ownerSex" value="男">男
				<input type="radio"<c:if test="${map.fowner_sex=='女' }">checked="checked"</c:if>  name="owner.ownerSex" value="女">女
				</td>
			</tr>
			
			<tr>
				<td align="right">手机号码</td>
				<td align="left"><input name="owner.ownerTelephone" value="${map.fowner_telephone }">
				           </td>
			</tr>
			<tr>
				<td align="right">家庭住址</td>
				<td align="left"><input name="owner.ownerAddress" value="${map.fowner_address }">
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
