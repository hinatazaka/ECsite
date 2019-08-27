package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	DBConnector dbconnector=new DBConnector();
	Connection connection= dbconnector.getConnection();

	public ArrayList<ItemInfoDTO> getItemListInfo(){
		ArrayList<ItemInfoDTO>itemInfoDTO=new ArrayList<ItemInfoDTO>();
		String sql="SELECT * FROM item_info_transaction ORDER BY id";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next()){
				ItemInfoDTO itemInfo=new ItemInfoDTO();
				itemInfo.setId(resultset.getString("id"));
				itemInfo.setItemName(resultset.getString("item_name"));
				itemInfo.setItemPrice(resultset.getString("item_price"));
				itemInfo.setItemstock(resultset.getString("item_stock"));
				itemInfo.setInsert_date(resultset.getString("insert_date"));
				itemInfo.setUpdate_date(resultset.getString("update_date"));
				itemInfoDTO.add(itemInfo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return itemInfoDTO;
	}

}
