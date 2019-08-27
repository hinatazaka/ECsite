package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;


public class LoginDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private LoginDTO loginDTO=new LoginDTO();
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
                    //メソッドの呼び出し
		String sql="SELECT * FROM login_user_transaction where login_id=?AND login_pass=?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

			preparedStatement.setString(1,loginUserId);
			preparedStatement.setString(2,loginPassword);

			ResultSet resultSet=preparedStatement.executeQuery();

			if(resultSet.next()){
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setAdminFlg(resultSet.getString("admin_flg"));

				if(resultSet.getString("login_id")!=null){
					loginDTO.setLoginFlg(true);
				}//trueの値を持つ
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return loginDTO;
	}

}
