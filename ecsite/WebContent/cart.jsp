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
	<title>カート画面</title>

</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>Cart</p>
		</div>
		<div>
				<h3>カートの中身は以下になります。</h3>
				<s:form action="CartConfirmAction">
					<table border="1">
						<tr>
							<th>商品名</th>
							<th>単価</th>
							<th>購入個数</th>
							<th>合計金額</th>
						</tr>
						<s:iterator value="session.cartList">
							<tr>
								<td><s:property value="buyItemName"/></td>
								<td><s:property value="buyItemPrice"/><span>円</span></td>
								<td><s:property value="count"/><span>個</span></td>
								<td><s:property value="totalPrice"/><span>円</span></td>
							</tr>
						</s:iterator>
					</table>
					<input type="submit" value="購入する"/>
				</s:form>

			<div id="text-right">
				<p>引き続き買い物をする場合は<a href='<s:url action="GoBuyItemAction"/>'>こちら</a></p>
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