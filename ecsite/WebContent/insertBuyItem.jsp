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
	<title>InsertBuyItem画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>InsertBuyItem</p>
		</div>
		<div>
			<s:if test="errorMessage != ''">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<table>
				<s:form action="InsertBuyItemConfirmAction">
				<tr>
					<td>
						<label>商品名:</label>
					</td>
					<td>
						<input type="text" name="itemName" value=""/>
					</td>
				</tr>
				<tr>
					<td>
						<label>価格:</label>
					</td>
					<td>
						<input type="text" name="itemPrice" value=""/>
					</td>
				</tr>
				<tr>
					<td>
						<label>在庫数:</label>
					</td>
					<td>
						<input type="text" name="itemStock" value=""/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><s:submit value="追加"/></td>
				</tr>

				</s:form>
			</table>
			<div>
				<span>前画面に戻る場合は</span>
				<a href='<s:url action="HomeAction"/>'>こちら</a>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>