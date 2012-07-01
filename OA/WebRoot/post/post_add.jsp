<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK"%>
 
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<html>
	<head>


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
		<s:head />
		<script language="javascript" type="text/javascript"
			src="<%=path%>/My97DatePicker/WdatePicker.js">
</script>


		<SCRIPT type="text/javascript">
	var i=0;	
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
	function clearHtml() {
	//FCK赋值
	var editor = FCKeditorAPI.GetInstance("post.strContent");
	editor.EditorDocument.body.innerHTML = "";
}
	</SCRIPT>

	</head>

	<body>
 

	<SPAN><s:fielderror></s:fielderror> <s:actionerror /> </SPAN>
		<s:form id="form" action="post/addpost" method="POST"
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
													<td width="94%" valign="bottom" align="center">
														<span class="STYLE1"> 发布新的公告</span>
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


			<table align="center" width="100%" height="80%" border="1">
				<tr>
				<td height="20" bgcolor="d3eaef" class="STYLE6" align="left">
				公告标题
				<input type="text" name="post.title" id="titile">
				</td><!--
					<TD height="20" bgcolor="d3eaef" class="STYLE6" align="left">
						<s:textfield label="公告标题" name="post.title" id="title"
							value="%{#request.tPost.title}"></s:textfield>
					</td>
				--></tr>
				<tr>
					<TD height="20" bgcolor="d3eaef" class="STYLE6" align="left">
						生效时间
						<input name="post.begindate" class="Wdate" type="text" id="hts"
							onfocus="new WdatePicker(this,'%Y年%M月%D日',false)"
							MINDATE="#Year#-#Month#-#Day#" onpicked="$('hte').onfocus()" />
					</td>
				</tr>
				<tr>
					<TD height="20" bgcolor="d3eaef" class="STYLE6" align="left">
						失效时间

						<input name="post.enddate" class="Wdate" type="text" id="hte"
							onfocus="new WdatePicker(this,'%Y年%M月%D日',false)"
							mindate="#F{$('hts').value}" maxdate="2020-1-1" />
					</td>
 
				</tr>

				<tr>
					<Td colspan="2" id="td">
						<input type="button" value="添加附件" onclick="addMore()" />
					</Td>
				</tr>
				<TR>
					<TD colspan="1" width="100%">
						<s:hidden value="1" name="post.status" id="status"></s:hidden>
						<input type="hidden" name="post.strContent" value="">
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
							<input type="submit" value="提交">
							<input type="reset" value="重置">
							<input type="button" value="清空" onclick="clearHtml();">							
						</div>
					</TD>
				</TR>
			</table>
		</s:form>

		<s:debug></s:debug>
	</body>
</html>
