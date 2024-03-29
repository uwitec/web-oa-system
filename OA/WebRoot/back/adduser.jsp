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
-->
</style>


		<SCRIPT type="text/javascript" src="<%=path%>/js/oa/jquery-1.7.2.js"></SCRIPT>
		<SCRIPT type="text/javascript" src="<%=path%>/js/oa/validate.js"></SCRIPT>
		<script type="text/javascript">
$(document).ready(function() {
	var ok = true;

	$("#userid").blur(function() {
		var userid = $(this).val();

		var params = 'userInfo.user.userid=' + userid;
		$.ajax( {
			url : 'checkuserid',
			type : 'post',
			dataType : 'json',
			data : params,
			success : callback
		});

	});
	$("#realname").blur(function() {
		ok1 = !isEmpty(this.value) && (byteLength(this.value) <= 16);
		if (!ok1) {
			$("#realnamespan").html("姓名不能为空且长度小于16");
		} else {
			$("#realnamespan").html("");
		}
	})
	function callback(json) {
		$("#useridspan").html(json.userInfo.message);
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





		<s:form action="adduser" method="post" namespace="/user">

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
					<td height="20" bgcolor="#FFFFFF" class="STYLE6" width="45%"
						align="right">
						用户名:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.userid" required="true"
							id="userid"></s:textfield>
					</td>
					<td height="20" width="30%" class="STYLE6">
						<span style="color: red" id="useridspan"><s:fielderror
								theme="simple">
								<s:param>userInfo.user.userid</s:param>
							</s:fielderror> </span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" bgcolor="#FFFFFF" class="STYLE6" width="45%"
						align="right">
						密码:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.password" value="888888"
							disabled="true"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						真实姓名:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.realname" id="realname"></s:textfield>
					</td>
					<td height="20" class="STYLE6">
						<span style="color: red" id="realnamespan"><s:fielderror
								theme="simple">
								<s:param>userInfo.user.realname</s:param>
							</s:fielderror> </span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						所属部门:
					</td>
					<td height="20" class="STYLE6">
						<s:select list="#session.departmentList"
							name="userInfo.user.department.dataid" listKey="dataid"
							listValue="dataname"></s:select>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						职务:
					</td>
					<td height="20" class="STYLE6">
						<s:select list="#session.jobList" listKey="dataid"
							listValue="dataname" name="userInfo.user.job.dataid"></s:select>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						城市:
					</td>
					<td height="20" class="STYLE6">
						<DIV class="nobr">
							<s:doubleselect doubleList="top.datas" doubleListKey="dataid"
								doubleListValue="dataname" list="#session.provinceList"
								doubleName="userInfo.user.city.dataid" listKey="dataid"
								listValue="dataname"></s:doubleselect>
						</DIV>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						角色:
					</td>
					<td height="20" class="STYLE6">
						<s:checkboxlist list="#session.roleList" listValue="rolename"
							listKey="roleid" value="" name="userInfo.user.roles"></s:checkboxlist>
					</td>
					<td height="20" class="STYLE6">
						<span style="color: red" id="useridspan"><s:fielderror>
								<s:param>userInfo.user.roles</s:param>
							</s:fielderror> </span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						性别:
					</td>
					<td height="20" class="STYLE6">
						<s:radio list="#{'1' : '男',  '0' : '女'}" listKey="key"
							listValue="value" value="1" name="userInfo.user.sex"></s:radio>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						身份证:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.idcard"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						电话:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.phone"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						手机:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.handset"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						电子邮件:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.email"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						地址:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield label="地址" name="userInfo.user.address"></s:textfield>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<TD colspan="3" align="center">
						<s:submit value="添加"></s:submit>
						&nbsp;&nbsp;&nbsp;
						<s:reset value="重置"></s:reset>
					</TD>
				</tr>
			</table>
		</s:form>
	</body>
</html>
