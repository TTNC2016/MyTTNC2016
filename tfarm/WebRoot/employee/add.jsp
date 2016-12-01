<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>拥有人管理界面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="js/src/bootstrapDatepickr-1.0.0.css">
<script src="js/src/jquery-1.7.2.min.js"></script>
<script src="js/src/bootstrap.min.js"></script>
<script src="js/dist/bootstrapDatepickr-1.0.0.min.js"></script>
<script>

	$(document).ready(function() {
		//$("#calendar").bootstrapDatepickr();
		$("#calendar").bootstrapDatepickr({
			date_format : "Y-m-d"
		});
		$("#calendar1").bootstrapDatepickr({
			date_format : "Y-m-d"
		});
		//$("#calendar2").bootstrapDatepickr({date_format: "l, do F Y"});
	});
</script>
</head>

<body>
	<h1 align="center">拥有者添加页面</h1>
	<form action="empAddAction.action" method="post">
		<table align="center" height="100" border="0" bordercolor="">
			<tr>
				<td align="right">编号</td>
				<td align="left"><input name="emp.empId">
				</td>
				<td align="right">个人照片</td>
				<td align="left"><input name="emp.empPic">
				</td>
			</tr>
			
				<tr>
				<td align="right">用户名</td>
				<td align="left"><input name="emp.empUsername">
				</td>
				<td align="right">登陆密码</td>
				<td align="left"><input name="emp.empPassword">
				</td>
			</tr>
				<tr>
				<td align="right">真实姓名</td>
				<td align="left"><input name="emp.empRealName">
				</td>
				<td align="right">出生日期</td>
				<td align="left"><input id="calendar" name="emp.empBirthday">
				</td>
			</tr>
			
			<tr>
				<td align="right">身份证号码</td>
				<td align="left"><input name="emp.empIdCard">
				</td>
				<td align="right">手机号码</td>
				<td align="left"><input name="emp.empTelephone">
				</td>
			</tr>
			
			<tr>
				<td align="right">家庭住址</td>
				<td align="left"><input name="emp.empAddress">
				</td>
				<td align="right">邮件地址</td>
				<td align="left"><input name="emp.empEmail">
				</td>
			</tr>
				<tr>
				<td align="right">教育程度</td>
				<td align="left"><input name="emp.empEdu">
				</td>
				<td align="right">专业</td>
				<td align="left"><input name="emp.empMajor">
				</td>
			</tr>
				<tr>
				<td align="right">毕业院校</td>
				<td align="left"><input name="emp.empSchool">
				</td>
				<td align="right">入职时间</td>
				<td align="left"><input id="calendar1" name="emp.empInTime">
				</td>
			</tr>
				<tr>
				<td align="right">角色名称</td>
				<td align="left"><input name="emp.empRoleName">
				</td>
				<td align="right">所属部门</td>
				<td align="left">
				<select name="emp.departId" style="width: 150px">
				<c:forEach items="${list }" var="depart">
				<option value="${depart.fdepart_id }">${depart.fdepart_name }</option>
				</c:forEach>
				</select>
				
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
