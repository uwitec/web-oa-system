<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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
		<s:form
			action="questionnaire/selectAllQuestionnaire!selectNaireQuestion"
			method="post" name="form">
			<s:hidden name="questionnaireid"></s:hidden>
		</s:form>
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
														<span class="STYLE1"> Œ æÌπ‹¿Ì</span>
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
				<td>
					<table width="100%" border="0">

						<s:iterator value="questionlist" var="questionoption" step="i">
							<TR>
								<td width="95%" height="20" bgcolor="d3eaef" class="STYLE6">
									<s:property value="#questionoption[0].questionName" />

								</td>
							</TR>
							<tr>
								<td width="3%" height="10">
									<br />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<s:if test="#questionoption[0].questionType==1">
										<s:radio list="#questionoption[1]"
											name="%{#questionoption[0].questionId}"></s:radio>
									</s:if>
									<s:elseif test="#questionoption[0].questionType==2">
										<s:checkboxlist list="#questionoption[1]"
											name="%{#questionoption[0].questionId}"></s:checkboxlist>
									</s:elseif>
									<s:elseif test="#questionoption[0].questionType==3">
										<s:textarea rows="10" cols="100%"></s:textarea>
									</s:elseif>
									<br />
									<br />
								</td>
							</tr>



						</s:iterator>




					</table>
				</td>
			</tr>
			<tr>
				<td>
					<span class="STYLE10"><s:property
							value="questionnaire.explain" /> </span>
				</td>
			</tr>
			<oa:pageTag />
		</table>

	</body>
</html>
