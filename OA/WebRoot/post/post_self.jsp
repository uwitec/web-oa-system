<%@ page  language="java" import="java.util.*" pageEncoding="GB18030"%>
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


<script language="javascript" type="text/javascript"
			src="<%=path%>/My97DatePicker/WdatePicker.js">
</script>
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
													<td width="94%" valign="bottom" align="center">
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
			
			
		<s:form id="form" action="post/getselfpost" method="post">

				<table width="100%" border="0" cellpadding="0" cellspacing="1">
					<tr>
						<TD height="20" bgcolor="d3eaef" class="STYLE6" align="center">
							公告标题:
							<s:textfield label="公告标题" name="userInfo.tpost.title"></s:textfield>
						
						</TD>
					<TD height="20" bgcolor="d3eaef" class="STYLE6" align="center">
							生效时间

							<input name="userInfo.tpost.begindate" class="Wdate" type="text"
								id="hts" onfocus="new WdatePicker(this,'%Y-%M-%D %h:%m',true)"
								maxdate="#F{$('hte').value}" onpicked="$('hte').onfocus()" />
						</td>
					<TD height="20" bgcolor="d3eaef" class="STYLE6" align="center">
							失效时间
							<input  name="userInfo.tpost.enddate" class="Wdate" type="text"
								id="hte" onfocus="new WdatePicker(this,'%Y-%M-%D %h:%m',true)"
								mindate="#F{$('hts').value}" maxdate="2020-1-1" />
						</td>
						<td>	<s:submit value="查询" /></td>
				</table>
		 </s:form>
			<tr>
				<td>
				
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
			</td>
		 </tr>
		 <oa:pageTag/>
		
		</table>
	</body>
</html>
