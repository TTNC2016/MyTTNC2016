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
	<form action="sclassfyUpdateAction.action" method="post">
		<table align="center" height="100" border="0" bordercolor="">
			<tr>
				<td align="right">分类id</td>
				<td align="left"><input name="sclassfy.sclassfyId"
					value="${map.fsclass_id}" readonly="readonly">
				</td>
			</tr>

			<tr>
				<td align="right">分类名称</td>
				<td align="left"><input name="sclassfy.sclassfyName"
					value="${map.fsclass_name}">
				</td>
			</tr>

			<tr>
				<td align="right">所属分类</td>
				<td align="left"><select name="sclassfy.bclassId"
					style="width: 150px">
						<c:forEach items="${list}" var="bigclassfy">
							<option value="${bigclassfy.fbclass_id}"
								<c:if test="${map.fbclass_id==bigclassfy.fbclass_id }">selected="selected" </c:if>>${bigclassfy.fbclass_name
								}</option>
						</c:forEach>
				</select>
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
