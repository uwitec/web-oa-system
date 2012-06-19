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
														<span class="STYLE1"> 题目管理</span>
													</td>
												</tr>
											</table>
										</td>
										<td>
											<div align="right">
												<span class="STYLE1">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											</div>
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
					<table width="100%" border="0" bgcolor="#a8c7ce">
						<tr>
							<td>
								<span>题目</span>
							</td>

							<td width="95%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="left">
									<span class="STYLE10"><s:property
											value="question.questionName" /> <s:set
											value="question.questionType" var="qtype"></s:set> </span>
								</div>
							</td>


						</tr>
						<tr>
							<td>

								<s:iterator value="optionsset" var="option">
									<s:if test="#qtype==1">
										<tr>

											<td height="20" bgcolor="#FFFFFF" class="STYLE19">
												<div align="center">
													<input type="radio" name="answer" />
												</div>
											</td>

											<td height="20" bgcolor="#FFFFFF">
												<div align="left">
													<span class="STYLE21"><s:property
															value="#option.potionName" /> </span>
												</div>
											</td>
										</tr>
									</s:if>
									<s:if test="#qtype==2">
										<tr>

											<td height="20" bgcolor="#FFFFFF" class="STYLE19">
												<div align="center">
													<input type="checkbox" name="answer" />
												</div>
											</td>

											<td height="20" bgcolor="#FFFFFF">
												<div align="left">
													<span class="STYLE21"><s:property
															value="#option.potionName" /> </span>
												</div>
											</td>
										</tr>
									</s:if>
									<s:elseif test="#qtype==3">
										<tr>
											<td colspan="2">
												<s:textarea rows="10" cols="20" name="answ"></s:textarea>
											</td>
										</tr>
									</s:elseif>
								</s:iterator>
					</table>
				</td>
			</tr>

		</table>
	</body>
</html>
