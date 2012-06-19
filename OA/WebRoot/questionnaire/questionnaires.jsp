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
														<span class="STYLE1"> 问卷管理</span>
													</td>
												</tr>
											</table>
										</td>
										<td>
											<div align="right">
												<span class="STYLE1">&nbsp;&nbsp; <a
													href="<%=path%>/questionnaire/selectQuestions!addQuestionnaireQueations"">
														<img src="questionnaire/images/add.gif" width="10"
															height="10" />添加问卷 &nbsp;</a> &nbsp;&nbsp;</span>
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
				<td align="center">
					<form action="questionnaire/selectAllQuestionnaire!selectAllQuestionnaire"
						method="post" name="form">
						标题：
						<s:textfield name="qname" size="30" theme="simple"></s:textfield>
						<input type="submit" value="查询" />
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						<tr>

							<td width="25%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">问卷标题</span>
								</div>
							</td>
							<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">问卷作者</span>
								</div>
							</td>
							<td width="15%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">问卷创作时间</span>
								</div>
							</td>
							<td width="25%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">问卷有效日期</span>
								</div>
							</td>
							<td width="5%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">问卷发布</span>
								</div>
							</td>
							<td width="20%" height="20" bgcolor="d3eaef" class="STYLE6">
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
											<s:property value="#questionnaire.qname" />
										</div>
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19">
										<div align="center">
											<s:property value="#questionnaire.user.userid" />
										</div>
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19">
										<div align="center">
											<s:date name="#questionnaire.createtime"
												format="yyyy-MM-dd HH:mm:ss" />

										</div>
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19">
										<div align="center">
											<s:date name="#questionnaire.startdate" format="yyyy-MM-dd" />
											到
											<s:date name="#questionnaire.stopdate" format="yyyy-MM-dd" />
											之间

										</div>
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19">
										<div align="center">
											<s:if test="#questionnaire.publish==1">
											已发布
											</s:if>
											<s:elseif test="#questionnaire.publish==0">
												<a href="">发布</a>
											</s:elseif>

										</div>
									</td>
									<td height="20" bgcolor="#FFFFFF">
										<div align="center">
											<span class="STYLE21"> <s:if
													test="#questionnaire.publish==0">
													<a
														href="<%=path%>/questionnaire/editQuestionnaire!delQuestionnaire?questionnaireid=<s:property value="#questionnaire.qid" />"
														onclick="return confirm('是否删除该问卷？')">删除 </a>
													<a
														href="<%=path%>/questionnaire/selectQuestionnaire!selectQuestionnaire?questionnaireid=<s:property value="#questionnaire.qid" />">修改问卷</a>
													<a
														href="<%=path%>/questionnaire/selectQuestionnaire!selectNaireQuestion?questionnaireid=<s:property value="#questionnaire.qid" />"
														target="_blank">修改问卷题库</a>
												</s:if> |<a
												href="<%=path%>/questionnaire/selectAllQuestionnaire!selectNaireQuestion?questionnaireid=<s:property value="#questionnaire.qid" />"
												target="_blank">预览</a> </span>
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
