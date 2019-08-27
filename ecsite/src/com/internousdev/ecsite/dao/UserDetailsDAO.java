package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserDetailsDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	public UserInfoDTO getUserInfo(String Loginid)throws SQLException{
		UserInfoDTO dto=new UserInfoDTO();
		String sql="SELECT * FROM login_user_transaction WHERE login_id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,Loginid);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				dto.setId(resultSet.getString("id"));
				dto.setLoginid(resultSet.getString("login_id"));
				dto.setLoginpass(resultSet.getString("login_pass"));
				dto.setUsername(resultSet.getString("user_name"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setUpdate_date(resultSet.getString("update_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return dto;
	}

}
