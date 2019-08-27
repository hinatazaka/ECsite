package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteConfirmAction extends ActionSupport{
	String Loginid;
	public String execute() {
		return SUCCESS;
	}
	public String getLoginid() {
		return Loginid;
	}
	public void setLoginid(String loginid) {
		Loginid = loginid;
	}

}
