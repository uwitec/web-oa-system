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

		<title>My JSP 'self_update.jsp' starting page</title>

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

.error {
	font-size: 12px;
	color: red
}
-->
</style>


		<SCRIPT type="text/javascript" src="<%=path%>/js/oa/jquery-1.7.2.js"></SCRIPT>
		<SCRIPT type="text/javascript" src="<%=path%>/js/oa/validate.js"></SCRIPT>


		<SCRIPT type="text/javascript">
			var submit;
			var ok1 = true;
			var ok2 = true;
			var ok3 = true;
			var ok4 = true;
			var ok5 = true;
			var ok6 = true;
			$(document).ready(function(){
				$("#realname").blur(function(){
					ok1 = !isEmpty(this.value) && (byteLength(this.value) <= 16);
					if(!ok1){
						$("#realnamespan").html("姓名不能为空且长度小于16");
					} else {
						$("#realnamespan").html("");
					}
				})
				
				$("#idcard").blur(function(){
					ok2 = isCard(this.value) || isEmpty(this.value);
					if(!ok2){
						$("#idcardspan").html("身份证号码不正确");
					} else {
						$("#idcardspan").html("");
					}
				})
				
				$("#phone").blur(function(){
					ok3 = isPhone(this.value) || isEmpty(this.value);
					if(!ok3){
						$("#phonespan").html("电话号码不正确");
					} else {
						$("#phonespan").html("");
					}
				})
				
				$("#handset").blur(function(){
					ok4 = isMobile(this.value) || isEmpty(this.value);
					if(!ok4){
						$("#handsetspan").html("手机号码不正确");
					} else {
						$("#handsetspan").html("");
					}
				})
				
				$("#email").blur(function(){
					ok5 = isEmail(this.value) || isEmpty(this.value);
					if(!ok5){
						$("#emailspan").html("邮件格式不正确");
					} else {
						$("#emailspan").html("");
					}
				})
				$("#address").blur(function(){
					ok6 = trim(this.value).length <= 100;
					if(!ok6){
						$("#addressspan").html("地址不大于100个字");
					} else {
						$("#addressspan").html("");
					}
				})
				
				$("#sub").click(function(){
					submit = ok1 & ok2 & ok3 & ok4 & ok5 & ok6;
					if(submit == true){
						window.form.submit();
					} else {
						alert("信息填写不正确");
					}
				})
			});
			
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

		<s:form method="post" action="user/selfupdate" id="form" name="form">
			<table width="100%" border="0" cellpadding="0" cellspacing="1"
				bgcolor="#a8c7ce">
				<s:hidden value="%{#request.singleuser.userid}"
					name="userInfo.user.userid"></s:hidden>
				<tr>
					<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"
						colspan="3">
						<div align="center">
							<span class="STYLE10">用户信息编辑</span>
						</div>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						真实姓名:
					</td>
					<td height="20" class="STYLE6">
						&nbsp;
						<s:textfield value="%{#request.singleuser.realname}"
							name="userInfo.user.realname" id="realname"></s:textfield>
					</td>
					<td height="20" class="STYLE6" width="40%">
						<span id="realnamespan" class="error"></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						性别:
					</td>
					<td height="20" class="STYLE6">
						&nbsp;
						<s:radio list="#{'1' : '男' , '0' : '女'}" listKey="key"
							listValue="value" value="%{#request.singleuser.sex}"
							name="userInfo.user.sex"></s:radio>
					</td>
					<td height="20" class="STYLE6"></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						身份证:
					</td>
					<td height="20" class="STYLE6">
						&nbsp;
						<s:textfield value="%{#request.singleuser.idcard}"
							name="userInfo.user.idcard" id="idcard"></s:textfield>
					</td>
					<td height="20" class="STYLE6">
						<span id="idcardspan" class="error"></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						电话:
					</td>
					<td height="20" class="STYLE6">
						&nbsp;
						<s:textfield value="%{#request.singleuser.phone}"
							name="userInfo.user.phone" id="phone"></s:textfield>
					</td>
					<td height="20" class="STYLE6">
						<span id="phonespan" class="error"></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						手机:
					</td>
					<td height="20" class="STYLE6">
						&nbsp;
						<s:textfield value="%{#request.singleuser.handset}"
							name="userInfo.user.handset" id="handset"></s:textfield>
					</td>
					<td height="20" class="STYLE6">
						<span id="handsetspan" class="error"></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						电子邮件:
					</td>
					<td height="20" class="STYLE6">
						&nbsp;
						<s:textfield value="%{#request.singleuser.email}"
							name="userInfo.user.email" id="email"></s:textfield>
					</td>
					<td height="20" class="STYLE6">
						<span id="emailspan" class="error"></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="STYLE6" width="45%" align="right">
						地址:
					</td>
					<td height="20" class="STYLE6">
						&nbsp;
						<s:textfield value="%{#request.singleuser.address}"
							name="userInfo.user.address" id="address"></s:textfield>
					</td>
					<td height="20" class="STYLE6">
						<span id="addressspan" class="error"></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<TD colspan="3" align="center">
						<input type="button" id="sub" value="提交" />
						&nbsp;&nbsp;
						<input type="reset" value="重置" />
					</TD>
				</tr>
			</table>
		</s:form>
	</body>
</html>
