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

		<title>My JSP 'top.jsp' starting page</title>

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
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px;
	color: #000000;
}

.STYLE5 {
	font-size: 12
}

.STYLE7 {
	font-size: 12px;
	color: #FFFFFF;
}

.STYLE7 a {
	font-size: 12px;
	color: #FFFFFF;
}

a img {
	border: none;
}
-->
</style>


		<SCRIPT type="text/javascript" src="js/oa/jquery-1.7.2.js">
		</SCRIPT>








		<script type="text/javascript">

var interval= <s:property value="#session.user.tips.interval"/>;//���ʱ��
var oPopup = window.createPopup();//������̬����
var popTop = 50;
var width = 226;

//��ע�⣺��ִ�������js�ű�ǰ��Ҫ�ж��Ƿ�Ҫ��ʾС��ʿ���������ʾ���Ͳ�ִ�����½ű���
//��ע�⣺�ж��Ƿ�Ҫ��ʾС��ʿ�����ݿ��ȡ��

popmsg();//���ظ�ҳ�漴ִ�иú������ú�������̬����������ݡ�
window.setInterval("popmsg();", interval * 1000);//���10��ѭ��ִ��popmsg()��������ע�⣺10��ļ���������ݿ��ȡ����


//δ���ʼ���δ����������������ݿ��ȡ��������AJAX��̬�仯��
function popmsg() {
	var showTips = <s:property value="#session.user.tips.showtips"/>;//�Ƿ���ʾ
	if (showTips == true) {
		
		var winstr = "<table width=\"226\" height=\"151\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" background=\"images/taobao_msg.gif\">  <tr>    <td width=\"27\" height=\"20\">&nbsp;</td>    <td width=\"168\">&nbsp;</td>    <td width=\"29\"><div align=\"center\"><img src=\"images/close.gif\" width=\"14\" height=\"13\"  style=\"cursor:hand\" onclick=\"alert(\'close me!\')\"/></div></td>  </tr>  <tr>    <td width=\"50\" height=\"100\">&nbsp;</td>    <td><br>		<div align=\"center\" style=\"line-height:22px;\">			<font size=\"2\">				<a href=\"#\" id=\"amail\">����δ���ʼ� " +
	"<font color=\"#FF0000\">"+ 1 +"</font> ��</a> <br />        	  <a href=\"#\" id=\"ameet\">����δ�� <font color=\"#FF0000\">N</font> ��</a> <br />        	  <a href=\"#\" id=\"atrans\">����������� <font color=\"#FF0000\">N</font> ��</a> <br />    		���� �ر�</font></div>		</td>    <td>&nbsp;</td>  </tr>  <tr>    <td height=\"5\">&nbsp;</td>    <td>&nbsp;</td>    <td>&nbsp;</td>  </tr></table>";
	
	var showEmail = <s:property value="#session.user.tips.showemail"/>;
	var showPost = <s:property value="#session.user.tips.showpost"/>;
	
	var strEmail = "<a href=\"#\" id=\"ameet\">����δ���ʼ� <font color=\"#FF0000\">N</font> ��</a> <br />";
	
	if(showEmail) {
		//ajax���ʼ���Ŀ ƴstrEmail
		$.ajax({
			url : 'count',
			type : 'post',
			dataType : 'json',
			success : function(json){
				alert(json.userInfo.numbers);
			}
		});
	}
	
	oPopup.document.body.innerHTML = winstr;
	popshow();
	popTop = 50;

	//��������if���ж��Ƿ�Ҫ��ʾ�ʼ��͹��档�Լ��鿴δ���ʼ��͹���ĵ�ַ��
	//��ע�⣺�Ƿ���ʾ�ʼ��͹��������ݿ��ȡ��
	if (oPopup.document.getElementById("amail") != null) {
		oPopup.document.getElementById("amail").onclick = function() {
			parent.rightFrame.location = "main1.html";
		}
	}

	if (oPopup.document.getElementById("ameet") != null) {
		oPopup.document.getElementById("ameet").onclick = function() {
			parent.rightFrame.location = "main2.html";
		}
	}
	}
	
	

}

