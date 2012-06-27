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
		<s:form id="form" action="post/getpost" method="post">
			<table width="100%" border="0" cellpadding="0" cellspacing="1"
				bgcolor="#a8c7ce">
				<tr>

					<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">标题</span>
						</div>
					</td>
					<td width="29%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">发布者</span>
						</div>
					</td>
					<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">公告内容</span>
						</div>
					</td>
					<td width="16%" height="20" bgcolor="d3eaef" class="STYLE6">
						<div align="center">
							<span class="STYLE10">日期</span>
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
							<s:property value="#post.addUser.userid" />
						</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="center">
							<s:property value="#post.strContent" />
						</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="center">
							<s:date name="#post.addtime" format="yyyy-MM-dd hh:mm:ss" />
						</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="center">
							<s:property value="#post.status?'审核通过':'审核未通过'" />
						</td>
						<td height="20" bgcolor="#FFFFFF" class="STYLE19" align="center">
							<a href="post/">查看</a>
							<s:if test="%{session.LOGIN_USER=='系统管理员'}">
								<a href>删除</a>
								<s:if test="#post.satus==0">
									<a
										href="post/updatepost?post.status=1&post.postid=<s:property value="postid"/>">通过</a>
									<s:a
										href="javascript:deleteTPost('%{#post.postid}', '%{#session.user.userid}');">不通过</s:a>
								</s:if>
								<s:elseif test="#post.satus=='1'">    
							                    ------
							                 </s:elseif>
							</s:if>
							<s:else>----</s:else>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:form>
		
		<oa:pageTag/>
	</body>
</html>
