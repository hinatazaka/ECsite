package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{
	String message;
	public String execute() throws SQLException{
		String result=ERROR;
		UserListDeleteCompleteDAO userListDeleteCompleteDAO=new UserListDeleteCompleteDAO();
		int res=userListDeleteCompleteDAO.deleteUserList();
		if(res>0) {
			setMessage("ユーザーを削除しました。");
		}else {
			setMessage("ユーザーの削除に失敗しました。");
		}
		result=SUCCESS;
		return result;

	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
