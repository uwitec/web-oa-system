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
		<script type="text/javascript">
var i = 1;
function addMore() {
	if (i >= 3) {
		alert("超过三个附件");
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
	button.value = "移除该文件" + i;

	button.onclick = function() {
		if (confirm("确定移除该文件吗")) {
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
	//FCK取值
	var checkContent = FCKeditorAPI
			.GetInstance("userEmail.id.email.strContent").GetXHTML();
	alert(checkContent);
}

function clearHtml() {
	//FCK赋值
	var editor = FCKeditorAPI.GetInstance("userEmail.id.email.strContent");
	editor.EditorDocument.body.innerHTML = "";
}
</script>


		<script>
//选中孩子
function selectChild(o) {
	//获得本菜单的tr
	var otr = o.parentElement.parentElement;
	//获得子菜单的tr
	var otrmenu = otr.nextSibling;
	//遍历子菜单的checkbox
	for ( var i = 0; i < otrmenu.all.length; i++) {
		if (otrmenu.all[i].type == "checkbox") {
			otrmenu.all[i].checked = o.checked;
			//alert(otrmenu.all[i].nextSibling.nodeValue);
		}
	}
	selectuser();
}

//选中父类(适用二级)
function selectParent(o) {
	//t=true默认找到
	var t = false;
	//获得本菜单的tr
	var otr = o.parentElement.parentElement;
	//获得父菜单的tr
	var otrmenu = otr.previousSibling;
	//遍历子菜单的checkbox,验证是有选
	for ( var i = 0; i < otr.all.length; i++) {
		if (otr.all[i].type == "checkbox" && otr.all[i].checked) {

			t = true;
			break;
		}
	}
	//设置父类的checkbox状态
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

//选中根点节(适用一级)
function selectRoot(o) {
	//t=true默认找到
	var t = false;
	//获得本菜单的tr
	var otr = o.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement

	//获得父菜单的tr
	var otrmenu = otr.previousSibling;

	//遍历子菜单的checkbox,验证是否全选
	for ( var i = 0; i < otr.all.length; i++) {
		if (otr.all[i].type == "checkbox" && otr.all[i].checked) {
			t = true;
			break;
		}
	}
	//设置父类的checkbox状态
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
//菜单的显示与隐藏
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
	//获得本菜单的tr
	var otr = all.parentElement.parentElement;
	//获得子菜单的tr
	var otrmenu = otr.nextSibling;
	//遍历子菜单的checkbox
	
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
</SCRIPT>


	</head>

	<body>
		<SPAN><s:fielderror></s:fielderror> </SPAN>
		<form name="form" action='email/saveEmail' method="post"
			enctype="multipart/form-data">
			<table align="center" width="100%" height="80%" border="1">
				<tr>
					<td width="20%">
						收件人:
					</td>
					<td>
						<s:textfield name="userEmail.id.email.receusers" id="receusers"
							readonly="true"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						主题:
					</td>
					<td>
						<s:textfield name="userEmail.id.email.title"></s:textfield>
					</td>
				</tr>
				<tr>
					<Td colspan="2" id="td">
						<input type="button" value="添加附件" onclick="addMore()" />
					</Td>
				</tr>
				<TR>
					<TD colspan="1" width="80%">
						<s:hidden value="1" name="userEmail.type" id="type"></s:hidden>
						<input type="hidden" name="userEmail.id.email.content" value="">
						<FCK:editor id="userEmail.id.email.strContent" width="75%"
							height="320"
							fontNames="宋体;黑体;隶书;楷体_GB2312;Arial;Comic Sans MS;Courier 
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
							<input type="button" value="发送" onclick="sub(1)" />
							<input type="button" value="存草稿" onclick="sub(3);" />
							<input type="button" value="清空" onclick="clearHtml();">
							<input type="button" value="测试" onclick="selectuser();">
						</div>
					</td>

					<td>





						<table>
							<tr>
								<td>
									<input type="checkbox" name="m1" onClick="selectChild(this);"
										id="all">
									<span onClick="setDisplay(m1_menu);" style="cursor: hand">全部</span>
								</td>
							</tr>
							<tr id="m1_menu" style="">
								<td>
									<table>
										<s:iterator value="#session.departmentUsers" var="dept"
											status="s">
											<tr>
												<td>
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
												<td>
													<s:iterator value="#dept.departmentUsers" var="user">
													&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="checkbox" name="m11_chk"
															onClick="selectParent(this);">
														<s:property value="#user.userid" />
														<br>
													</s:iterator>
												</td>

											</tr>
										</s:iterator>

									</table>
								</td>
							</tr>
						</table>

					</TD>
				</TR>
			</table>
		</form>
	</body>
</html>
