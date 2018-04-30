package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private String userAddress1;
	private String userAddress2;
	private String sex;
	private String phoneNumber;
	private List<String> errorMessage;
	private UserCreateConfirmDAO userCreateConfirmDAO = new UserCreateConfirmDAO();

	public String execute(){
		String result = SUCCESS;

		if(!(loginUserId.equals("")) && !(loginPassword.equals("")) && !(userName.equals("")) && !(userAddress2.equals("")) && !(phoneNumber.equals(""))){

			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
			session.put("userAddress1", userAddress1);
			session.put("userAddress2",userAddress2);
			session.put("sex", sex);

			/*
			 * 電話番号が半角数字かチェック。
			 * ()-が含まれていたら、取り除く。
			 */
			errorMessage = new ArrayList<String>();
			phoneNumber = phoneNumber.replaceAll("[()-]", "");
		    boolean numberCheckFlg = phoneNumber.matches("^[0-9]*$");

			if(!numberCheckFlg){
				errorMessage.add("電話番号の入力に誤りがあります。");
				result = ERROR;
			}
			session.put("phoneNumber", phoneNumber);

			/*
			 * 同じIDがすでに存在しないかチェックする。
			 */
			boolean checkIdFlag = false;
			try {
				checkIdFlag = userCreateConfirmDAO.checkUserId(loginUserId);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if(checkIdFlag){
				errorMessage.add("このIDはすでに使用されています。");
				result = ERROR;
			}

		}else{
			errorMessage.add("未入力の項目があります。");
			result = ERROR;
		}
		return result;
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

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserAddress1() {
		return userAddress1;
	}

	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}

	public String getUserAddress2() {
		return userAddress2;
	}

	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public List<String> getErrorMessage(){
		return errorMessage;
	}

	public void setErrorMessage(List<String> errorMessage){
		this.errorMessage = errorMessage;
	}
}
