package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class CartCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection =dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String insertSql = "insert into user_buy_item_transaction(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) values(?,?,?,?,?,?)";


	public void insertCartItem(List<Map<String,Object>> cartList, String user_master_id, List<BuyItemDTO> itemInfoList, List<String> checkItemList) throws SQLException{
		try{
			for(int i=0; i<cartList.size()-1; i++){
				insertSql = insertSql.concat(",(?,?,?,?,?,?)");
			}
			insertSql = insertSql.concat(";");

			PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
			String nowDate = dateUtil.getDate();

			//購入履歴を挿入
			int index = 0;
			for(int j=1; j<=cartList.size()*6; j += 6){
				int item_transaction_id =  (int) cartList.get(index).get("buyItemId");
				int total_price = (int) cartList.get(index).get("totalPrice");
				int total_count = (int) cartList.get(index).get("count");
				String pay = (String) cartList.get(index).get("pay");

				preparedStatement.setInt(j, item_transaction_id);
				preparedStatement.setInt(j+1, total_price);
				preparedStatement.setInt(j+2, total_count);
				preparedStatement.setString(j+3, user_master_id);
				preparedStatement.setString(j+4, pay);
				preparedStatement.setString(j+5, nowDate);
				index++;
			}

			//在庫を減少させる
			int checkCount = preparedStatement.executeUpdate();

			if(checkCount >0){
				//カートの要素数分ループを回して、在庫を書き換える。
				for(int i=0; i<checkItemList.size();i++){
					String updateSql = "update item_info_transaction set item_stock = ? where id = ?";
					PreparedStatement ps = connection.prepareStatement(updateSql);
					BuyItemDTO buyItemDTO = itemInfoList.get(Integer.parseInt(checkItemList.get(i)));

					int item_stock = buyItemDTO.getItemStock();
					int id = buyItemDTO.getId();
					ps.setInt(1, item_stock);
					ps.setInt(2, id);
					ps.executeUpdate();
				}

			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

}
