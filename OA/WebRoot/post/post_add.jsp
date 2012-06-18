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
	<s:head/>

		<SCRIPT type="text/javascript">
		
		function addMore(){
			var tbody = document.getElementById("tbody");
			var trs = tbody.childNodes;
			if(trs.length>=3){
				alert("附件只能是3个，您当期附件已经是3个，请删除其中一些附件");
			}else{
				var tr = document.createElement("tr");
			var td = document.createElement("td");
			var input = document.createElement("input");
			var button = document.createElement("input");
			var br = document.createElement("br");
			input.type = "file";
			input.name="upload";
		 
			input.contentEditable="false";
			button.type = "button";
			button.value = "删除附件";
			 
			button.onclick = function(){
				 
				tbody.removeChild(tr);
				
			};
	
			td.appendChild(input);
			td.appendChild(button);
			td.appendChild(br);
			tr.appendChild(td);
			tbody.appendChild(tr);
				
			}
			
			
			
			
		}	
	</SCRIPT>
	</head>

	<body>
		<h4>
			添加公告页面<br/>
		
			<s:actionerror />
		</h4>
		
		
		<s:form id="form" namespace="post" action="postAction!addpost" method="POST" enctype="multipart/form-data"
			 theme="css_xhtml">
			<table border="1" width="80%" align="center">
				<tr>
					<td>
						<s:textfield label="公告标题" name="tUserPost.id.tPost.title" maxLength="25"></s:textfield>
						<br>
					</td>
				</tr>

	<TR>
					<TD colspan="1" width="80%">
						 
					<tr>
					  
					 公告内容：
					 <br/>
					</tr>
						<html:hidden  value="1"  name="tUserPost.id.tPost.status" id="status"></html:hidden>
						<input type="hidden" name="tUserPost.id.tPost.content" value="">
						<FCK:editor id="tUserPost.id.tPost.strContent" width="75%"
							height="320"
							fontNames="宋体;黑体;隶书;楷体_GB2312;Arial;Comic Sans MS;Courier 
							New;Tahoma;Times New Roman;Verdana"
							imageBrowserURL="/OA/FCKeditor/editor/filemanager/browser/default/browser.html?
							Type=Image&Connector=connectors/jsp/connector"
							linkBrowserURL="/OA/FCKeditor/editor/filemanager/browser/default/browser.html?
							Connector=connectors/jsp/connector"
							flashBrowserURL="/OA/FCKeditor/editor/filemanager/browser/default/browser.html?
							Type=Flash&Connector=connectors/jsp/connector"
							imageUploadURL="/OA/FCKeditor/editor/filemanager/upload/simpleuploader?Type=Image"
							linkUploadURL="/OA/FCKeditor/editor/filemanager/upload/simpleuploader?Type=File"
							flashUploadURL="/OA/FCKeditor/editor/filemanager/upload/simpleuploader?Type=Flash">
						</FCK:editor>
 
					</td>

					<td>
				<tr>
					<td >
					 
					<input type="button"  value="添加更多附件" onclick="addMore()" />
						<br>
					<table >
					<tbody id="tbody">
					<tr>
					<td><s:file label="选择上文件1" name="upload"></s:file>
						</td>					
					</tr>
					</tbody>				
					</table>				
					</td>
				</tr>
				<tr>
					<td>
						<s:submit label="提交按钮" value="提交" align="left"></s:submit>
						<s:reset label="重置 " ></s:reset>						
					</td> 					
				</tr>
			</table>
		</s:form>
		
		<s:debug></s:debug>
	</body>
</html>
