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

		<title>My JSP 'addrole.jsp' starting page</title>

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

		<SCRIPT type="text/javascript" src="js/oa/jquery-1.7.2.js">
		</SCRIPT>
		<SCRIPT type="text/javascript" src="js/oa/jquery.validate.js">
		</SCRIPT>
		<script type="text/javascript">
$(document).ready(function() {
	var ok = true;

	$("#rolename").blur(function() {
		var rolename = $(this).val();

		var params = 'userInfo.role.rolename=' + rolename;
		$.ajax( {
			url : 'checkrolename',
			type : 'post',
			dataType : 'json',
			data : params,
			success : callback
		});

	});
	$("#roleinfo").blur(function() {
		var userinfo = $(this).val();
	});

	function callback(json) {
		$("#rolenamespan").html(json.userInfo.message);
	}
});
</script>
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
															<span class="STYLE1">添加角色</span>
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





		<s:form action="role/addrole" method="post" theme="simple"
			id="addrole">
			<table width="1158" border="0" cellpadding="0" cellspacing="1"
				bgcolor="#a8c7ce" height="375">
				<tr>
					<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"
						colspan="3">
						<div align="center">
							<span class="STYLE10">角色信息编辑</span>
						</div>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" bgcolor="#FFFFFF" class="STYLE6" width="45%"
						align="right">
						角色名:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.role.rolename" required="true"
							id="rolename"></s:textfield>
					</td>
					<td height="20" width="30%" class="STYLE6">
						<span style="color: red" id="useridspan"><s:fielderror
								theme="simple">
								<s:param>userInfo.role.rolename</s:param>
							</s:fielderror> </span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						备注信息:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.role.roleinfo" id="roleinfo"></s:textfield>
					</td>
					<td height="20" class="STYLE6">
						<span style="color: red" id="rolenamespan"><s:fielderror
								theme="simple">
								<s:param>userInfo.role.roleinfo</s:param>
							</s:fielderror> </span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<TD colspan="3" align="center">
						<s:submit value="添加"></s:submit>
						<s:reset value="重置"></s:reset>
					</TD>
				</tr>
			</table>
		</s:form>
	</body>
</html>
