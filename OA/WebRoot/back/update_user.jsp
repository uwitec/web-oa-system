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

		<title>My JSP 'update_user.jsp' starting page</title>

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

.STYLE6 {
	color: #000000;
	font-size: 12;
}

.STYLE10 {
	color: #000000;
	font-size: 12px;
}

.STYLE19 {
	color: #344b50;
	font-size: 12px;
}

.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}

.STYLE22 {
	font-size: 12px;
	color: #295568;
}

.nobr br {
	display: none
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
															<span class="STYLE1">用户信息修改</span>
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
		<s:form method="post" action="updateuser" namespace="/user">

			<s:hidden value="%{#request.singleuser.userid}" name="userInfo.user.userid"></s:hidden>

			<table width="100%" border="0" cellpadding="0" cellspacing="1"
				bgcolor="#a8c7ce">
				<tr>
					<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"
						colspan="3">
						<div align="center">
							<span class="STYLE10">用户信息编辑</span>
						</div>
					</td>
				</tr>

				<tr bgcolor="#FFFFFF">
					<td height="20" bgcolor="#FFFFFF" class="STYLE6" width="10%"
						align="right">
						用户名:
					</td>
					<td height="20" class="STYLE6" width="35%">
						&nbsp;
						<s:property value="%{#request.singleuser.userid}" />
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						所属部门:
					</td>
					<td height="20" class="STYLE6">
						&nbsp;
						<s:select list="#session.departmentList"
							name="userInfo.user.department.dataid" listKey="dataid"
							listValue="dataname"
							value="%{#request.singleuser.department.dataid}"></s:select>

					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						职务:
					</td>
					<td height="20" class="STYLE6">
						&nbsp;
						<s:select list="#session.jobList" listKey="dataid"
							listValue="dataname" name="userInfo.user.job.dataid"
							value="%{#request.singleuser.job.dataid}"></s:select>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						角色:
					</td>
					<td height="20" class="STYLE6">
						&nbsp;
						<s:checkboxlist list="#session.roleList"
							name="userInfo.user.roles" listKey="roleid" listValue="rolename"
							value="#request.selectedRoles"></s:checkboxlist>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td colspan="3" class="STYLE6" align="center">
						<s:submit value="修改"></s:submit>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<s:reset value="重置"></s:reset>
					</td>
				</tr>
			</table>
		</s:form>

	</body>
</html>
