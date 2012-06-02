<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK"%>
<html>
	<head>
		<title>Welcome</title>

	</head>
	<body>
		<form name="form1" action='show.jsp' method="post">
			<input type="hidden" name="content" value="ttt">
			<FCK:editor id="content" width="80%" height="320"
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

			<input type="submit" name="SubM" value="发表" />
		</form>

		<script type="text/javascript">
function test() {
	//FCK取值
	var checkContent = FCKeditorAPI.GetInstance("content").GetXHTML();
	alert(checkContent);
}

function test2() {
	//FCK赋值
	var editor = FCKeditorAPI.GetInstance("content");
	editor.EditorDocument.body.innerHTML = "";
}
</script>
		<input type="button" value="getHTML" onclick="test();">
		<input type="button" value="clearHTML" onclick="test2();">
	</body>
</html>
