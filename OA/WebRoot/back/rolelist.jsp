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

		<script type="text/javascript" src="js/oa/jquery-1.7.2.js">
</script>

	

		<SCRIPT type="text/javascript">
	function deleteRole(rolename){
		if(confirm('确认删除?')){
			window.location.href = "<%=path%>/role/delrole?userInfo.role.username=" + rolename;
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
													<td width="94%" valign="bottom" align="center">
														<span class="STYLE1"> 角色列表</span>
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
			<s:form action="role/rolelist" method="post" id="form" theme="simple">
				<table width="100%" border="0" cellpadding="0" cellspacing="1">
					<tr>
						<TD height="20" bgcolor="d3eaef" class="STYLE6" align="center">
							角色名:
							<s:textfield label="用户名" name="userInfo.role.rolename"></s:textfield>
							&nbsp; &nbsp; &nbsp;
							<s:submit value="查询" />
						</TD>
					</tr>
				</table>
			</s:form>
			<!--
			<script>
var departmentObj = document.getElementById("department")
var optionObj = document.createElement("option");
optionObj.value = 0;
optionObj.text = "全部";
optionObj.selected = true;
departmentObj.add(optionObj);
</script>


			-->
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						<tr>
							<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">角色名</span>
								</div>
							</td>
							<td width="15%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">角色备注</span>
								</div>
							</td>
							
							
							<td width="18%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">基本操作[<s:a href="role/preadd">添加角色</s:a>]</span>
								</div>
							</td>
						</tr>

						<s:iterator value="#request.userInfo.roleList" var="role">
							<tr>

								<td height="20" bgcolor="#FFFFFF" class="STYLE6">
									<div align="center">
										<span class="STYLE19"><s:property value="#role.rolename" />
										</span>
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<s:property value="#role.roleinfo" />
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF">
									<div align="center" class="STYLE21">
										<a
											href="role/getrole?role.roleid=<s:property value="%{#role.roleid}"/>">查看</a>|
										<a
											href="role/preupdaterole?role.roleid=<s:property value="#role.roleid"/>">修改</a>|
										<a
											href="javascript:deleteRole('<s:property value='#role.roleid'/>')">删除</a>
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
