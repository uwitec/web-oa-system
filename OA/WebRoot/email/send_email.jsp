<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK"%>
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

		<title>My JSP 'send_email.jsp' starting page</title>

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



		<script type="text/javascript">
var i = 0;
function addMore() {
	if (i >= 3) {
		alert("������������");
		return false
	}
	;
	var td = document.getElementById("td");
	var br = document.createElement("br");
	var input = document.createElement("input");
	var button = document.createElement("input");
	input.name = "upload";
	input.type = "file";
	button.type = "button";
	button.value = "�Ƴ����ļ�" + i;

	button.onclick = function() {
		if (confirm("ȷ���Ƴ����ļ���")) {
			td.removeChild(br);
			td.removeChild(input);
			td.removeChild(button);
			i--;
		}
	}
	td.appendChild(br);
	td.appendChild(input);
	td.appendChild(button);
	i++;
}
</script>

		<script type="text/javascript">
function test() {
	//FCKȡֵ
	var checkContent = FCKeditorAPI
			.GetInstance("userEmail.id.email.strContent").GetXHTML();
	alert(checkContent);
}

function clearHtml() {
	//FCK��ֵ
	var editor = FCKeditorAPI.GetInstance("userEmail.id.email.strContent");
	editor.EditorDocument.body.innerHTML = "";
}
</script>


		<script>
//ѡ�к���
function selectChild(o) {
	//��ñ��˵���tr
	var otr = o.parentElement.parentElement;
	//����Ӳ˵���tr
	var otrmenu = otr.nextSibling;
	//�����Ӳ˵���checkbox
	for ( var i = 0; i < otrmenu.all.length; i++) {
		if (otrmenu.all[i].type == "checkbox") {
			otrmenu.all[i].checked = o.checked;
			//alert(otrmenu.all[i].nextSibling.nodeValue);
		}
	}
	selectuser();
}

//ѡ�и���(���ö���)
function selectParent(o) {
	//t=trueĬ���ҵ�
	var t = false;
	//��ñ��˵���tr
	var otr = o.parentElement.parentElement;
	//��ø��˵���tr
	var otrmenu = otr.previousSibling;
	//�����Ӳ˵���checkbox,��֤����ѡ
	for ( var i = 0; i < otr.all.length; i++) {
		if (otr.all[i].type == "checkbox" && otr.all[i].checked) {

			t = true;
			break;
		}
	}
	//���ø����checkbox״̬
	if (t) {
		for ( var i = 0; i < otrmenu.all.length; i++) {
			if (otrmenu.all[i].type == "checkbox") {
				otrmenu.all[i].checked = "checked";
				selectRoot(otrmenu.all[i]);
				break;
			}
		}
	} else {
		for ( var i = 0; i < otrmenu.all.length; i++) {
			if (otrmenu.all[i].type == "checkbox") {
				otrmenu.all[i].checked = "";
				selectRoot(otrmenu.all[i]);
				break;
			}
		}
	}

	selectuser();

}

//ѡ�и����(����һ��)
function selectRoot(o) {
	//t=trueĬ���ҵ�
	var t = false;
	//��ñ��˵���tr
	var otr = o.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement

	//��ø��˵���tr
	var otrmenu = otr.previousSibling;

	//�����Ӳ˵���checkbox,��֤�Ƿ�ȫѡ
	for ( var i = 0; i < otr.all.length; i++) {
		if (otr.all[i].type == "checkbox" && otr.all[i].checked) {
			t = true;
			break;
		}
	}
	//���ø����checkbox״̬
	if (t) {
		for ( var i = 0; i < otrmenu.all.length; i++) {
			if (otrmenu.all[i].type == "checkbox") {
				otrmenu.all[i].checked = "checked";
				break;
			}
		}
	} else {
		for ( var i = 0; i < otrmenu.all.length; i++) {
			if (otrmenu.all[i].type == "checkbox") {
				otrmenu.all[i].checked = "";
				break;
			}
		}
	}
	selectuser();
}
//�˵�����ʾ������
function setDisplay(o) {
	if (o.style.display == "") {
		o.style.display = "none";
	} else {
		o.style.display = "";
	}
}
</script>


		<SCRIPT type="text/javascript">
	function selectuser(){
		var all = document.getElementById("all");
	//��ñ��˵���tr
	var otr = all.parentElement.parentElement;
	//����Ӳ˵���tr
	var otrmenu = otr.nextSibling;
	//�����Ӳ˵���checkbox
	
	var userStr = "";
	var first = true;
	for ( var i = 0; i < otrmenu.all.length; i++) {
		
		if (otrmenu.all[i].type == "checkbox" && otrmenu.all[i].checked && otrmenu.all[i].name != "m11") {
			var value = otrmenu.all[i].nextSibling.nodeValue;
			if(!first){
				userStr += ";";
				
			}
				userStr += value;
				first = false;
			
		}
	}
	document.getElementById("receusers").value = userStr;

	}
	
	function sub(type){
		document.getElementById("type").value = type;
		document.form.submit();
	}
	function init(){
		var editor = FCKeditorAPI.GetInstance("userEmail.id.email.strContent");
		editor.EditorDocument.body.innerHTML = '<s:property value="#request.email.strContent"/>';
	}
