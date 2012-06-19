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
														<span class="STYLE1"> 题目管理</span>
													</td>
												</tr>
											</table>
										</td>
										<td>
											<div align="right">
												<span class="STYLE1">&nbsp;&nbsp;<a
													href="<%=path%>/questionnaire/addquestion.jsp"> 添加题目
														&nbsp;</a> &nbsp;&nbsp;</span>
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
					<form action="question/selectQuestions!selectQuestions"
						method="post" name="form">
						题目：
						<s:textfield  name="question.questionName" size="30" theme="simple"></s:textfield>
						<s:select list="#{0:'题目类型',1:'单选题',2:'多选题',3:'解答题'}" name="question.questionType" theme="simple"></s:select>
						<input type="submit" value="查询" />
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						<tr>

							<td width="80%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">题目</span>
								</div>
							</td>
							<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">题目类型</span>
								</div>
							</td>
							<td width="10%" height="30" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">基本操作</span>
								</div>
							</td>
						</tr>
						<s:if test="questions.size()>0">


							<s:iterator value="questions" var="question">
								<tr>

									<td height="20" bgcolor="#FFFFFF" class="STYLE19">
										<div align="center">
											<s:property value="#question.questionName" />
										</div>
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19">
										<div align="center">
											<s:if test="#question.questionType==1">
											单选
											</s:if>
											<s:elseif test="#question.questionType==2">多选</s:elseif>
											<s:elseif test="#question.questionType==3">解答</s:elseif>
										</div>
									</td>
									<td height="20" bgcolor="#FFFFFF">
										<div align="center">
											<span class="STYLE21"><a
												href="<%=path%>/question/editQuestions!delQuestion?questionid=<s:property value="#question.questionId" />"  onclick="return confirm('是否删除该问题')">删除</a>
												|<a
												href="<%=path%>/question/editQuestions!selectQuestion?questionid=<s:property value="#question.questionId" />" target="_blank">查看</a>
											</span>
										</div>
									</td>
								</tr>


							</s:iterator>
						</s:if>
						<s:else>
							<tr>
								<td height="20" bgcolor="#FFFFFF" colspan="9">
									没有题目
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
