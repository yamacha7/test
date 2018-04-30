package com.internousdev.ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class CartConfirmAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private int cartTotalPrice;

	public String execute(){
		String result = SUCCESS;
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> cartList = (List<Map<String,Object>>) session.get("cartList");
		for(int i = 0; i<cartList.size();i++){
			Map<String,Object> buyItemInfoMap = cartList.get(i);
			int totalPrice = (int) buyItemInfoMap.get("totalPrice");
			cartTotalPrice += totalPrice;
		}
		return result;

	}

	public int getCartTotalPrice(){
		return cartTotalPrice;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
