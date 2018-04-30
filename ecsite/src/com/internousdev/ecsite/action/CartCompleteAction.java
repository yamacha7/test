package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartCompleteDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartCompleteAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private CartCompleteDAO cartCompleteDAO = new CartCompleteDAO();

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException{
		List<Map<String, Object>> cartList = (List<Map<String, Object>>) session.get("cartList");
		String login_user_id = session.get("login_user_id").toString();
		List<BuyItemDTO> itemInfoList = (List<BuyItemDTO>) session.get("itemInfoList");
		List<String> checkItemList = (List<String>) session.get("checkItemList");

		cartCompleteDAO.insertCartItem(cartList, login_user_id, itemInfoList, checkItemList);

		//カートの中身を空にする。
		cartList.clear();
		checkItemList.clear();
		session.put("cartList", cartList);
		session.put("checkItemList", checkItemList);

		String result = SUCCESS;
		return result;
	}


	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
