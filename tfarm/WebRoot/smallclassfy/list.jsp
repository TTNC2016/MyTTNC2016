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

<title>My JSP 'list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script type="text/javascript">
	function checkAll() {
		var ones = document.getElementsByName("one");
		var all = document.getElementById("all");
		for ( var i = 0; i < ones.length; i++) {
			ones[i].checked = all.checked;
		}

	}

	function delAll() {
		var del = document.getElementById("form");
		var ones = document.getElementsByName("one");
		var c = 0;
		for ( var i = 0; i < ones.length; i++) {
			if (ones[i].checked)
				c++;

		}
		if (c > 0) {
			del.action = "deleteAll.action";
			del.submit();
		} else {
			alert("请先选中一个要删除的记录！");
		}
	}

	function add() {

	}
</script>

<body>
	<form action="" method="post" id="form">
		<table align="center">
			<tr>
				<td><input type="checkbox" id="all" name="all"
					onclick="checkAll()">
				</td>
				<td align="center">分类编号</td>
				<td align="center">分类名称</td>
				<td align="center">所属分类</td>
				<td align="center">创建时间</td>
				<td align="center">操作</td>
			</tr>
			<c:choose>
				<c:when test="${not empty list }">
					<c:forEach items="${list}" var="sclassfy" varStatus="status">
						<tr>
							<td><input type="checkbox" name="one"
								value="${sclassfy.fsclass_id}">
							</td>
							<td align="center">${sclassfy.fsclass_id}</td>
							<td align="center">${sclassfy.fsclass_name}</td>
							<td align="center">${sclassfy.fbclass_name}</td>
							<td align="center">${sclassfy.create_time}</td>
							<td align="center"><a
								href="sclassfyfindbyid.action?sclassId=${sclassfy.fsclass_id }">修改</a>|<a
								href="sclassfydeleteOne.action?bclassId=${sclassfy.fsclass_id}">删除</a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="5" align="center" style="color: red">没有数据</td>
					</tr>
				</c:otherwise>

			</c:choose>
			<tr>
				<td align="center"><input type="button" id="deleteall"
					onclick="delAll()" value="全部删除"></td>
				<td align="center"><a href="sclassfindBigClassAction.action">增加</a>
				</td>
			</tr>
		</table>

	</form>
</body>
</html>
