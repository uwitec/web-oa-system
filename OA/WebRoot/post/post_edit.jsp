<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK"%>
 
<%@ taglib uri="/struts-tags" prefix="s"%>

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
 
<script language="javascript" type="text/javascript" src="<%=path%>/My97DatePicker/WdatePicker.js"></script>
		

		<SCRIPT type="text/javascript">
		
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
	function deleteFile(pfid){
		alert(pfid);
		var params = 'tPostFile.pfid=' + pfid; 
		$.ajax( {
			url : 'deleteTPostFile',
			type : 'post',
			dataType : 'json',
			data : params,
			success : function(json){
				var m = json.userInfo.message;
				if(m == 'success'){
					alert('删除成功');
					i--;
					document.getElementById("fj").removeChild(document.getElementById(efid))
				}
			};
		});
	}
	</SCRIPT>

	</head>

	<body>
		<h4>
			添加公告页面<br/>
		
			<s:actionerror />
		</h4>
		
		
		<s:form id="form" action="post/addpost" method="POST" enctype="multipart/form-data"
			 theme="css_xhtml">
			 
				<table align="center" width="100%" height="80%" border="1">
				<tr>
					<td >
						<s:textfield label="公告标题" name="tPost.title" id="title" 
						value="%{#request.tPost.title}"></s:textfield>
					</td>
				</tr>
				<tr>
					<td >
						生效时间
						<input   name="testNew" 
						class="Wdate" type="text" id="hts" 
						onfocus="new WdatePicker(this,'%Y年%M月%D日',false)" 
						maxdate="#F{$('hte').value}" onPicked="$('hte').onfocus()"/>
					</td>
				</tr>
				<tr>
					<td>
						失效时间
						<input   name="testOld" 
						class="Wdate" type="text" id="hts" 
						onfocus="new WdatePicker(this,'%Y年%M月%D日',false)" 
						maxdate="#F{$('hte').value}" onPicked="$('hte').onfocus()"/>
					</td>
					<td>
					</td>
				</tr>
				<Tr>
					<Td>
						附件
					</Td>
					<TD id="fj">
						<s:iterator value="#request.tPost.tPostFiles" var="tPostFile">
							<span id="<s:property value='%{#tPostFile.pfid}'/>"> <s:property
									value="#tPostFile.oldname" /> <input type="button" value="删除"
									onclick="javascript:deleteFile(<s:property value='#tPostFile.pfid'/>)" />
							</span>
						</s:iterator>
					</TD>
				</Tr>
				<tr>
					<Td colspan="2" id="td">
						<input type="button" value="添加附件" onclick="addMore()" />
					</Td>
				</tr>
				<TR>
					<TD colspan="1" width="100%">
						<s:hidden value="1" name="userEmail.type" id="type"></s:hidden>
						<input type="hidden" name="userEmail.id.email.content" value="">
						<FCK:editor id="userEmail.id.email.strContent" width="100%"
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
						 	<input type="submit" value="提交"  >
							<input type="reset" value="重置">
						 
						</div>
					</td>

					<td>


					</TD>
				</TR>
			</table>
		</s:form>
		
		<s:debug></s:debug>
	</body>
</html>
