<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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

		<title>OAµ«¬º</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript" src="js/oa/jquery-1.7.2.js">
</script>
		<%--

		<script type="text/javascript">
$(document).ready(function() {
	$("#submit").click(function() {
		var params = $("#form").serialize();
		$.ajax( {
			url : '<%=path%>/user/login',
			type : 'POST',
			dataType : 'json',
			data : params,
			success : function(data, textStatus) {
				alert(data.userInfo.message);
				if (data.userInfo.message == 'success') {
					window.location = '<%=path%>/index.jsp';
				}
			},
			error : function() {
				alert('µ«¬º ß∞‹£¨«Î…‘∫Ú÷ÿ ‘!');
			}
		});
	});

});
</script>
	--%>
	</head>

	<body>
		<div id="top">
		</div>
		<form id="form" action="user/login" method="post">
			<div id="center">
				<div id="center_left"></div>
				<div id="center_middle">
					<div class="user">
						<label>
							”√ªß√˚£∫
							<input type="text" name="userInfo.user.userid" id="user"
								value="${cookie.userid.value}" />
						</label>
					</div>
					<div class="user">
						<label>
							√‹ &nbsp;¬Î£∫
							<input type="password" name="userInfo.user.password"
								id="password" value="${cookie.password.value}"/>
						</label>
					</div>
					<div class="chknumber">
						<label>
							—È÷§¬Î£∫
							<input name="userInfo.vcode" type="text" id="chknumber"
								maxlength="4" class="chknumber_input" />
						</label>
						<img src="user/vcode"
							onclick="javascript:this.src='<%=path%>/user/vcode?' + new Date().getTime();" />
					</div>
				</div>
				<div id="center_middle_right"></div>

				<div id="center_submit">
					<div class="button">
						<img src="images/dl.gif" width="57" height="20"
							onclick="javascript:form.submit();">
					</div>

					<div class="button">
						<img src="images/cz.gif" width="57" height="20"
							onclick="javascript:form.reset();">

					</div>
				</div>

				<div id="center_right">
					<span> <s:actionerror theme="simple" /> </span>
				</div>
			</div>

		</form>

		<div id="footer"></div>

	</body>
</html>
