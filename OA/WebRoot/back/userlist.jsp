<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/oa-tag" prefix="oa"%>
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

		<title>My JSP 'right.jsp' starting page</title>

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


		<SCRIPT type="text/javascript">
	function deleteUser(userid){
		if(confirm('ȷ��ɾ��?')){
			window.location.href = "<%=path%>/user/deluser?userInfo.user.userid=" + userid;
		}
	}
</SCRIPT>
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
													<td width="94%" valign="bottom">
														<span class="STYLE1"> ������Ա������Ϣ�б�</span>
													</td>
												</tr>
											</table>
										</td>
										<td>
											<div align="right">
												<span class="STYLE1"> <input type="checkbox"
														name="checkbox11" id="checkbox11" /> ȫѡ &nbsp;&nbsp;<img
														src="images/add.gif" width="10" height="10" /> ��� &nbsp;
													<img src="images/del.gif" width="10" height="10" /> ɾ��
													&nbsp;&nbsp;<img src="images/edit.gif" width="10"
														height="10" /> �༭ &nbsp;</span><span class="STYLE1">
													&nbsp;</span>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>














			<s:form action="user/userlist" method="post" id="form">
				<s:textfield label="�û���" name="userInfo.user.userid"></s:textfield>

				<s:textfield label="��ʵ����" name="userInfo.user.realname"></s:textfield>

				<s:select list="#request.departmentList" listKey="dataid"
					listValue="dataname" label="��������"
					name="userInfo.user.department.dataid" id="department">
				</s:select>
				<s:submit value="�ύ"></s:submit>
				<s:property value='#report.conversion.errors' />
			</s:form>
			<s:a action="user/preadd">����û�</s:a>
			
			<script>
var departmentObj = document.getElementById("department")
var optionObj = document.createElement("option");
optionObj.value = 0;
optionObj.text = "ȫ��";
optionObj.selected = true;
departmentObj.add(optionObj);
</script>


			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						<tr>
							<td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
								<div align="center">
									<input type="checkbox" name="checkbox" id="checkbox" />
								</div>
							</td>
							<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">�û���</span>
								</div>
							</td>
							<td width="15%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">��ʵ����</span>
								</div>
							</td>
							<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">����</span>
								</div>
							</td>
							<td width="16%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">ְ��</span>
								</div>
							</td>
							<td width="27%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">���ʱ��</span>
								</div>
							</td>
							<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">��������</span>
								</div>
							</td>
						</tr>

						<s:iterator value="#request.userInfo.userList" var="user">
							<tr>
								<td height="20" bgcolor="#FFFFFF">
									<div align="center">
										<input type="checkbox" name="checkbox2" id="checkbox2" />
									</div>
								</td>

								<td height="20" bgcolor="#FFFFFF" class="STYLE6">
									<div align="center">
										<span class="STYLE19"><s:property value="#user.userid" />
										</span>
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<s:property value="#user.realname" />
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<s:property value="#user.department.dataname" />
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<s:property value="#user.job.dataname" />
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF">
									<div align="center" class="STYLE21">
										<s:property value="#user.addtime" />
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF">
									<div align="center" class="STYLE21">
										<a
											href="user/getuser?userInfo.user.userid=<s:property value="#user.userid"/>">�鿴</a>|
										<a>�޸�</a>|
										<form name="deleteForm" method="post" action=""></form>
										<a
											href="javascript:deleteUser(<s:property value="#user.userid" />);">ɾ��</a>
									</div>
								</td>
							</tr>

						</s:iterator>

					</table>
				</td>
			</tr>
			<oa:pageTag />
		</table>
	</body>
</html>
