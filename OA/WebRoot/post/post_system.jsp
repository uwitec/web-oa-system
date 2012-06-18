<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/oa-tag" prefix="oa"%>
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

		<title>My JSP 'inbox.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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

		<SCRIPT type="text/javascript">
	function deleteTPost(postid, userid){
		if(confirm('确认删除?')){
			window.location.href = "<%=path%>/post/deletePost?tUserPost.status=1&tUserPost.id.tPost.postid="+postid+ "&tUserPost.id.user.userid=" + userid;
		}
	}
	
	
	
</SCRIPT>
	</head>

	<body>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
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
														<span class="STYLE1"> 公告列表</span>
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




			<tr>
				<td>
					<s:form id="form" namespace="post" action=postAction!getposts method="post">
						<s:hidden name="userEmail.type" value="1"></s:hidden>
						
						<table width="100%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="#a8c7ce">
							<tr>
					 
								<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">标题</span>
									</div>
								</td>
								<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">发布者</span>
									</div>
								</td>
								<td width="18%" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">公告内容</span>
									</div>
								</td>
								<td width="13%" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">日期</span>
									</div>
								</td>
								<td width="13%" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">状态</span>
									</div>
								</td>
								<td width="13%" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">操作</span>
									</div>
								</td>
								<td width="13%" height="20" bgcolor="d3eaef" class="STYLE6">
									<div align="center">
										<span class="STYLE10">操作</span>
									</div>
								</td>

							</tr>

							<s:iterator value="#request.tUserPosts" var="userEmail">
								<tr>
 
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#tUserPost.id.tPost.title" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#tUserPost.id.tPost.addUser" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#tUserPost.id.tPost.content" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:date name="#tUserPost.id.tPost.addTime"
											format="yyyy-MM-dd hh:mm:ss" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#tUserPost.id.tPost.status?'审核通过':'审核未通过'" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<a href="post/">查看</a>
										<s:a
											href="javascript:deletePost('%{#tUserPost.id.tPost.postid}', '%{#session.user.userid}');">删除</s:a>

									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<a href="post/">审核</a>
										<s:property value="#tUserPost.id.tPost.status?'无权限操作':'通过'" /> 

									</td>								


								</tr>
							</s:iterator>
						</table>
					</s:form>
				</td>
			</tr>
		</table>
		<oa:pageTag />
		<s:debug></s:debug>
	</body>
</html>
