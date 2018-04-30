package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class InsertBuyItemConfirmAction extends ActionSupport implements SessionAware {
	private String itemName;
	private String itemPrice;
	private String itemStock;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;

		boolean itemPriceCheckFlg = itemPrice.matches("^[0-9]*$");
		boolean itemStockCheckFlg = itemStock.matches("^[0-9]*$");

		if(itemName.equals("") || itemPrice.equals("") || itemStock.equals("")){
			setErrorMessage("未入力の項目があります。");
			result = ERROR;

		}else if(!(itemPriceCheckFlg) || !(itemStockCheckFlg)){
			setErrorMessage("価格と在庫数は半角数字で入力してください");
			result = ERROR;

		}else{
			session.put("itemName", itemName);
			session.put("itemPrice", itemPrice);
			session.put("itemStock", itemStock);
		}

		return result;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}


	public String getItemStock() {
		return itemStock;
	}


	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

}
