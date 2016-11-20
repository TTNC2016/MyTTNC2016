<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		

		
		
		<hr />
		<br />
		<table border="1" width=100% bordercolor="#808000">
			<tr bgcolor=ffaa00>
				<td align="center" width=5%>
					<strong>a</strong>
				</td>
				<td align="center" width=5%>
					<strong>b</strong>
				</td>
				
			</tr>
			<c:choose>
				<c:when test="${not empty list}">
					<c:forEach items="${list}" var="order" varStatus="status">
						<tr>
							<td align="center">
								${order.a}
							</td>
							
							<td align="center">
								${order.b}
							</td>
							
							
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</table>
		
		<br>
		
		
	</body>
</html>
