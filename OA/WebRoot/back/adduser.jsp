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

.border {
	border: 1px solid #D6F2F3;
	line-height: 24px;
}

.border_bottom {
	border-bottom: 1px solid #D6F2F3;
}

.border_both {
	border-right: 1px solid #D6F2F3;
	border-bottom: 1px solid #D6F2F3;
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
															<span class="STYLE1">����û�</span>
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


			<table width="100%" border="0" cellpadding="0" cellspacing="1"
				bgcolor="#a8c7ce">
				<tr>
					<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"
						colspan="3">
						<div align="center">
							<span class="STYLE10">�û���Ϣ�༭</span>
						</div>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" bgcolor="#FFFFFF" class="STYLE6" width="45%"
						align="right">
						�û���:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.userid" required="true"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" bgcolor="#FFFFFF" class="STYLE6" width="45%" align="right">
						����:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.password" value="888888"
							disabled="true"></s:textfield>
					</td>
					 <td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						��ʵ����:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.realname"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						��������:
					</td>
					<td height="20" class="STYLE6">
						<s:select list="#request.departmentList"
							name="userInfo.user.department.dataid" listKey="dataid"
							listValue="dataname"></s:select>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						ְ��:
					</td>
					<td height="20" class="STYLE6">
						<s:select list="#request.jobList" listKey="dataid"
							listValue="dataname" name="userInfo.user.job.dataid"></s:select>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						����:
					</td>
					<td height="20" class="STYLE6">
						<DIV class="nobr">
							<s:doubleselect doubleList="top.datas" doubleListKey="dataid"
								doubleListValue="dataname" list="#request.provinceList"
								doubleName="userInfo.user.city.dataid" listKey="dataid"
								listValue="dataname"></s:doubleselect>
						</DIV>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						��ɫ:
					</td>
					<td height="20" class="STYLE6">
						<DIV class="nobr">
							<s:checkboxlist list="#request.roleList" name="roles"
								listKey="roleid" listValue="rolename"></s:checkboxlist>
						</DIV>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						�Ա�:
					</td>
					<td height="20" class="STYLE6">
						<s:radio list="#{'1' : '��',  '0' : 'Ů'}" listKey="key"
							listValue="value" value="1"></s:radio>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						���֤:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.idcard"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						�绰:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.phone"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						�ֻ�:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.handset"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF" >
					<td height="20" class="STYLE6" width="45%" align="right">
						�����ʼ�:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.email"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						��ַ:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield label="��ַ" name="userInfo.user.address"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<TD colspan="3" align="center">
						<s:submit value="���"></s:submit>
						<s:reset value="����"></s:reset>
					</TD>
				</tr>
			</table>
		</s:form>












	</body>
</html>
