<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

		<title>My JSP 'adduser.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}

.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}

.STYLE24 {
	font-size: 14px;
}
-->
</style>



	</head>

	<body>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="24" bgcolor="#353c44">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>

													<td width="100%" valign="bottom">
														<div align="center">
															<span class="STYLE1">添加用户</span>
														</div>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>


		<s:form action="user/adduser" method="post" theme="simple">
			<table width="60%" height="100%" border="0" align="center">
				<tr>
					<td width="30%" height="20">
						<h1 align="right">
							用户名：
						</h1>
					</td>
					<td width="37%" height="20">
						<h1>
							<s:textfield name="userInfo.user.userid" required="true"></s:textfield>
						</h1>
					</td>
					<td width="33%" height="20">
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1 align="right">
							密码:
						</h1>
					</td>
					<td>
						<h1>
							<s:textfield name="userInfo.user.password" value="888888"
								disabled="true"></s:textfield>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1 align="right" class="STYLE24">
							真实姓名:
						</h1>
					</td>
					<td>
						<h1>
							<s:textfield name="userInfo.user.realname"></s:textfield>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1 align="right" class="STYLE24">
							所属部门
						</h1>
					</td>
					<td>
						<h1>
							<s:select list="#request.departmentList"
								name="userInfo.user.department.dataid" listKey="dataid"
								listValue="dataname"></s:select>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1 align="right" class="STYLE24">
							职务
						</h1>
					</td>
					<td>
						<h1>
							<s:select list="#request.jobList" listKey="dataid"
								listValue="dataname" name="userInfo.user.job.dataid"></s:select>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1 align="right" class="STYLE24">
							城市
						</h1>
					</td>
					<td>
						<h1>
							<s:doubleselect doubleList="top.datas" doubleListKey="dataid"
								doubleListValue="dataname" list="#request.provinceList"
								doubleName="userInfo.user.city.dataid" listKey="dataid"
								listValue="dataname"></s:doubleselect>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1 align="right" class="STYLE24">
							角色
						</h1>
					</td>
					<td>
						<h1>
							<s:checkboxlist list="#request.roleList" name="roles"
								listKey="roleid" listValue="rolename"></s:checkboxlist>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1 align="right" class="STYLE24">
							性别
						</h1>
					</td>
					<td>
						<h1>
							<s:radio list="#{'1' : '男',  '0' : '女'}" listKey="key"
								listValue="value" value="1"></s:radio>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1 align="right" class="STYLE24">
							身份证
						</h1>
					</td>
					<td>
						<h1>
							<s:textfield name="userInfo.user.idcard"></s:textfield>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1 align="right" class="STYLE24">
							联系电话
						</h1>
					</td>
					<td>
						<h1>
							<s:textfield name="userInfo.user.phone"></s:textfield>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1 align="right" class="STYLE24">
							手机
						</h1>
					</td>
					<td>
						<h1>
							<s:textfield name="userInfo.user.handset"></s:textfield>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1 align="right" class="STYLE24">
							电子邮件
						</h1>
					</td>
					<td>
						<h1>
							<s:textfield name="userInfo.user.email"></s:textfield>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td height="28">
						<h1 align="right" class="STYLE24">
							地址
						</h1>
					</td>
					<td>
						<h1>
							<s:textfield label="地址" name="userInfo.user.address"></s:textfield>
						</h1>
					</td>
					<td>
						<h1>
							&nbsp;
						</h1>
					</td>
				</tr>
				<tr>
					<td height="22">

						<div align="right"></div>
					</td>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
