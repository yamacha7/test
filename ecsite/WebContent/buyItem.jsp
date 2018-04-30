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
	<link rel="stylesheet" type="text/css" href="./css/buyItem.css"/>
	<title>buyItem画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>Buyitem</p>
		</div>
		<s:iterator value="#session.itemInfoList" status="st">
		<div class="box">
			<s:form action="CartAction" id="%{#st.index}">
				<table>
					<tr>
						<td>
							<span>商品名</span>
						</td>
						<td>
							<s:property value="itemName"/><br>
							<s:hidden name="buyItemIndex" value="%{#st.index}"/>
							<s:hidden name="buyItemId" value="%{id}"/>
							<s:hidden name="buyItemName" value="%{itemName}"/>
						</td>
					</tr>
					<tr>
						<td>
							<span>値段</span>
						</td>
						<td>
							<s:property value="itemPrice"/><span>円</span>
							<s:hidden name="buyItemPrice" value="%{itemPrice}"/>
						</td>
					</tr>
					<tr>
						<td>
							<span>在庫</span>
						</td>
						<td>
							<s:if test="itemStock>0">
								<s:property value="itemStock"/>
							</s:if>
							<s:else>
								<span>売り切れ</span>
							</s:else>
						</td>
					</tr>
					<tr>
						<td>
							<span>購入個数</span>
						</td>
						<td>
							<select name="count">
								<s:if test="itemStock > 5">
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</s:if>
								<s:elseif test="itemStock>0 && itemStock<=5">
									<option value="1" selected="selected">1</option>
								</s:elseif>
								<s:else>
									<option value="0" selected="selected">0</option>
								</s:else>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<span>支払い方法</span>
						</td>
						<td>
							<input type="radio" name="pay" value="1" checked="checked">現金払い
							<input type="radio" name="pay" value="2">クレジットカード
						</td>
					</tr>
					<tr>
						<s:if test="itemStock>0">
						<td></td>
						<td>
							<s:submit value="カートに入れる"/>
						</td>
						</s:if>
						<s:else>
						<td></td>
						<td><span>売り切れ</span></td>
						</s:else>
					</tr>
				</table>
			</s:form>
			</div>
		</s:iterator>
			<div>
				<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
			</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>