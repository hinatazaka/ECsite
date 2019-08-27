package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserDeleteCompleteDAO {
	DBConnector dbConnector=new DBConnector();
	Connection connection=dbConnector.getConnection();

	public int deleteUserInfo(String Loginid) throws SQLException{
		String sql="DELETE FROM login_user_transaction where login_id=?";
		PreparedStatement preparedStatement;
		int result=0;
		try {
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, Loginid);
		result=preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return result;

	}

}
