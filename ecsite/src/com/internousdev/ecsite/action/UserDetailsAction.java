package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDetailsDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailsAction extends ActionSupport implements SessionAware{
	private String Loginid;
	private UserInfoDTO userInfoDTO=new UserInfoDTO();
	private Map<String,Object>session;

	public String execute() throws SQLException{
		UserDetailsDAO userDetailsDAO=new UserDetailsDAO();
		userInfoDTO=userDetailsDAO.getUserInfo(Loginid);
		if(userInfoDTO.getLoginid()==null) {
			userInfoDTO=null;
		}
		String result=SUCCESS;
		return result;

	}
	public String getLoginid() {
		return Loginid;
	}

	public void setLoginid(String loginid) {
		Loginid = loginid;
	}

	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}

	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
