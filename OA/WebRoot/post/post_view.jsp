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

		<title>My JSP 'post_view.jsp' starting page</title>

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
	</head>

	<body>
		<form name="form" action='' method="post"
			enctype="multipart/form-data">
			<table align="center" width="100%" height="80%" border="0"
				cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
				<tr height="30">
					<td width="20%" bgcolor="#FFFFFF" class="STYLE19">
						公告标题:
					</td>
					<td bgcolor="#FFFFFF" class="STYLE19">
						<s:property value="%{#request.post.title}" />
					</td>
				</tr>
				<tr bgcolor="#FFFFFF" class="STYLE19" height="30">
					<td bgcolor="#FFFFFF" class="STYLE19">
						生效时间
					</td>
					<td>
						<input   name="testNew2" class="Wdate"	readonly="readonly"
						 value=<s:property value="#request.post.begindate"/> />
					</td>
				</tr>
				 <tr bgcolor="#FFFFFF" class="STYLE19" height="30">
					<td bgcolor="#FFFFFF" class="STYLE19">
						失效时间
					</td>
					<td>
						<input   name="testOld2" class="Wdate"	 readonly="readonly"
						value =<s:property value ="#request.post.enddate"/>/>
					</td>
				</tr>
			
				<tr bgcolor="#FFFFFF" class="STYLE19" height="30">
					<Td>
						附件下载
					</Td>
					<td>
						<s:iterator value="#request.post.tpostfiles" var="postFile">
							<s:a
								href="post/download?fileName=%{#postFile.newname}&oldName=%{#postFile.oldname}">
								<s:property value="#postFile.oldname" />
							</s:a>
						</s:iterator>
					</td>
				</tr>
				<TR>
					<TD width="100%" align="center" colspan="2">
					 
						<s:hidden name="post.strContent"
							value="%{#request.post.strContent}"></s:hidden>
						<FCK:editor  id="post.strContent" width="100%"
							height="360"
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
					</td>
				</TR>
			</table>
		</form>
	</body>
</html>
