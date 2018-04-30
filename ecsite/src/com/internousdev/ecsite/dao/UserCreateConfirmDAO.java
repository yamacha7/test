package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserCreateConfirmDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	String sql = "select * from login_user_transaction where login_id = ?  ";

	public boolean checkUserId(String loginUserId)throws SQLException{
		boolean checkIdFlg = false;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				checkIdFlg = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return checkIdFlg;
	}

}
