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
			<s:form action="questionnaire/editQuestionnaire!updateQuestionnaire"
				method="post" theme="simple">
				<tr>
					<td align="center">
						创建问卷<s:hidden name="questionnaire.qid"></s:hidden>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%">
							<tr>
								<td align="right" width="10%">
									问卷名称
								</td>
								<td>
									<s:textfield name="questionnaire.qname" size="50"></s:textfield>
								</td>
							</tr>
							<tr>
								<td align="right" width="10%">
									问卷创建人
								</td>
								<td>
									<input type="text"
										value="<s:property value="#attr.username" />"
										disabled="disabled">

								</td>
							</tr>
							<tr>
								<td align="right" width="10%">
									问卷创建时间
								</td>
								<td>
									<s:textfield name="questionnaire.createtime"></s:textfield>
								</td>
							</tr>
							<tr>
								<td align="right" width="10%">
									问卷有效时间
								</td>
								<td>
									<sx:datetimepicker name="questionnaire.startdate"></sx:datetimepicker>
									到
									<sx:datetimepicker name="questionnaire.stopdate"></sx:datetimepicker>
								</td>
							</tr>
							<tr>
								<td align="right" width="10%">
									问卷说明
								</td>
								<td>
									<s:textarea cols="50" rows="5" name="questionnaire.explain"></s:textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr>
					<td align="center">
						<input type="submit" value="修改问卷" />
						<input type="reset" value="重置问卷" />
					</td>
				</tr>
			</s:form>
		</table>

	</body>
</html>
