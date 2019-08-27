package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private UserListDAO UserListDAO=new UserListDAO();
	private ArrayList<UserInfoDTO> UserList= new ArrayList<UserInfoDTO>();
	public String execute() throws SQLException{
		UserList=UserListDAO.getUserListInfo();
		String result=SUCCESS;
		return result;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public UserListDAO getUserListDAO() {
		return UserListDAO;
	}
	public void setUserListDAO(UserListDAO userListDAO) {
		UserListDAO = userListDAO;
	}
	public ArrayList<UserInfoDTO> getUserList() {
		return UserList;
	}
	public void setUserList(ArrayList<UserInfoDTO> userList) {
		UserList = userList;
	}

}
