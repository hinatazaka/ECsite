package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private ItemListDAO itemListDAO=new ItemListDAO();
	private ArrayList<ItemInfoDTO>itemList=new ArrayList<ItemInfoDTO>();
    public String execute() throws SQLException{
			itemList=itemListDAO.getItemListInfo();
		String result=SUCCESS;
		return result;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ItemListDAO getItemListDAO() {
		return itemListDAO;
	}
	public void setItemListDAO(ItemListDAO itemListDAO) {
		this.itemListDAO = itemListDAO;
	}
	public ArrayList<ItemInfoDTO> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ItemInfoDTO> itemList) {
		this.itemList = itemList;
	}

}
