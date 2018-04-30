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
	<title>cartConfirm画面</title>
	<style type="text/css">
		body {
		   margin:0;
		   padding:0;
		   line-height:1.6;
		   letter-spacing:1px;
		   font-family:Verdana, Helvetica, sans-serif;
		   font-size:12px;
		   color:#333;
		   background:#fff;
		}

		table {
			text-align:center;
			margin:0 auto;
			border-collapse:collapse;
		}

		#sum {
			border-top:3px solid black;
		}


		#top {
		   width:780px;
		   margin:30px auto;
		   border:1px solid #333;
		}

		#header {
		   width: 100%;
		   height: 80px;
		   background-color: black;
		}

		#main {
		   width: 100%;
		   height: 500px;
		   text-align: center;
		}

		#footer {
			width: 100%;
			height: 80px;
			background-color: black;
			clear:both;
		}

		#text-center {
			display: inline-block;
			text-align: center;
		}
	</style>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<h1>以下の内容で間違いありませんか?</h1>
		<s:form action="CartCompleteAction">
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
				<tr id="sum">
					<td></td>
					<td></td>
					<td>合計:</td>
					<td><s:property value="cartTotalPrice"/><span>円</span></td>
				</tr>
			</table>
			<input type="submit" value="購入する"/>
		</s:form>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>