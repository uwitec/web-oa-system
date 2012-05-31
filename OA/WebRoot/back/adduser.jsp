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

		<SCRIPT type="text/javascript" src="js/oa/jquery-1.7.2.js">
		</SCRIPT>
		<SCRIPT type="text/javascript" src="js/oa/jquery.validate.js">
		</SCRIPT>
		<script type="text/javascript">
$(document).ready(function() {
	var ok = true;

	$(function() {
		$("#adduser").validate( {
			errorClass : "error",
			submitHandler : function(form) {
				//如果想提交表单, 需要使用form.submit()而不要使用$(form).submit()
			form.submit();
		},
		rules : {
			//为name为email的控件添加两个验证方法:required()和email()
			userid : {
				required : true
			}
		},
		messages : {
			//为name为email的控件的required()和email()验证方法设置验证失败的消息内容
			userid : {
				required : "用户名必需"
			}
		}

		});
	});

	$("#userid").blur(function() {
		var userid = $(this).val();
		alert(userid);

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
		var realname = $(this).val();

	});

	function callback(json) {
		alert(json.userInfo.message);
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





		<s:form action="user/adduser" method="post" theme="simple"
			id="adduser">


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
						<span style="color: red" id="useridspan">111</span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" bgcolor="#FFFFFF" class="STYLE6" width="45%"
						align="right">
						密码:
					</td>
					<td height="20" class="STYLE6">
						<s:textfield name="userInfo.user.password" value="888888"
							disabled="true" dataType="requeired"></s:textfield>
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
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						所属部门:
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
						职务:
					</td>
					<td height="20" class="STYLE6">
						<s:select list="#request.jobList" listKey="dataid"
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
								doubleListValue="dataname" list="#request.provinceList"
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
						<DIV class="nobr">
							<s:checkboxlist list="#request.roleList" name="roles"
								listKey="roleid" listValue="rolename"></s:checkboxlist>
						</DIV>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						性别:
					</td>
					<td height="20" class="STYLE6">
						<s:radio list="#{'1' : '男',  '0' : '女'}" listKey="key"
							listValue="value" value="1"></s:radio>
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
						<s:reset value="重置"></s:reset>
					</TD>
				</tr>
			</table>
		</s:form>












	</body>
</html>
