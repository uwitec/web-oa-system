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
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<s:head />
		<script language="javascript" type="text/javascript"
			src="<%=path%>/My97DatePicker/WdatePicker.js">
</script>


		<SCRIPT type="text/javascript">
		
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
	function clearHtml() {
	//FCK��ֵ
	var editor = FCKeditorAPI.GetInstance("tPost.strContent");
	editor.EditorDocument.body.innerHTML = "";
}
	</SCRIPT>

	</head>

	<body>
		<h4>
			��ӹ���ҳ��
			<br />

			<s:actionerror />
		</h4>


		<s:form id="form" action="post/addpost" method="POST"
			enctype="multipart/form-data" theme="css_xhtml">

			<table align="center" width="100%" height="80%" border="1">
				<tr>
					<td>
						<s:textfield label="�������" name="tPost.title" id="title"
							value="%{#request.tPost.title}"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
					��Чʱ��

						<input name="testNew" class="Wdate" type="text" id="hts"
							onfocus="new WdatePicker(this,'%Y��%M��%D��',false)"
							maxdate="#F{$('hte').value}" onpicked="$('hte').onfocus()" />
					</td>
				</tr>
				<tr>
					<td>
						ʧЧʱ��

						<input name="testOld" class="Wdate" type="text" id="hte"
							onfocus="new WdatePicker(this,'%Y��%M��%D��',false)"
							mindate="#F{$('hts').value}" maxdate="2020-1-1" />
					</td>
					<td>
					</td>
				</tr>

				<tr>
					<Td colspan="2" id="td">
						<input type="button" value="��Ӹ���" onclick="addMore()" />
					</Td>
				</tr>
				<TR>
					<TD colspan="1" width="100%">
						<s:hidden value="1" name="tPost.status" id="status"></s:hidden>
						<input type="hidden" name="tPost.content" value="">
						<FCK:editor id="tPost.strContent" width="100%" height="320"
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
							<input type="submit" value="�ύ">
							<input type="reset" value="����">

						</div>
					</TD>
				</TR>
			</table>
		</s:form>

		<s:debug></s:debug>
	</body>
</html>
