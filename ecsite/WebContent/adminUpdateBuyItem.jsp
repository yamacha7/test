<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>adminUpdateBuyItem画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>管理者画面</p>
		</div>
		<div>
			<h3>更新したい商品にチェックを入れてください。</h3>
		</div>
		<div class="box">
			<table>
				<tr>
					<th>商品名</th>
					<th>価格</th>
					<th>在庫</th>
					<th>チェックボックス</th>
				</tr>
				<s:iterator value="session.buyItemInfoList" status="st">
					<s:form>
						<tr>
							<td><s:property value="itemName"/></td>
							<td><s:property value="itemPrice"/></td>
							<td><s:property value="itemStock"/></td>
						</tr>
					</s:form>
				</s:iterator>
			</table>
		</div>

		<div id="text-link">
			<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>