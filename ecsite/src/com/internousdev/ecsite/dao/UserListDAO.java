package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	DBConnector dbconnector=new DBConnector();
	Connection connection= dbconnector.getConnection();

	public ArrayList<UserInfoDTO> getUserListInfo() throws SQLException{
		ArrayList<UserInfoDTO>UserInfoDTO=new ArrayList<UserInfoDTO>();
		String sql="SELECT * FROM login_user_transaction ORDER BY id";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				UserInfoDTO UserInfo=new UserInfoDTO();
				UserInfo.setId(resultset.getString("id"));
				UserInfo.setLoginid(resultset.getString("login_id"));
				UserInfo.setLoginpass(resultset.getString("login_pass"));
				UserInfo.setUsername(resultset.getString("user_name"));
				UserInfo.setInsert_date(resultset.getString("insert_date"));
				UserInfo.setUpdate_date(resultset.getString("update_date"));

				UserInfoDTO.add(UserInfo);
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return UserInfoDTO;
	}

}
