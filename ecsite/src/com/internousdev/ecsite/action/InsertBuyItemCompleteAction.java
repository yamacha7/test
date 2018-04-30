package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.InsertBuyItemCompleteDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InsertBuyItemCompleteAction extends ActionSupport implements SessionAware {
	private String itemName;
	private String itemPrice;
	private String itemStock;
	public Map<String, Object> session;
	private List<BuyItemDTO> buyItemInfoList;

	private InsertBuyItemCompleteDAO insertBuyItemCompleteDAO = new InsertBuyItemCompleteDAO();

	public String execute() throws SQLException{
		insertBuyItemCompleteDAO.insertBuyItem(session.get("itemName").toString(),session.get("itemPrice").toString(),session.get("itemStock").toString());

		//セッションの書き換え
		BuyItemDAO buyItemDAO = new BuyItemDAO();
		buyItemInfoList = buyItemDAO.getAllBuyItemInfo();
		session.put("buyItemInfoList", buyItemInfoList);

		String result = SUCCESS;
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
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
