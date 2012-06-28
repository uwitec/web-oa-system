<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>My JSP 'postlist.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<s:form id="form" action="post/getselfpost" method="post">
			<table width="100%" border="0" cellpadding="0" cellspacing="1"
				bgcolor="#a8c7ce">
				<tr>

					<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">标题</span>
						</div>
					</td>
					<td width="9%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">发布者</span>
						</div>
					</td>
					<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">生效日期</span>
						</div>
					</td>
					<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">失效日期</span>
						</div>
					</td>
					<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">公告内容</span>
						</div>
					</td>
					<td width="16%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">添加日期</span>
						</div>
					</td>
					<td width="15%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">状态</span>
						</div>
					</td>
					<td width="16%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">操作</span>
						</div>
					</td>

				</tr>
				<s:iterator value="#request.posts" var="post">
					<tr>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="center">
							<s:property value="#post.title" />
						</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="center">
							<s:property value="#post.addUser.userid " />
						</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="center">
							<s:date name="#post.begindate" format="yyyy-MM-dd " />
						</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="center">
							<s:date name="#post.enddate" format="yyyy-MM-dd " />
						</td>							
						<td height="20"   bgcolor="#FFFFFF" class="STYLE19" align="center">	
							<s:property value="#post.strContent.substring(0,5)" />
						</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="center">
							<s:date name="#post.addtime" format="yyyy-MM-dd" />
						</td>
							
						<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="center">
							<s:property value="#post.status?'审核通过':'审核中'" />
						</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="center">
						<s:a
						href="post/viewpost?post.postid=%{#post.postid}">查看</s:a>
	 
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:form>
		
		<oa:pageTag/>
	</body>
</html>
