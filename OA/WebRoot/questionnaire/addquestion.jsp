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
		<SCRIPT type="text/javascript" language="javascript"
			src="js/oa/jquery-1.7.2.js"></SCRIPT>
		<SCRIPT type="text/javascript">
		
		function addMore(){
			var div = document.getElementById("div");
			var input = document.createElement("input");
			var button = document.createElement("input");
			var br = document.createElement("br");
			input.type = "text";
			input.name="option";
			
			button.type = "button";
			button.value = "删除选项";
			//匿名内部函数
			input.onblur = function(){
					var questionname = this.value;
					if(questionname==null || questionname.length<=0){
						quesoption.innerHTML = "选项不能为空";
						return;
					}else{
						quesoption.innerHTML = "";
					}
						
			}
			
			button.onclick = function(){
				//方法里面可以直接调用上面定义的变量
				div.removeChild(input);
				div.removeChild(button);
				div.removeChild(br);
				quesoption.innerHTML = "";
			};
	
			div.appendChild(input);
			div.appendChild(button);
			div.appendChild(br);
			
		}	
		function disappear(){
			var questype = document.getElementsByName("question.questionType")
			for(var i=0;i<questype.length;i++){
				if(questype[i].checked){
					if(questype[i].value==3){
					$("#tbod").css("display","none");
					}else{
					$("#tbod").css("display","block");
					}
					
				}
			}
			
		}
		function checkquestionName(){
			var questionname = $("#questionname").val();
			
			if(questionname==null || questionname.length <6){
				
				 quesname.innerHTML="题目不能为空，且长度必须多余六个字符";
				 return false;
			}
			return true;
		}
		
		function check(){
			var quesname = checkquestionName();
			
			return quesname;
		}
	</SCRIPT>
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
														<span class="STYLE1"> </span>
													</td>
												</tr>
											</table>
										</td>
										<td>
											<div align="right">
												<span class="STYLE1">&nbsp;&nbsp;&nbsp;</span>
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
		
		<form
			action="question/editQuestions!addQuestion"
			method="post" onsubmit="return check()">
			<table border="0" width="100%" align="center">
			
			
				<s:hidden name="questionnaireid" value="%{#parameters.questionnaireid}"></s:hidden>
				<tr>
					<td>
						题目：
						<input type="text" name="question.questionName" size="50"
							id="questionname" onblur="checkquestionName()" />
						<br />


					</td>
					<td>
						<SPAN id="quesname"></SPAN>
					</td>

				</tr>
				<tr>
					<td>
						<s:radio list="#{1:'单选',2:'多选',3:'解答'}" value="1"
							onclick="disappear()" name="question.questionType" theme="simple"></s:radio>
					</td>

				</tr>
				<tbody id="tbod">
					<tr>
						<td>
							<input type="button" value="添加更多选项" onclick="addMore()" />
							<br>
						</td>
						<td>
							<SPAN id="quesoption"></SPAN>
						</td>

					</tr>
					<tr>
						<td id="div">

						</td>

					</tr>
				</tbody>
				<tr>
					<td>
						<s:submit label="提交按钮" value="提交" align="left"></s:submit>
					</td>
				</tr>
				<tr>
					<td>
						<s:fielderror fieldName="questionName"></s:fielderror>
					</td>
				</tr>
			</table>
		</form>
		<s:debug></s:debug>
	</body>
</html>
