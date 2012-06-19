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
		<s:form action="" method="post">
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
					<td>
						<table width="100%" border="0">

							<s:iterator value="questionlist" var="questionoption">
								<s:iterator value="questionoption" var="question">
									<tr>

										<s:if test="#question.questionName!=null">


											<td width="95%" height="20" bgcolor="d3eaef" class="STYLE6">
												<div align="left">
													<span class="STYLE10"><s:property
															value="#question.questionName" /> </span>
													<s:set name="quesid" value="#question.questionId"></s:set>
													<s:set value="#question.questionType" var="qtype"></s:set>
												</div>
											</td>
										</s:if>
										<s:else>
											<td height="5">
												<table width="80%">
													<s:if test="#qtype==1">
														<tr>
															<td width="3%" height="3">
																<input type="radio" name="<s:property value="#quesid"/>" />
															</td>
															<td>
																<span class="STYLE10"><s:property
																		value="#question.potionName" /> </span>
															</td>
														</tr>
													</s:if>
													<s:elseif test="#qtype==2">
														<tr>
															<td width="3%" height="3">
																<input type="checkbox"
																	name="<s:property value="#quesid"/>" />
															</td>
															<td>
																<span class="STYLE10"><s:property
																		value="#question.potionName" /> </span>
															</td>
														</tr>
													</s:elseif>
													<s:elseif test="#qtype==3">
														<tr>
															<td colspan="2">
																<s:textarea rows="10" cols="20"></s:textarea>
															</td>
														</tr>
													</s:elseif>
												</table>
											</td>

										</s:else>




									</tr>
								</s:iterator>
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
				<tr>
					<td>
						<span class="STYLE10"><INPUT type="submit" value="提交" /></span>
					</td>
				</tr>
			</table>
		</s:form>
		<s:debug></s:debug>
	</body>
</html>
