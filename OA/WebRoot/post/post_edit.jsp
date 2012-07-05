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
	font-size: 14px;
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

 <script language="javascript" type="text/javascript"
			src="<%=path%>/My97DatePicker/WdatePicker.js">
</script>
 <SCRIPT type="text/javascript" src="js/oa/jquery-1.7.2.js">
 </SCRIPT>
 
		<SCRIPT type="text/javascript">
var i= <s:property value='#request.post.tpostfiles.size()'/>;	 
	function addMore() {
	 
	if (i >= 3) {
		alert("超过三个附件");
		return false
	}
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
		
 function clearHtml() {
	//FCK赋值
	var editor = FCKeditorAPI.GetInstance("post.strContent");
	editor.EditorDocument.body.innerHTML = "";
}



function deleteFile(pfid,newname){
		var params = 'postFile.pfid=' + pfid + '&postFile.newname=' + newname;
		 $.ajax({
		 	url : 'deleteTPostFile',
			type : 'post',
			dataType : 'json',
			data : params,
			 success : function(json){
			 var m = json.userInfo.message;
				 if(m == 'success'){
					 alert('删除成功');
						i--;					 
					 if(i == 0){
						 	document.getElementById("hasfile").value = 'false';
					 }
					  document.getElementById("ttt").removeChild(document.getElementById(pfid))
				}
			}
		 });
}
	</SCRIPT>
	
	

	</head>

	<body>
		<s:form id="form" action="post/updatepost" method="POST"
			enctype="multipart/form-data" theme="css_xhtml">
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
													<td width="100%" valign="bottom" align="center">
														<span class="STYLE1"> 公告修改</span>
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


			<table align="center" width="100%" height="80%" border="0"
				cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
				<tr height="30">
				
					<s:hidden name="post.postid" id="postid" 
					value="%{#request.post.postid}" ></s:hidden>	
									  
					<td width="20%" bgcolor="#FFFFFF" class="STYLE19">
						<strong> 公告标题 </strong>
					</td>
					<td bgcolor="#FFFFFF" class="STYLE19">
						<strong><input type="text" name="post.title" id="titile"
								value='<s:property value="%{#request.post.title}" />'>
						</strong>

					</td>
				</tr>
				<tr bgcolor="#FFFFFF" class="STYLE19" height="30">
					<td bgcolor="#FFFFFF" class="STYLE19">
						<strong> 生效时间 </strong>
					</td>
					<td>
						<strong><input name="post.begindate" class="Wdate"
							value =<s:property value ="#request.post.begindate"/>/>
						</strong>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF" class="STYLE19" height="30">
					<td bgcolor="#FFFFFF" class="STYLE19">
						<strong> 失效时间 </strong>
					</td>
					<td>
						 <input name="post.enddate" class="Wdate" 
								value =<s:property value ="#request.post.enddate"/>/>
						 
					</td>
				</tr>

				<tr bgcolor="#FFFFFF" class="STYLE19" height="30">
					<Td>
						<strong> 附件下载 </strong>
					</Td>
					<td id="ttt">
						<s:iterator value="#request.post.tpostfiles" var="postFile">
							<span id="<s:property value='#postFile.pfid'/>"> <s:a
									href="post/download?fileName=%{#postFile.newname}&oldName=%{#postFile.oldname}">
									<s:property value="#postFile.oldname" />
									<input type="button" value="删除"
										onclick="deleteFile('<s:property value="#postFile.pfid"/>', '<s:property value="#postFile.newname"/>')" />
								</s:a> </span>
						</s:iterator>
					</td>
				</Tr>
				<tr>
					<Td colspan="2" id="td">
						 <input type="button" value="添加附件"
								onclick="addMore()">
												 
					</Td>
				</tr>
				<TR>
					<TD width="100%" align="center" colspan="2">
						<s:hidden name="post.strContent"
							value="%{#request.post.strContent}"></s:hidden>
						<FCK:editor id="post.strContent" width="100%" height="320"
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
							<strong><input type="submit" value="提交"> <input
									type="reset" value="重置"> <input type="button"
									value="清空" onclick="clearHtml();">
							</strong>
						</div>
					</TD>
				</TR>
			</table>
		</s:form>
		<s:debug></s:debug>
	</body>
</html>
