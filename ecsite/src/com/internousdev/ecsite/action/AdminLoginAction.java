package com.internousdev.ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport implements SessionAware{
	private String loginAdminId;
	private String loginAdminPassword;

	public Map<String, Object> session;


	private List<BuyItemDTO> buyItemInfoList;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute(){
		String result = ERROR;

		loginDTO = loginDAO.getLoginUserInfo(loginAdminId, loginAdminPassword);

		if(loginDTO.getLoginFlg() && loginDTO.getMasterFlg()){
			result = SUCCESS;
			buyItemInfoList = buyItemDAO.getAllBuyItemInfo();
			session.put("buyItemInfoList", buyItemInfoList);

			return result;
		}

		return result;
	}


	public String getLoginAdminId(){
		return loginAdminId;
	}

	public void setLoginAdminId(String loginAdminId){
		this.loginAdminId = loginAdminId;
	}

	public String getLoginAdminPassword(){
		return loginAdminPassword;
	}

	public void setLoginAdminPassword(String loginAdminPassword){
		this.loginAdminPassword = loginAdminPassword;
	}


	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}


	public Map<String, Object> getSession() {
		return session;
	}



}



