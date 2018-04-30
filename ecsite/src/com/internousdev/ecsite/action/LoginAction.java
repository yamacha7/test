 package com.internousdev.ecsite.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private List<BuyItemDTO> itemInfoList = new ArrayList<BuyItemDTO>();
	private List<Map<String,Object>> cartList = new ArrayList<Map<String,Object>>();
	private List<String> checkItemList = new ArrayList<String>();


	public String execute(){
		String result =ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;

			//ログインユーザ情報
			session.put("login_user_id", loginDTO.getLoginId());

			//ショッピンッグカート用のリストをセッションに格納。
			session.put("cartList",cartList);

			//buyItem.jspで表示する商品情報を取得し、セッションに格納。
			itemInfoList = buyItemDAO.getAllBuyItemInfo();
			session.put("itemInfoList", itemInfoList);

			//カートに同じアイテムが入っているときの処理用のリスト。
			//カートに入った商品のitemInfoListにおけるインデックスを格納する。
			session.put("checkItemList", checkItemList);

			return result;

		}
		return result;
	}

	public List<BuyItemDTO> getItemInfoList() {
		return itemInfoList;
	}

	public void setItemInfoList(List<BuyItemDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