//��������Ǳ�ʾ��̬�������ڵ�ͣ��ʱ�䣬��������䶯
function popshow() {
	window.status = popTop;
	if (popTop > 1720) {
		clearTimeout(mytime);
		oPopup.hide();
		popTop = 50;
		return;
	} else if (popTop > 1520 && popTop < 1720) {
		oPopup.show(screen.width - 260, screen.height + 30, width,
				1720 - popTop - 20);
	} else if (popTop > 1500 && popTop < 1720) {
		oPopup.show(screen.width - 260, screen.height + 30 + (popTop - 1720),
				width, 152);
	} else if (popTop < 180) {
		oPopup.show(screen.width - 260, screen.height + 30, width, popTop - 20);
	} else if (popTop < 220) {
		oPopup
				.show(screen.width - 260, screen.height + 30 - popTop, width,
						152);
	}
	popTop += 10;
	var mytime = setTimeout("popshow();", 20);
}
</script>



	</head>

	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="57" background="images/main_03.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="378" height="57" background="images/main_01.gif">
								&nbsp;
							</td>
							<td>
								&nbsp;
							</td>
							<td width="281" valign="bottom">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="33" height="27">
											<img src="images/main_05.gif" width="33" height="27" />
										</td>
										<td width="248" background="images/main_06.gif">
											<table width="225" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="17">
														<%--<div align="right">
															<a href="pwd.php" target="rightFrame"><img
																	src="images/pass.gif" width="69" height="17" /> </a>
														</div>
													--%>
													</td>
													<td>
														<%--
														<div align="right">
															<a href="user.php" target="rightFrame"><img
																	src="images/user.gif" width="69" height="17" /> </a>
														</div>
													--%>
														<div align="right">
															<a href="<%=path%>/user/logout" target="_parent"><img
																	src="images/quit.gif" alt=" " width="69" height="17" />
															</a>
														</div>
													</td>
													<td>

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
				<td height="40" background="images/main_10.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="194" height="40" background="images/main_07.gif">
								&nbsp;
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="21">
											<img src="images/main_13.gif" width="19" height="14" />
										</td>
										<td width="35" class="STYLE7">
											<div align="center">
												<a href="main.html" target="rightFrame">��ҳ</a>
											</div>
										</td>
										<td width="21" class="STYLE7">
											<img src="images/main_15.gif" width="19" height="14" />
										</td>
										<td width="35" class="STYLE7">
											<div align="center">
												<a href="javascript:history.go(-1);">����</a>
											</div>
										</td>
										<td width="21" class="STYLE7">
											<img src="images/main_17.gif" width="19" height="14" />
										</td>
										<td width="35" class="STYLE7">
											<div align="center">
												<a href="javascript:history.go(1);">ǰ��</a>
											</div>
										</td>
										<td width="21" class="STYLE7">
											<img src="images/main_19.gif" width="19" height="14" />
										</td>
										<td width="35" class="STYLE7">
											<div align="center">
												<a href="javascript:window.parent.location.reload();">ˢ��</a>
											</div>
										</td>
										<td width="21" class="STYLE7">
											<img src="images/main_21.gif" width="19" height="14" />
										</td>
										<td width="35" class="STYLE7">
											<div align="center">
												<a href="http://www.865171.cn" target="_parent">����</a>
											</div>
										</td>
										<td>
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
							<td width="248" background="images/main_11.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="16%">
											<span class="STYLE5"></span>
										</td>
										<td width="75%">
											<div align="center">
												<span class="STYLE7">OA�칫ϵͳ</span>
											</div>
										</td>
										<td width="9%">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="30" background="images/main_31.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="8" height="30">
								<img src="images/main_28.gif" width="8" height="30" />
							</td>
							<td width="147" background="images/main_29.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="24%">
											&nbsp;
										</td>
										<td width="43%" height="20" valign="bottom" class="STYLE1">
											����˵�
										</td>
										<td width="33%">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
							<td width="39">
								<img src="images/main_30.gif" width="39" height="30" />
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="20" valign="bottom">
											<span class="STYLE1">��ǰ��¼�û���<s:property
													value="#session.user.userid" /> &nbsp; </span>
										</td>
										<td valign="bottom" class="STYLE1">
											<div align="right"></div>
										</td>
									</tr>
								</table>
							</td>
							<td width="17">
								<img src="images/main_32.gif" width="17" height="30" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
