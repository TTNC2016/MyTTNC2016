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
	<form action="empUpdateAction.action" method="post">
		<table align="center" height="100" border="0" bordercolor="">
			<tr>
				<td align="right">编号</td>
				<td align="left"><input name="emp.empId"
					value="${map.femp_id }">
				</td>
				<td align="right">个人照片</td>
				<td align="left"><input name="emp.empPic"
					value="${map.femp_pic }">
				</td>
			</tr>

			<tr>
				<td align="right">用户名</td>
				<td align="left"><input name="emp.empUsername"
					value="${map.femp_username }">
				</td>
				<td align="right">登陆密码</td>
				<td align="left"><input name="emp.empPassword"
					value="${map.femp_password }">
				</td>
			</tr>
			<tr>
				<td align="right">真实姓名</td>
				<td align="left"><input name="emp.empRealName"
					value="${map.femp_realname }">
				</td>
				<td align="right">出生日期</td>
				<td align="left"><input name="emp.empBirthday"
					value="${map.femp_birthday }">
				</td>
			</tr>

			<tr>
				<td align="right">身份证号码</td>
				<td align="left"><input name="emp.empIdCard"
					value="${map.femp_idcard }">
				</td>
				<td align="right">手机号码</td>
				<td align="left"><input name="emp.empTelephone"
					value="${map.femp_telephone }">
				</td>
			</tr>

			<tr>
				<td align="right">家庭住址</td>
				<td align="left"><input name="emp.empAddress"
					value="${map.femp_address }">
				</td>
				<td align="right">邮件地址</td>
				<td align="left"><input name="emp.empEmail"
					value="${map.femp_email }">
				</td>
			</tr>
			<tr>
				<td align="right">教育程度</td>
				<td align="left"><input name="emp.empEdu"
					value="${map.femp_edu }">
				</td>
				<td align="right">专业</td>
				<td align="left"><input name="emp.empMajor"
					value="${map.femp_major }">
				</td>
			</tr>
			<tr>
				<td align="right">毕业院校</td>
				<td align="left"><input name="emp.empSchool"
					value="${map.femp_school }">
				</td>
				<td align="right">入职时间</td>
				<td align="left"><input name="emp.empInTime"
					value="${map.femp_intime }">
				</td>
			</tr>
			<tr>
				<td align="right">角色名称</td>
				<td align="left"><input name="emp.empRoleName"
					value="${map.femp_rolename }">
				</td>
				<td align="right">所属部门</td>
				<td align="left"><select name="emp.departId"
					style="width: 150px">

						<c:forEach items="${list }" var="depart">

							<option value="${depart.fdepart_id }"
								<c:if test="${map.fdepart_id==depart.fdepart_id }">selected="selected"</c:if>>${depart.fdepart_name
								}</option>
						</c:forEach>
				</select>
				</td>
			</tr>

			<tr>
				<td align="center" colspan="2">
					<button type="submit">修改</button>
					<button type="reset">重置</button></td>
			</tr>

		</table>
	</form>
</body>
</html>
