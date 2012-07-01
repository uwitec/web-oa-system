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
	function deletePost(postid){
		if(confirm('确认删除?')){
			window.location.href = "<%=path%>/post/deletepost?post.postid="+postid ;
		}
	}

</SCRIPT>

	</head>

	<body>
		<s:form id="form" action="post/getpost1" method="post">
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
													<td width="94%" valign="bottom" align="center">
														<span class="STYLE1"> 公告修改</span>
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
						 <s:if test="#post.status==0">
					 
						 <a
						 href="post/updatebefore?post.postid=<s:property value="postid"/>">修改</a>
						
						</s:if>							 
							<s:else>
							<s:a
						href="javascript:deletePost('%{#post.postid}');">删除</s:a></s:else>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:form>
		
		<oa:pageTag/>
	</body>
</html>
