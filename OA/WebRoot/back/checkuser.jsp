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

		<title>My JSP 'checkuser.jsp' starting page</title>

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
															<span class="STYLE1">�鿴�û���Ϣ</span>
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

		<table width="100%" border="0" cellpadding="0" cellspacing="1"
			bgcolor="#a8c7ce">
			<tr>
				<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"
					colspan="3">
					<div align="center">
						<span class="STYLE10">�û���Ϣ</span>
					</div>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" bgcolor="#FFFFFF" class="STYLE6" width="45%"
					align="right">
					�û���:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.userid}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" bgcolor="#FFFFFF" class="STYLE6" width="45%"
					align="right">
					����:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.password}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					��ʵ����:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.realname}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					��������:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.department.dataname}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					ְ��:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.job.dataname}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					���ʱ��:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:date name="%{#request.singleuser.addtime}"
						format="yyyy-MM-dd hh:mm:ss" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					����:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.city.dataname}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					��ɫ:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:iterator value="%{#request.singleuser.roles}" var="role">
						<s:property value="#role.rolename" />&nbsp;
					</s:iterator>
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					�Ա�:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.sex ? '��' : 'Ů'}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					�Ƿ��ѻ�:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.married ? '�ѻ�' : 'δ��'}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					���֤:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.idcard}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					�绰:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.phone}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					�ֻ�:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.handset}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					�����ʼ�:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.email}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					��ַ:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:property value="%{#request.singleuser.address}" />
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
		</table>


	</body>
</html>
