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
													<td width="6%" height="19" valign="bottom">
														<div align="center">
															<img src="images/tb.gif" width="14" height="14" />
														</div>
													</td>
													<td width="94%" valign="bottom">
														<span class="STYLE1"> </span>
													</td>
												</tr>
											</table>
										</td>
										<td>
											<div align="right">
												<span class="STYLE1">&nbsp;&nbsp; &nbsp;&nbsp;</span>
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
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						<tr>

							<td width="60%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">问卷标题</span>
								</div>
							</td>
							<td width="20%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">问卷有效日期</span>
								</div>
							</td>
							<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">问答情况</span>
								</div>
							</td>
							<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">基本操作</span>
								</div>
							</td>
						</tr>
						<s:if test="questionnaires.size()>0">


							<s:iterator value="questionnaires" var="questionnaire">
								<tr>

									<td height="20" bgcolor="#FFFFFF" class="STYLE19">
										<div align="center">
											<s:property value="#questionnaire[0].qname" />
										</div>
									</td>

									<td height="20" bgcolor="#FFFFFF" class="STYLE19">
										<div align="center">
											<s:date name="#questionnaire[0].startdate"
												format="yyyy-MM-dd" />
											到
											<s:date name="#questionnaire[0].stopdate" format="yyyy-MM-dd" />
											之间
										</div>
									</td>
									<td height="20" bgcolor="#FFFFFF">
										<div align="center">
											<span class="STYLE21"><s:if
													test="#questionnaire[1].naireAnswer==1">已作答</s:if> <s:elseif
													test="#questionnaire[1].naireAnswer==0">未作答</s:elseif> </span>
										</div>
									</td>
									<td height="20" bgcolor="#FFFFFF">
										<div align="center">
											<span class="STYLE21"><s:if
													test="#questionnaire[1].naireAnswer==1">
													<a
														href="<%=path%>/userquestionnaire/selectUserQuestions!selectUserQuestionnaire?questionnaireid=<s:property value="#questionnaire[0].qid" /> " target="_blank">查看</a>
												</s:if> <s:elseif test="#questionnaire[1].naireAnswer==0">
													<a
														href="<%=path%>/userquestionnaire/answerQuestionnaire!answerQuestionnaire?questionnaireid=<s:property value="#questionnaire[0].qid" /> ">问答</a>
												</s:elseif> </span>
										</div>
									</td>
								</tr>

							</s:iterator>
						</s:if>
						<s:else>
							<tr>
								<td height="20" bgcolor="#FFFFFF" colspan="9">
									没有问卷
								</td>
							</tr>
						</s:else>


					</table>
				</td>
			</tr>
			<oa:pageTag />
		</table>
	</body>
</html>
