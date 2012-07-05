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

		<title>My JSP 'right.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
</style>
		<script type="text/javascript" src="js/oa/jquery-1.7.2.js" />
</script>
		<SCRIPT type="text/javascript">
	function selectCheck(){
			
		}
		//选中孩子
		function selectChild(o){
			//获得本菜单的tr
			var otr = o.parentElement.parentElement;
			//获得子菜单的tr
			var otrmenu = otr.nextSibling;
			//遍历子菜单的checkbox
			for(var i=0;i<otrmenu.all.length;i++)	{
				if(otrmenu.all[i].type=="checkbox"){
					otrmenu.all[i].checked = o.checked;
				}
			}		


		}	
		
		//选中父类(适用二级)
		function selectParent(o){
			//t=true默认找到
			var t= false;
			//获得本菜单的tr
			var otr = o.parentElement.parentElement;
			//获得父菜单的tr
			var otrmenu = otr.previousSibling;
			//遍历子菜单的checkbox,验证是有选
			for(var i=0;i<otr.all.length;i++)	{
				if(otr.all[i].type=="checkbox" && otr.all[i].checked){
					t = true;
					break;
				}
			}		
			//设置父类的checkbox状态
			if(t){
				for(var i=0;i<otrmenu.all.length;i++)	{
				if(otrmenu.all[i].type=="checkbox"){
					otrmenu.all[i].checked = "checked";				
					selectRoot(otrmenu.all[i]);	
					break;
					}
				}
			}else{
				for(var i=0;i<otrmenu.all.length;i++)	{
				if(otrmenu.all[i].type=="checkbox"){
					otrmenu.all[i].checked = "";
					selectRoot(otrmenu.all[i]);	
					break;
					}
				}
			}		
			
		}
		
		
		//选中根点节(适用一级)
		function selectRoot(o){
			//t=true默认找到
			var t= false;
			//获得本菜单的tr
			var otr = o.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement

			//获得父菜单的tr
			var otrmenu = otr.previousSibling;

			//遍历子菜单的checkbox,验证是否全选
			for(var i=0;i<otr.all.length;i++)	{
				if(otr.all[i].type=="checkbox" && otr.all[i].checked){
					t = true;
					break;
				}
			}		
				//设置父类的checkbox状态
			if(t){
				for(var i=0;i<otrmenu.all.length;i++)	{
				if(otrmenu.all[i].type=="checkbox"){
					otrmenu.all[i].checked = "checked";				
					break;
					}
				}
			}else{
				for(var i=0;i<otrmenu.all.length;i++)	{
				if(otrmenu.all[i].type=="checkbox"){
					otrmenu.all[i].checked = "";
					break;
					}
				}
			}		
			
		}
		//菜单的显示与隐藏
		function setDisplay(o){
			if(o.style.display==""){
				o.style.display="none";
			}else{
				o.style.display="";
			}
		}
	function deleteMenu(menuid){
		if(confirm('确认删除?')){
			window.location.href = "<%=path%>/menu/delmenu?userInfo.menu.menuid=" + menuid;
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
													<td width="94%" valign="bottom" align="center">
														<span class="STYLE1"> 菜单列表</span>
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
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						<tr>
							<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">角色名</span>
								</div>
							</td>
							<td width="15%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">角色备注</span>
								</div>
							</td>
							
							
							<td width="18%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">基本操作[<s:a href="menu/preadd">添加菜单</s:a>]</span>
								</div>
							</td>
						</tr>

						<s:iterator value="#request.userInfo.menuList" var="menu">
							<tr>

								<td height="20" bgcolor="#FFFFFF" class="STYLE6">
									<div align="center">
										<span class="STYLE19"><s:property value="#menu.menuname" />
										</span>
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<s:property value="#menu.menuinfo" />
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF">
									<div align="center" class="STYLE21">
										<a
											href="menu/getmenu?userInfo.menu.menuid=<s:property value="%{#menu.menuid}"/>">查看</a>|
										<a
											href="menu/preupdatemenu?userInfo.menu.menuid=<s:property value="%{#menu.menuid}"/>">修改</a>|
										<a
											href="javascript:deleteMenu('<s:property value='#menu.menuid'/>')">删除</a>
									</div>
								</td>
							</tr>

						</s:iterator>

					</table>
				</td>
			</tr>
			<oa:pageTag />
		</table>
	</body>
</html>
