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
													<td width="6%" height="19" valign="bottom">
														<div align="center">
															<img src="images/tb.gif" width="14" height="14" />
														</div>
													</td>
													<td width="100%" valign="bottom">
														<span class="STYLE1"> &nbsp;����û�</span>
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

		<s:form action="user/adduser" method="post">
			<s:textfield label="�û��� *" name="userInfo.user.userid"></s:textfield>
			<s:textfield label="����" name="userInfo.user.password" value="888888"
				disabled="true"></s:textfield>
			<s:textfield label="��ʵ���� *" name="userInfo.user.realname"></s:textfield>
			<s:select list="#request.departmentList" label="��������"
				name="userInfo.user.department.dataid" listKey="dataid"
				listValue="dataname"></s:select>
			<s:select list="#request.jobList" label="ְ��" listKey="dataid"
				listValue="dataname" name="userInfo.user.job.dataid"></s:select>
			<s:doubleselect label="����" doubleList="top.datas"
				doubleListKey="dataid" doubleListValue="dataname"
				list="#request.provinceList" doubleName="userInfo.user.city.dataid"
				listKey="dataid" listValue="dataname"></s:doubleselect>
				
			<s:checkboxlist list=""></s:checkboxlist>	
				
			<s:radio label="�Ա�" list="#{'1' : '��',  '0' : 'Ů'}" listKey="key"
				listValue="value" value="1"></s:radio>
			<s:textfield label="���֤ " name="userInfo.user.idcard"></s:textfield>
			<s:textfield label="����" name="userInfo.user.userid"></s:textfield>
			<s:textfield label="��ϵ�绰" name="userInfo.user.phone"></s:textfield>
			<s:textfield label="�ֻ�" name="userInfo.user.handset"></s:textfield>
			<s:textfield label="�����ʼ�" name="userInfo.user.email"></s:textfield>
			<s:textfield label="��ַ" name="userInfo.user.address"></s:textfield>
			<s:submit value="���"></s:submit>
			<s:reset value="����"></s:reset>
		</s:form>
	</body>
</html>
