package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

	public String execute() throws SQLException{
		userCreateCompleteDAO.createUser(
				session.get("loginUserId").toString(),
				session.get("loginPassword").toString(),
				session.get("userName").toString(),
				session.get("userAddress1").toString(),
				session.get("userAddress2").toString(),
				session.get("sex").toString(),
				session.get("phoneNumber").toString());

		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
