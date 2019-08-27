package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {
	private DateUtil dateUtil=new DateUtil();
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();

	private String sql="INSERT INTO item_info_transaction(item_name,item_price,item_stock,insert_date)VALUES(?,?,?,?)";

	public void createItem(String itemname,String itemprice,String itemstock)throws
SQLException{
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, itemname);
			preparedStatement.setString(2, itemprice);
			preparedStatement.setString(3, itemstock);
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}


}
