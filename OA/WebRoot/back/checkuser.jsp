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

		<title>My JSP 'checkuser.jsp' starting page</title>

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
		<s:textfield label="�û���" readonly="true"
			value="%{#request.singleuser.userid}"></s:textfield>
		<br />
		<s:textfield label="��ʵ����" readonly="true"
			value="%{#request.singleuser.realname}"></s:textfield>
		<br />
		<s:textfield label="����" readonly="true"
			value="%{#request.singleuser.department.dataname}"></s:textfield>
		<br />
		<s:textfield label="ְ��" readonly="true"
			value="%{#request.singleuser.job.dataname}"></s:textfield>
		<br />
		<s:date format="yyyy/MM/dd hh:mm:ss"
			name="#request.singleuser.addtime" var="addtime" />
		<s:textfield label="���ʱ��" readonly="true" value="%{#addtime}"></s:textfield>

		<br />
		<s:textfield label="�Ա�" readonly="true"
			value="%{#request.singleuser.sex}"></s:textfield>
		<br />
		<s:textfield label="����" readonly="true"
			value="%{#request.singleuser.city.dataname}"></s:textfield>
		<br />
		<s:textfield label="�Ƿ��ѻ�" readonly="true"
			value="%{#request.singleuser.married ? '�ѻ�' : 'δ��'}"></s:textfield>
		<br />
		<s:textfield label="���֤" readonly="true"
			value="%{#request.singleuser.idcard}"></s:textfield>
		<br />
		<s:textfield label="�绰" readonly="true"
			value="%{#request.singleuser.phone}"></s:textfield>
		<br />
		<s:textfield label="�ֻ�" readonly="true"
			value="%{#request.singleuser.handset}"></s:textfield>
		<br />
		<s:textfield label="�ʼ�" readonly="true"
			value="%{#request.singleuser.email}"></s:textfield>
		<br />
		<s:textfield label="סַ" readonly="true"
			value="%{#request.singleuser.address}"></s:textfield>
		<br />
	</body>
</html>
