package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{
	private String itemname;
	private String itemprice;
	private String itemstock;
	public Map<String,Object>session;
	private String errorMessage;

	public String execute(){

		String result=SUCCESS;
		if(!(itemname.equals(""))
				&&!(itemprice.equals(""))
				&&!(itemstock.equals(""))){
			session.put("itemname",itemname);
			session.put("itemprice",itemprice);
			session.put("itemstock",itemstock);
		}else{
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
		return result;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemprice() {
		return itemprice;
	}

	public void setItemprice(String itemprice) {
		this.itemprice = itemprice;
	}

	public String getItemstock() {
		return itemstock;
	}

	public void setItemstock(String itemstock) {
		this.itemstock = itemstock;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