</SCRIPT>


	</head>

	<body onload="javascript:init();">
		<form name="form" action='email/saveEmail' method="post"
			enctype="multipart/form-data">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="24" bgcolor="#353c44">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="94%" valign="bottom" align="center">
												<span class="STYLE1"> �����ʼ�</span>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

			<table align="center" width="100%" height="*" border="0"
				cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">

				<tr>
					<td width="20%" bgcolor="d3eaef" class="STYLE6" align="center"
						height="20px">
						�ռ���:
					</td>
					<td bgcolor="d3eaef" class="STYLE6">
						<s:textfield name="userEmail.id.email.receusers" id="receusers"
							readonly="true" value="%{#request.email.receusers}"
							cssStyle="width :60%"></s:textfield>
						<span style="color: red"><s:fielderror>
								<s:param>userEmail.id.email.receusers</s:param>
							</s:fielderror> </span>

					</td>
					<td width="20%" rowspan="4" height="100%" bgcolor="d3eaef"
						class="STYLE6" valign="top">
						<br/>
						<p align="center" style="font-size: 14px;">��ѡ���ռ���:</p>
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td bgcolor="d3eaef" class="STYLE6">
									<input type="checkbox" name="m1" onClick="selectChild(this);"
										id="all">
									<span onClick="setDisplay(m1_menu);" style="cursor: hand">ȫ��</span>
								</td>
							</tr>
							<tr id="m1_menu" style="">
								<td bgcolor="d3eaef" class="STYLE6">
									<table cellpadding="0" cellspacing="0">
										<s:iterator value="#session.departmentUsers" var="dept"
											status="s">
											<tr>
												<td bgcolor="d3eaef" class="STYLE6">
													&nbsp;&nbsp;
													<input type="checkbox" name="m11"
														onClick="selectChild(this);selectRoot(this);">
													<span
														onClick="setDisplay(name<s:property value='%{#s.index}'/>);"
														style="cursor: hand"><s:property
															value="#dept.dataname" /> </span>
												</td>
											</tr>
											<tr id="name<s:property value='%{#s.index}'/>">
												<td bgcolor="d3eaef" class="STYLE6">
													<s:iterator value="#dept.departmentUsers" var="user">
													&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="checkbox" name="m11_chk"
															onClick="selectParent(this);">
														<s:property value="#user.userid" />
													</s:iterator>
												</td>
											</tr>
										</s:iterator>

									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td bgcolor="d3eaef" class="STYLE6" align="center">
						����:
					</td>
					<td bgcolor="d3eaef" class="STYLE6">
						<s:textfield name="userEmail.id.email.title"
							value="%{#request.email.title}" cssStyle="width :60%"></s:textfield>

						<span style="color: red"> <s:fielderror>
								<s:param>userEmail.id.email.title</s:param>
							</s:fielderror> </span>

					</td>
				</tr>

				<tr>
					<Td colspan="2" id="td" bgcolor="d3eaef" class="STYLE6">
						<input type="button" value="��Ӹ���" onclick="addMore()" />
						<SPAN style="color: red"> <s:fielderror>
						<s:param>upload</s:param>
						<s:param>userEmail.id.email.strContent</s:param>
							</s:fielderror> </SPAN>
					</Td>
				</tr>
				<TR>
					<TD colspan="2" bgcolor="d3eaef" class="STYLE6">
						<s:hidden value="1" name="userEmail.type" id="type"></s:hidden>
						<input type="hidden" name="userEmail.id.email.content" value="">
						<FCK:editor id="userEmail.id.email.strContent" width="100%"
							height="320"
							fontNames="����;����;����;����_GB2312;Arial;Comic Sans MS;Courier 
New;Tahoma;Times New Roman;Verdana"
							imageBrowserURL="/FCKeditor-2.3/FCKeditor/editor/filemanager/browser/default/browser.html?
Type=Image&Connector=connectors/jsp/connector"
							linkBrowserURL="/FCKeditor-2.3/FCKeditor/editor/filemanager/browser/default/browser.html?
Connector=connectors/jsp/connector"
							flashBrowserURL="/FCKeditor-2.3/FCKeditor/editor/filemanager/browser/default/browser.html?
Type=Flash&Connector=connectors/jsp/connector"
							imageUploadURL="/FCKeditor-2.3/FCKeditor/editor/filemanager/upload/simpleuploader?Type=Image"
							linkUploadURL="/FCKeditor-2.3/FCKeditor/editor/filemanager/upload/simpleuploader?Type=File"
							flashUploadURL="/FCKeditor-2.3/FCKeditor/editor/filemanager/upload/simpleuploader?Type=Flash">
						</FCK:editor>
						<div align="center">
							<input type="button" value="����" onclick="sub(1)" />
							<input type="button" value="��ݸ�" onclick="sub(3);" />
							<input type="button" value="���" onclick="clearHtml();">
						</div>
					</td>
				</TR>

			</table>
		</form>
	</body>
</html>
