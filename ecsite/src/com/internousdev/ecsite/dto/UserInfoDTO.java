package com.internousdev.ecsite.dto;

public class UserInfoDTO {
	private String id;
	private String Loginid;
	private String Loginpass;
	private String Username;
	private String insert_date;
	private String update_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getLoginid() {
		return Loginid;
	}
	public void setLoginid(String loginid) {
		Loginid = loginid;
	}
	public String getLoginpass() {
		return Loginpass;
	}
	public void setLoginpass(String loginpass) {
		Loginpass = loginpass;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}

}
