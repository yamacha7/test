package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql = "insert into login_user_transaction(login_id, login_pass, user_name, master_flg, user_address1, user_address2, user_sex, user_phone_number, insert_date) values(?,?,?,0,?,?,?,?,?)";

	public void createUser(String loginUserId,String loginUserPassword, String userName, String userAddress1, String userAddress2, String sex, String phoneNumber) throws SQLException{
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, userAddress1);
			preparedStatement.setString(5, userAddress2);
			preparedStatement.setString(6, sex);
			preparedStatement.setString(7, phoneNumber);
			preparedStatement.setString(8, dateUtil.getDate());
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}


}
