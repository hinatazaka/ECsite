package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{
	private String itemname;
	private String itemprice;
	private String itemstock;
	public Map<String,Object>session;
	private ItemCreateCompleteDAO itemCreateCompleteDAO=new ItemCreateCompleteDAO();

	public String execute()throws SQLException{
		itemCreateCompleteDAO.createItem(session.get("itemname").toString(),
				session.get("itemprice").toString(),
			session.get("itemstock").toString());
		String result=SUCCESS;

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

	public ItemCreateCompleteDAO getItemCreateCompleteDAO() {
		return itemCreateCompleteDAO;
	}

	public void setItemCreateCompleteDAO(ItemCreateCompleteDAO itemCreateCompleteDAO) {
		this.itemCreateCompleteDAO = itemCreateCompleteDAO;
	}




}
