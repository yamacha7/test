<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ErrorPage</title>
</head>
<body>
	<h1>エラーが発生しました。</h1>
	<p>恐れ入りますが、<a href='<s:url action="HomeAction"/>'>ログイン</a>からやり直してください。</p>
</body>
</html>