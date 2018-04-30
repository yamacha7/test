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
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<title>Admin画面</title>
	<style>
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
			border-collapse:collapse;
			text-align:center;
			margin:0 auto;
			border:1px solid black;
		}

		tr {
			border:1px solid black;
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
		<div id="top">
			<p>管理者画面</p>
		</div>
		<h1>商品一覧</h1>
		<div class="box">
			<table>
				<tr>
					<th>商品名</th>
					<th>価格</th>
					<th>在庫</th>
				</tr>
				<s:iterator value="session.buyItemInfoList">
					<tr>
						<td><s:property value="itemName"/></td>
						<td><s:property value="itemPrice"/></td>
						<td><s:property value="itemStock"/></td>
					</tr>
				</s:iterator>
			</table>
		</div>

		<div id="text-link">
			<p><a href='<s:url action="InsertBuyItemAction"/>'>商品情報を追加する</a></p>
<%-- 			<p><a href='<s:url action="AdminUpdateBuyItemAction"/>'>商品情報を更新する</a></p> --%>
			<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>