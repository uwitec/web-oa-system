<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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
		<s:head />

		<SCRIPT type="text/javascript">
		
		function addMore(){
			//先判断附件有多少个  需求要求附件数量最多为3个
			var tbody = document.getElementById("tbody");
			var childs = tbody.childNodes;
			if(childs.length>=3){
				alert("附件数量已有3个,不能添加附件,请先删除其中的一些附件");
				return ;
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
		
		
		//ajax代码
		var XmlHttp = null;
function createXMLHttp() {
	if (window.ActiveXObject) {
		XmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		XmlHttp = new XMLHttpRequest();
	}
}
		
		
		function deletePostFile(pid){
			var tbody = document.getElementById("tbody");
			var tr = document.getElementById("tr"+pid);
			createXMLHttp();
	
			var url = "<%=path%>/post/postFileAction!?postFileId="+pfid+"&date="
			+ new Date().getTime();
			XmlHttp.open("get", url, true);
			//指定回调的方法
			XmlHttp.onreadystatechange = function(){
				if (XmlHttp.readyState == 4) {
					if (XmlHttp.status == 200) {
						var text = XmlHttp.responseText;
						alert(text);
						tbody.removeChild(tr);
					}
				}
			};
			XmlHttp.send();
			
			
			
		}
	</SCRIPT>
	</head>

	<body>
		<h4>
			修改公告页面
		</h4>


		<s:form namespace="/system" action="postFileAction"
			method="POST" enctype="multipart/form-data" theme="css_xhtml">
			<table border="1" width="80%">
				<tr>
					<td>
						<s:hidden name="tUserPost.id.tPost.postid" />

						<s:textfield label="公告标题" name="tUserPost.id.tPost.title" maxLength="25"></s:textfield>
						<br>
					</td>
				</tr>
				<tr>
					<td>
						<s:hidden value="1" name="tUserPost.id.tPost.status" id="status"></s:hidden>
						<input type="hidden" name="tUserPost.id.tPost.content" value="">
						<FCK:editor id="tUserPost.id.tPost.strContent" width="75%"
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
						<br>
					</td>
				</tr>
				<tr>
					<td id="div">


						<input type="button" value="添加更多附件" onclick="addMore()" />
						<br>
						<!-- 附件列表 -->
						<table width="400" border="1" bgcolor="#CCFFFF">
							<tr>
								<td>
									附件列表
								</td>
							</tr>
							<tbody id="tbody">
								<s:iterator value="#request.postFileBeans" var="postFileBean">
									<tr id="tr${postFileBean.id}">
										<td>
											<s:property value="#postFileBean.fileName" />
											&nbsp;
											<input type="button"
												onclick="deletePostFile(${postFileBean.id})" value="删除附件" />
										</td>

									</tr>

								</s:iterator>

							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<s:submit label="提交按钮" value="提交" align="left"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>

		<s:debug></s:debug>
	</body>
</html>
