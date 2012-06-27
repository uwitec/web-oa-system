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
			window.location.href = "<%=path%>/post/deletepost?post.status=2;
		}
	}
	
	
	
</SCRIPT>
	</head>

	<body>
		<s:debug></s:debug>
		<!--<table width="100%" border="0" align="center" cellpadding="0"
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
					<s:form id="form" action="post/getposts" method="post">
						<s:hidden name="userEmail.type" value="1"></s:hidden>

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
							<s:property value="#request.posts.size()" />
							<s:iterator value="#request.posts" var="post">
								<tr>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#post.title" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#post.addUser" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#post.strContent" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:date name="#post.addTime" format="yyyy-MM-dd hh:mm:ss" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
										<s:property value="#post.status?'审核通过':'审核未通过'" />
									</td>
									<td height="20" bgcolor="#FFFFFF" class="STYLE19"
										align="center">
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
				</td>
			</tr>
		</table>

		<s:debug></s:debug>
	--></body>
</html>
