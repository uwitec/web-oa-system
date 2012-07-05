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

		<title>My JSP 'update_user.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
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
															<span class="STYLE1">菜单信息修改</span>
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
						<span class="STYLE10">菜单信息编辑</span>
					</div>
				</td>
			</tr>
			<s:form action="updatemenu" namespace="/menu" method="post" id="updatemenu" name="updatemenu">
			<s:hidden value="%{#request.singlemenu.menuid}"
							name="userInfo.menu.menuid"></s:hidden>
			<tr bgcolor="#FFFFFF">
				<td height="20" bgcolor="#FFFFFF" class="STYLE6" width="45%"
					align="right">
					菜单名:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:textfield value="%{#request.singlemenu.menuname}" name="menuname" required="true" id="menuname" name="userInfo.menu.menuname"/>
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					菜单信息:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:textfield value="%{#request.singlemenu.menuinfo}" required="true" id="menuinfo" name="userInfo.menu.menuinfo"/>
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="20" class="STYLE6" width="45%" align="right">
					菜单链接:
				</td>
				<td height="20" class="STYLE6">
					&nbsp;
					<s:textfield value="%{#request.singlemenu.menulink}" required="true" id="menulink" name="userInfo.menu.menulink"/>
				</td>
				<td height="20" class="STYLE6"></td>
			</tr>
			<tr>
				<td></td>
				<td height="20" bgcolor="d3eaef" class="STYLE6" align="left">
					<s:submit value="提交" />
				</td>
			</tr>
			</s:form>
		</table>

	</body>
</html>
