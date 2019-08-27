package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {
	DBConnector dbConnector=new DBConnector();
	Connection connection=dbConnector.getConnection();

	public int deleteItemList()throws SQLException{
		String sql="DELETE FROM item_info_transaction";
		int result=0;
		try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		result=preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return result;
	}

}
