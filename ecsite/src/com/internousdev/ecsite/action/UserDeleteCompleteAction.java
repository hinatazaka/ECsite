package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteCompleteAction extends ActionSupport{
	private String Loginid;
	private String message;
	public String execute() throws SQLException{
		String result=ERROR;
		UserDeleteCompleteDAO userDeleteCompleteDAO=new UserDeleteCompleteDAO();
		int res=userDeleteCompleteDAO.deleteUserInfo(Loginid);
		if(res>0) {
			setMessage("ユーザー情報を正しく削除しました。");
		}else {
			setMessage("ユーザー情報の削除に失敗しました。");
		}
		result=SUCCESS;
		return result;

	}
	public String getLoginid() {
		return Loginid;
	}
	public void setLoginid(String loginid) {
		Loginid = loginid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
