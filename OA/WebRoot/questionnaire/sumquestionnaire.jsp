<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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

		<title>My JSP 'index.jsp' starting page</title>
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

		<table width="100%" border="0" align="center">
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
														<span class="STYLE1"> 问卷管理</span>
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
				<td align="center">
					<h1>
						<s:property value="questionnaire.qname" />
					</h1>
				</td>
			</tr>
			<tr>
				<td align="right">
					共有
					<s:property value="sumcount" />
					人参加问卷调查

				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0">

						<s:iterator value="questionnaires" var="questionoption">
							<tr>
								<td>
									<s:property value="#questionoption[0].questionName" />
								</td>
							</tr>
							<tr>
								<td>
									<table width="100%" border="0">
										<s:iterator value="#questionoption[1]" var="optionsum">
											<tr>
												<s:if test="#questionoption[0].questionType==1">
													<td>
														<input type="radio" name="#questionoption[0].optionId" />
													</td>
												</s:if><s:elseif test="#questionoption[0].questionType==2">
												<td>
														<input type="checkbox" name="#questionoption[0].optionId" />
													</td>
												</s:elseif>
												<td width="60%">
													<s:property value="#optionsum[0].potionName" />
												</td>
												<td width="40%">
													<s:property value="#optionsum[1]" />
												</td>
											</tr>
										</s:iterator>
									</table>
								</td>
							</tr>
						</s:iterator>

					</table>
				</td>
			</tr>
<oa:pageTag />
			<tr>
				<td>
					<span class="STYLE10"><s:property
							value="questionnaire.explain" /> </span>
				</td>
			</tr>

		</table>

	</body>
</html>
