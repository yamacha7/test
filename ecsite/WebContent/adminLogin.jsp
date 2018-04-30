<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
	<title>AdminLogin画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>AdminLogin</p>
		</div>
		<div>
			<h3>管理者画面に入るには管理者IDでログインをしてください。</h3>
			<s:form action="AdminLoginAction">
			<table>
				<tr>
					<td>ログインID:</td>
					<td><s:textfield name="loginAdminId"/></td>
				</tr>
				<tr>
					<td>ログインPASS:</td>
					<td><s:password name="loginAdminPassword"/></td>
				</tr>
				<tr>
					<td></td>
					<td><s:submit value="ログイン"/></td>
				</tr>
			</table>
			</s:form>
			<br>
			<div id="text-link">
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>