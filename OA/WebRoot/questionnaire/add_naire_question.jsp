<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Date date = new Date();
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
		<SCRIPT type="text/javascript" language="javascript"
			src="js/oa/jquery-1.7.2.js"></SCRIPT>
		<SCRIPT type="text/javascript">
		
		function selected(bool)
{
   var check=document.getElementsByName("questionid");
   for(var i=0;i<check.length;i++)
   {
       if(check[i].type="checkbox")
       {
          check[i].checked=bool;
       }
   }
}	
function checkqname(){
	var qname = document.getElementsByName("questionnaire.qname")[0].value;
	
	if(qname==null || qname.length<6){
		sqname.innerHTML = "*问卷名不能为空，问卷名最少6个字符*";
		return false;
	}
	sqname.innerHTML = "";
	return true;
	
}
function checkexplain(){
	var explain = document.getElementsByName("questionnaire.explain")[0].value;
	if(explain==null || explain.length<=0){
		sexplain.innerHTML = "*问卷说明不能为空*";
		return false;
	}
	sexplain.innerHTML = "";
	return true;
	
}
function checkdate(){
	var startdate = dojo.widget.byId("start").getValue();
	var stopdate = dojo.widget.byId("stop").getValue();
	
	if(stopdate.length==0 || stopdate.length == 0){
	sdate.innerHTML = "日期不能为空";
	return false;
	}
	sdate.innerHTML = "";
	return true;
}

 function checkall(){
 	var sqname = checkqname();
 	var explain = checkexplain();
 	var checkda = checkdate();
 	
 	return sqname&&explain&&checkda;
 	
 }  

	</SCRIPT>
	</head>
	<sx:head />
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
			<s:form action="questionnaire/addQuestionnaire!addQuestionnaire"
				method="post" theme="simple" onsubmit="return checkall()">
				<tr>
				<td align="center">
					<form action="question/selectQuestions!selectQuestions"
						method="post">
						题目：
						<s:textfield  name="question.questionName" size="30" theme="simple"></s:textfield>
						<s:select list="#{0:'题目类型',1:'单选题',2:'多选题',3:'解答题'}" name="question.questionType" theme="simple"></s:select>
						<input type="submit" value="查询" />
					</form>
				</td>
			</tr>
				
				<tr>
					<td align="center">
						
						<input type="button" value="全选" onclick="selected(true)" />
						<input type="button" value="全不选" onclick="selected(false)" />
					</td>
				</tr>
				<tr>
					<td>
						<table align="center" width="100%" border="1">
							<tr>
								<td width="10%" height="30" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">选择题目</span>
									</div>
								</td>

								<td height="30" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">题目</span>
									</div>
								</td>
								<td height="30" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">题目类型</span>
									</div>
								</td>
								<td width="12%" height="30" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">预览</span>
									</div>
								</td>


							</tr>
							<s:if test="questions.size()>0">
								<s:iterator value="questions" var="question">
									<tr>
										<td width="10%" align="right">
											<input type="checkbox" name="questionid"
												value="<s:property value='#question.questionId' />" />
										</td>

										<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="left">
											<div>
												<s:property value="#question.questionName" />
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF" class="STYLE19" width="10%">
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
												<span class="STYLE21"> <a
													href="<%=path%>/question/editQuestions!selectQuestion?questionid=<s:property value="#question.questionId"/>" target="_blank">
														预览</a> </span>
											</div>
										</td>


									</tr>


								</s:iterator>
							</s:if>
							<s:else>
								<tr>
									<td height="20" bgcolor="#FFFFFF" colspan="2">
										没有题目
									</td>
								</tr>
							</s:else>
						</table>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" value="添加" />
						<input type="reset" value="重置" />
					</td>
				</tr>
			</s:form>
		</table>

	</body>
</html>
