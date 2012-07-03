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

		<title>My JSP 'draft.jsp' starting page</title>

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
function deleteEmail(emailid, userid){
		if(confirm('确认删除?')){
			window.location.href = "<%=path%>/email/deleteEmail?userEmail.type=2&userEmail.id.email.emailid="+emailid+ "&userEmail.id.user.userid=" + userid;
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
													<td width="100%" valign="bottom" align="center">
														<span class="STYLE1"> 草稿箱</span>
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




			<tr>
				<td>
					<s:form id="form" action="email/getemail" method="post">
						<s:hidden name="userEmail.type" value="2"></s:hidden>
						<table width="100%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="#a8c7ce">
							<tr>
								<%--<td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
									<div align="center">
										<input type="checkbox" name="checkbox" id="checkbox" />
									</div>
								</td>
								--%>
								<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">发件人</span>
									</div>
								</td>
								<td width="29%" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">收件人</span>
									</div>
								</td>
								<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">主题</span>
									</div>
								</td>
								<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">附件</span>
									</div>
								</td>
								<td width="*" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">操作</span>
									</div>
								</td>

							</tr>

							<s:iterator value="#request.userEmails" var="userEmail">
								<tr>
									<%--
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<div align="center">
											<s:checkbox name="selectedEmails"
												fieldValue="%{#userEmail.id.email.emailid}"></s:checkbox>
										</div>
									</td>
									--%>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#userEmail.id.email.senduser.userid" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#userEmail.id.email.receusers" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#userEmail.id.email.title" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#userEmail.id.email.hasfile?'有附件':'没有附件'" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:a
											href="email/viewEmail?userEmail.id.email.emailid=%{#userEmail.id.email.emailid}&userEmail.type=3">编辑</s:a>
										<s:a
											href="javascript:deleteEmail('%{#userEmail.id.email.emailid}', '%{#session.user.userid}');">删除</s:a>
									</td>


								</tr>
							</s:iterator>
						</table>
					</s:form>
				</td>
			</tr>
		</table>
		<oa:pageTag />
		<s:debug></s:debug>
	</body>
</html>
