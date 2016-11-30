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
			del.action = "";
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
					onclick="checkAll()"></td>
				<td align="center">编号</td>
				<td align="center">个人照片</td>
				<td align="center">用户名</td>
				<td align="center">登录密码</td>
				<td align="center">真实姓名</td>
				<td align="center">出生日期</td>
				<td align="center">身份证号码</td>
				<td align="center">手机号码</td>
				<td align="center">家庭住址</td>
				<td align="center">邮件地址</td>
				<td align="center">教育程度</td>
				<td align="center">专业</td>
				<td align="center">毕业院校</td>
				<td align="center">入职时间</td>
				<td align="center">角色名称</td>
				<td align="center">所属部门</td>


				<td align="center">操作</td>
			</tr>
			<c:choose>
				<c:when test="${not empty list }">
					<c:forEach items="${list}" var="emp" varStatus="status">
						<tr>
							<td><input type="checkbox" name="one"
								value="${emp.femp_id}"></td>
							<td align="center">${emp.femp_id}</td>
							<td align="center">${emp.femp_pic}</td>
							<td align="center">${emp.femp_username}</td>
							<td align="center">${emp.femp_password}</td>
							<td align="center">${emp.femp_realname}</td>
							<td align="center">${emp.femp_birthday}</td>
							<td align="center">${emp.femp_idcard}</td>
							<td align="center">${emp.femp_telephone}</td>
							<td align="center">${emp.femp_address}</td>
							<td align="center">${emp.femp_email}</td>
							<td align="center">${emp.femp_edu}</td>
							<td align="center">${emp.femp_major}</td>
							<td align="center">${emp.femp_school}</td>
							<td align="center">${emp.femp_intime}</td>
							<td align="center">${emp.femp_rolename}</td>
							<td align="center">${emp.fdepart_name}</td>
							
							<td align="center"><a
								href="empFindById.action?empId=${emp.femp_id }">修改</a>|<a
								href="empDeleteOne.action?empId=${emp.femp_id }">删除</a>
							</td>
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
					onclick="delAll()" value="全部删除">
				</td>
				<td align="center"><a href="empFindDepart.action">增加</a></td>
			</tr>
		</table>

	</form>
</body>
</html>
